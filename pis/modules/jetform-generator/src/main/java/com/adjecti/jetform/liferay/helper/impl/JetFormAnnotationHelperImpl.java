package com.adjecti.jetform.liferay.helper.impl;

import com.adjecti.common.util.AnnotationUtil;
import com.adjecti.common.util.FormEntityCache;
import com.adjecti.common.util.ReflectionUtil;
import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlElementGroup;
import com.adjecti.jetform.annotation.HtmlElementGroupWrapper;
import com.adjecti.jetform.annotation.HtmlElementGroups;
import com.adjecti.jetform.annotation.HtmlElementRuleGroups;
import com.adjecti.jetform.annotation.HtmlElementWrapper;
import com.adjecti.jetform.annotation.HtmlEvent;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormAction;
import com.adjecti.jetform.annotation.HtmlFormActionWrapper;
import com.adjecti.jetform.annotation.HtmlFormFlow;
import com.adjecti.jetform.annotation.HtmlFormWrapper;
import com.adjecti.jetform.liferay.helper.JetFormAnnotationHelper;
import com.adjecti.jetform.liferay.helper.JetFormDataHelper;
import com.adjecti.jetform.liferay.model.FormDefinition;
import com.adjecti.jetform.liferay.service.FormDefinitionLocalServiceUtil;
import com.adjecti.jetform.liferay.util.JetFormDataUtil;
import com.adjecti.jetform.liferay.util.JetFormUtil;
import com.adjecti.jetform.model.Document;
import com.adjecti.jetform.model.KeyValue;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.nio.intraband.proxy.annotation.Id;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = JetFormAnnotationHelper.class)
public class JetFormAnnotationHelperImpl implements JetFormAnnotationHelper {
	
	
final static Log LOGGER = LogFactoryUtil.getLog(JetFormAnnotationHelperImpl.class.getName());

	
	private HtmlFormWrapper getHtmlFormByClass(String className) throws ClassNotFoundException {
		Class formClass = FormEntityCache.getFormClass(className);
		if (formClass == null) {
			try {
				formClass = ClassUtils.getClass(className);
				FormEntityCache.registerFormClass(formClass);
			} catch (Exception e) {
				LOGGER.error(e.getMessage() + ". " + className + " no found.");
			}
		}
		JetFormUtil.validate();
		if (formClass != null) {
			return getHtmlFormByClass(formClass);
		}
		return null;

	}

	@Override
	public void generateForm(String formClass) throws ClassNotFoundException {
		LOGGER.info(formClass);
		FormDefinition formDefination = FormDefinitionLocalServiceUtil.getFormDefinationByFormClass(formClass);
		JSONObject jsonFormData = getHtmlFormJSONByClass(formClass);
		
		if (formDefination == null) {
			FormDefinition newFormDefinition = FormDefinitionLocalServiceUtil
					.createFormDefinition(CounterLocalServiceUtil.increment());
			newFormDefinition.setDefinition(jsonFormData.toString());
			newFormDefinition.setEntityClass(jsonFormData.getString("entityClass"));
			newFormDefinition.setFormKey(jsonFormData.getString("formKey"));
			newFormDefinition.setFormClass(jsonFormData.getString(formClass));
			FormDefinitionLocalServiceUtil.addFormDefinition(newFormDefinition);
		} else {
			formDefination.setDefinition(jsonFormData.toString());
			formDefination.setEntityClass(jsonFormData.getString("entityClass"));
			formDefination.setFormKey(jsonFormData.getString("formKey"));
			formDefination.setFormClass(jsonFormData.getString(formClass));
			FormDefinitionLocalServiceUtil.updateFormDefinition(formDefination);
		}

	}
	
	
	
	
	
	private JSONObject getHtmlFormJSONByClass(String className) throws ClassNotFoundException {
		Class formClass = FormEntityCache.getFormClass(className);
		HtmlFormWrapper form = getHtmlFormByClass(formClass);
		System.out.println("form"+ form);
		
		String jsonStr = JSONFactoryUtil.looseSerializeDeep(form);
		//JSONFactoryUtil.serialize(form);
		
		try {
			return JSONFactoryUtil.createJSONObject(jsonStr);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return JSONFactoryUtil.createJSONObject();
	}
	
	

	
	private HtmlFormWrapper getHtmlFormByClass(Class<?> formClass) throws ClassNotFoundException {
		
		HtmlFormWrapper form = getHtmlForm(formClass);
		Class entClass = FormEntityCache.getFormClass(form.getEntityClass());
		
		Object model = JetFormDataUtil.createNewEntity(entClass);

		form.setEntity(model);

		JetFormUtil.validate();

		return form;

	}

	
	private HtmlFormWrapper getHtmlForm(Class<?> clazz) throws ClassNotFoundException {
		
		HtmlFormWrapper form = null;
		if (clazz.isAnnotationPresent(HtmlForm.class)) {
			HtmlForm formAttn = clazz.getAnnotation(HtmlForm.class);
			form = getHtmlForm(clazz, formAttn);
		} else if (clazz.isAnnotationPresent(ImplementationClassName.class)) {

			form = getHtmlFormFromProperties(clazz);
		} else {

			return null;
		}

		// form = null;// formFactoryCache.get(formAttn.formId()); //commented
		// temporarily.

		if (form != null) {
			form.setEntity(null);
		}

		return form;
	}

	
	

	private HtmlFormWrapper getHtmlForm(Class<?> clazz, HtmlForm formAttn) {
		HtmlFormWrapper form = new HtmlFormWrapper(clazz.getSimpleName(), formAttn);
		boolean isEditPresent = false;
		boolean isDeletePresent = false;
		boolean isAddPresent = false;
		if (!form.isReadOnly()) {
			HtmlFormActionWrapper editAction = new HtmlFormActionWrapper(HtmlFormAction.ACTION_EDIT,
					HtmlFormAction.ACTION_EDIT, "<i class=\"fas fa-edit\"></i>", "button", "row");
			HtmlFormActionWrapper deleteAction = new HtmlFormActionWrapper(HtmlFormAction.ACTION_DELETE,
					HtmlFormAction.ACTION_DELETE, "<i class=\"fas fa-trash\"></i>", "button", "row");
			HtmlFormActionWrapper addAction = new HtmlFormActionWrapper(HtmlFormAction.ACTION_ADD,
					HtmlFormAction.ACTION_ADD, "<i class=\"fas fa-plus\"></i>", "button", "table");

			for (HtmlFormActionWrapper action : form.getActions()) {
				if (action.getName().contains(editAction.getName())) {
					isEditPresent = true;
				} else if (action.getName().contains(deleteAction.getName())) {
					isDeletePresent = true;
				} else if (action.getName().contains(addAction.getName())) {
					isAddPresent = true;
				}

			}

			if (!isDeletePresent) {
				form.getActions().add(0, deleteAction);
			}
			if (!isEditPresent) {
				form.getActions().add(0, editAction);
			}

			if (!isAddPresent) {
				form.getActions().add(0, addAction);
			}

		}
		if (formAttn != null && !formAttn.enabled()) {
			return null;
		}

		List<HtmlElementWrapper> elements = new ArrayList<HtmlElementWrapper>();

		if (formAttn.elements().length > 0 || formAttn.groups().length > 0) {
			elements = getElementsFromClassAnnotation(clazz, formAttn, form);
		} else {
			elements = getElementsFromPropertyAnnotation(clazz, formAttn, form);
		}
		if (elements.size() == 0) {
			elements = getElementsFromClassAnnotation(clazz, formAttn, form, true);
		}
		form.setElements(elements);

		return form;
	}

	private HtmlFormWrapper getHtmlFormFromProperties(Class<?> clazz) {

		HtmlFormWrapper form = new HtmlFormWrapper();
		
		form.setId(clazz.getSimpleName() + "_12345");
		form.setTitle(clazz.getSimpleName());
		form.setEntityClass(clazz.getName());
		form.setFormClass(clazz.getName());

		ResourceBundle bundle = null;
		try {
			bundle = ResourceBundle.getBundle("content/" + clazz.getSimpleName(), Locale.getDefault(),
					clazz.getClassLoader());
		} catch (Exception ex) {
		}

		List<HtmlElementWrapper> elements = getHtmlElementsFromProperties(form, bundle);

		form.setElements(elements);

		form.getActions().add(new HtmlFormActionWrapper(HtmlFormAction.ACTION_ADD, "", "", "", "table"));
		form.getActions().add(new HtmlFormActionWrapper(HtmlFormAction.ACTION_EDIT, "", "", "", "row"));
		form.getActions().add(new HtmlFormActionWrapper(HtmlFormAction.ACTION_DELETE, "", "", "", "row"));

		return form;
	}

	private List<HtmlElementWrapper> getElementsFromClassAnnotation(Class<?> clazz, HtmlForm formAttn,
			HtmlFormWrapper form) {
		HtmlFormFlow formFlowAttn = (clazz.getAnnotation(HtmlFormFlow.class));
		HtmlElementGroups formElementGroupsAttn = (clazz.getAnnotation(HtmlElementGroups.class));
		HtmlElementRuleGroups formRuleGroupsAttn = (clazz.getAnnotation(HtmlElementRuleGroups.class));
		Class entClass = FormEntityCache.getFormClass(form.getEntityClass());
		
//		form.setFlowControl(formFlowAttn);
		ResourceBundle bundle = null;
		try {
			bundle = ResourceBundle.getBundle("content/" + clazz.getSimpleName(), Locale.getDefault(),
					clazz.getClassLoader());
		} catch (Exception e) {
		}
		if (bundle == null) {
			try {
				bundle = ResourceBundle.getBundle("content/" + entClass.getSimpleName(),
						Locale.getDefault(), clazz.getClassLoader());
			} catch (Exception e) {
			}
		}

		if (formAttn != null && formAttn.groups() != null && formAttn.groups().length > 0) {
			for (HtmlElementGroup g : formAttn.groups()) {
				HtmlElementGroupWrapper group = new HtmlElementGroupWrapper(g);
				group.setElements(getHtmlElements(form, group, g.elements()));
				form.addElementGroup(group);
			}
			form.setGroupAlignment(formAttn.groupAlignment());
		} else {
			if (formElementGroupsAttn != null && formElementGroupsAttn.value() != null
					&& formElementGroupsAttn.value().length > 0) {
				for (HtmlElementGroup g : formElementGroupsAttn.value()) {
					HtmlElementGroupWrapper group = new HtmlElementGroupWrapper(g);
					form.addElementGroup(group);
				}
				form.setGroupAlignment(formElementGroupsAttn.alignment());
			}
		}

		if (formRuleGroupsAttn != null && formRuleGroupsAttn.value() != null && formRuleGroupsAttn.value().length > 0) {
			form.setRuleGroups(formRuleGroupsAttn.value());
		}

		/*
		 * Class modelClazz = clazz;
		 * 
		 * if (!form.getFormClass().equals(form.getModelClass())) { try { modelClazz =
		 * Class.forName(form.getModelClass()); } catch (ClassNotFoundException e) {
		 * e.printStackTrace(); } }
		 */

		List<HtmlElementWrapper> elements = getHtmlElements(form, formAttn.elements(), bundle);

		form.setElements(elements);

		return elements;

	}

	private List<HtmlElementWrapper> getElementsFromPropertyAnnotation(Class<?> clazz, HtmlForm formAttn,
			HtmlFormWrapper form) {
		List<HtmlElementWrapper> elements = new ArrayList<HtmlElementWrapper>();
		// HtmlFormFlow formFlowAttn = (clazz.getAnnotation(HtmlFormFlow.class));
		HtmlElementGroups formElementGroupsAttn = (clazz.getAnnotation(HtmlElementGroups.class));
		HtmlElementRuleGroups formRuleGroupsAttn = (clazz.getAnnotation(HtmlElementRuleGroups.class));
		boolean idElementAdded = false;
		Class entClass = FormEntityCache.getFormClass(form.getEntityClass());
		
//		form.setFlowControl(formFlowAttn);

		ResourceBundle bundle = null;
		try {
			bundle = ResourceBundle.getBundle("content/" + clazz.getSimpleName(), Locale.getDefault(),
					clazz.getClassLoader());
		} catch (Exception ex) {
		}
		if (bundle == null) {
			try {
				bundle = ResourceBundle.getBundle("content/" + entClass.getSimpleName(),
						Locale.getDefault(), clazz.getClassLoader());
			} catch (Exception e) {
			}
		}
		if (formAttn != null && formAttn.groups() != null && formAttn.groups().length > 0) {
			for (HtmlElementGroup group : formAttn.groups()) {
				form.addElementGroup(new HtmlElementGroupWrapper(group));
			}
			form.setGroupAlignment(formAttn.groupAlignment());
		} else {
			if (formElementGroupsAttn != null && formElementGroupsAttn.value() != null
					&& formElementGroupsAttn.value().length > 0) {
				for (HtmlElementGroup group : formElementGroupsAttn.value()) {
					form.addElementGroup(new HtmlElementGroupWrapper(group));
				}
				form.setGroupAlignment(formElementGroupsAttn.alignment());
			}
		}

		if (formRuleGroupsAttn != null && formRuleGroupsAttn.value() != null && formRuleGroupsAttn.value().length > 0) {
			form.setRuleGroups(formRuleGroupsAttn.value());
		}

		// int i = 0;
		boolean fileElementFound = false;
		for (Field field : entClass.getDeclaredFields()) {
			String modifiers = Modifier.toString(field.getModifiers());
			if (modifiers.contains("") || modifiers.contains("transient") || modifiers.contains("final")
					|| modifiers.contains("volatile")) {
				continue;
			}
			HtmlElementWrapper element = null;
			HtmlElement elementAttn = null;

			if (field.isAnnotationPresent(HtmlElement.class)) {
				elementAttn = (field.getAnnotation(HtmlElement.class));
			}

			if (elementAttn != null) {
				if (elementAttn.transientElement()) {
					continue;
				}
				element = new HtmlElementWrapper(field.getName(), elementAttn);
			} else {
				element = new HtmlElementWrapper(field.getName());
			}

			if (field.getType() == Boolean.class) {
				element.setControlType(ControlType.checkbox.name());
			}

			if (elementAttn != null && (elementAttn.controlType() == ControlType.form
					|| field.isAnnotationPresent(HtmlForm.class) || elementAttn.controlType() == ControlType.list)) {
				if (AnnotationUtil.isCollectionType(field.getType())) {
					element.setControlType(ControlType.list.name());
				} else {
					element.setControlType(ControlType.form.name());
				}
				element.setDataType(field.getType().getName());
				element.setParentForm(getHtmlForm(field));
				elements.add(element);
				continue;
			}

			if (field.getType() == List.class || field.getType() == Set.class) {
				ParameterizedType pType = (ParameterizedType) field.getGenericType();
				Type[] types = pType.getActualTypeArguments();
				if (types != null && types.length > 0) {
					element.setDataType(((Class) types[0]).getName());

					if (elementAttn != null && element.isControlType(ControlType.list)) {
						element.setParentForm(getHtmlForm(((Class) types[0]).getName()));
					} else {
						// element.setRelationClass(((Class) types[0]).getName());
					}
				}

			} else {
				element.setDataType(field.getType().getName());
			}

			if (elementAttn != null) {
				if (elementAttn.options() != null && elementAttn.options().length > 0) {
					for (String s : elementAttn.options()) {
						String[] kv = s.split(":");
						element.addListOption(new KeyValue(kv[0], kv[1]));
					}
				}
				if (elementAttn.rules() != null) {
					element.setRules(elementAttn.rules());
				}
				element.setReadOnly(elementAttn.readOnly() ? "readonly" : "");

				if (element.isControlType(ControlType.select)) {
					/*
					 * if ((element.isRelation(RelationType.None) ||
					 * StringUtils.isEmpty(element.getRelation())) &&
					 * !AnnotationUtil.isAlphaNumericType(field.getType()) &&
					 * !AnnotationUtil.isCollectionType(field.getType())) {
					 * element.setRelation(RelationType.One.name()); }
					 */
					if (StringUtils.isEmpty(element.getListField())) {
						element.setListField("name");
						element.setListable(true);
					}
				}

				if (element.isDataType(Date.class)) {
					if (element.isControlType(ControlType.text)) {
						element.setControlType(ControlType.date.name());
					}
				}
			} else {
				boolean keyField = false;
				String fieldName = field.getName();
				if (!idElementAdded) {
					if (field.isAnnotationPresent(Id.class)) {
						element.setControlType(ControlType.hidden.name());
						idElementAdded = true;
						keyField = true;
					} else {
						Method method;
						try {
							method = entClass.getMethod("get" + StringUtils.capitalize(fieldName),
									new Class[] {});
							if (method.isAnnotationPresent(Id.class)) {
								element.setControlType(ControlType.hidden.name());
								idElementAdded = true;
								keyField = true;
							}
						} catch (NoSuchMethodException e) {
							e.printStackTrace();
						} catch (SecurityException e) {
							e.printStackTrace();
						}
					}
				}
				element.setKey(keyField);
				// Setting up field label
				if (!keyField) {

					boolean listable = element.isListable();
					// String relationClass = element.getRelationClass();
					// RelationType relationType = RelationType.None;
					ControlType elementType = ControlType.text;
					if (field.getType() == Date.class) {
						elementType = ControlType.date;
					} else if (field.getType() == Date.class) {
						elementType = ControlType.datetime;
					} else if (field.getType() == Boolean.class) {
						elementType = ControlType.checkbox;
					} else if (AnnotationUtil.isCollectionType(field.getType())) {
						listable = false;
						elementType = ControlType.multiSelect;
						// relationType = RelationType.Many;
					} else if (field.getType() == Document.class) {
						elementType = ControlType.fileUpload;
						fileElementFound = true;
					} else if (AnnotationUtil.isDescriptiveType(field)) {
						elementType = ControlType.textarea;
					} else if (AnnotationUtil.isFixedSelectionType(field)) {
						elementType = ControlType.select;
						List<KeyValue> options = AnnotationUtil.getFixedSelectOptions(element.getName());
						element.setListOptions(options);
					} else if (!AnnotationUtil.isAlphaNumericType(field.getType())) {
						elementType = ControlType.select;
						// relationType = RelationType.One;
						listable = false;
					}

					element.setControlType(elementType.name());
					element.setListable(listable);
					element.setLabel(AnnotationUtil.getItemLabel(fieldName));

				}

				// ########Setting label from resource bundle;
				try {
					if (bundle != null) {
						String bundleLabel = bundle.getString(clazz.getSimpleName() + ".fields." + field.getName());
						System.out.println(clazz.getSimpleName() + ".fields." + field.getName() + ": " + bundleLabel);
						if (StringUtils.isNotEmpty(bundleLabel)) {
							element.setLabel(bundleLabel);
						}
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}

			HtmlElementRuleGroups elementRuleGroupsAttn = (field.getAnnotation(HtmlElementRuleGroups.class));

			if (elementRuleGroupsAttn != null) {
				if (elementRuleGroupsAttn.value() != null && elementRuleGroupsAttn.value().length > 0) {
					element.setRuleGroups(elementRuleGroupsAttn.value());
				}
			} /*
				 * else{ HtmlElementRuleGroups ruleGroupsAnnotation =
				 * (field.getAnnotation(HtmlElementRuleGroups.class));
				 * if(ruleGroupsAnnotation!=null && ruleGroupsAnnotation.value()!=null &&
				 * ruleGroupsAnnotation.value().length>0){
				 * element.setRuleGroups(ruleGroupsAnnotation.value()); } }
				 */

			if (element.isNumericDataType()) {
				element.setDefaultValue("0");
			}
			elements.add(element);
		}

		form.setElements(elements);

		if (fileElementFound) {
			form.setEncType(HtmlForm.ENC_TYPE_MULTIPART);
		}
		return elements;
	}

	private List<HtmlElementWrapper> getElementsFromClassAnnotation(Class<?> clazz, HtmlForm formAttn,
			HtmlFormWrapper form, boolean autoLoadFields) {
		ResourceBundle bundle = null;
		Class entClass = FormEntityCache.getFormClass(form.getEntityClass());
		
		try {
			bundle = ResourceBundle.getBundle("content/" + clazz.getSimpleName(), Locale.getDefault(),
					clazz.getClassLoader());
		} catch (Exception e) {
		}
		if (bundle == null) {
			try {
				bundle = ResourceBundle.getBundle("content/" + entClass.getSimpleName(),
						Locale.getDefault(), clazz.getClassLoader());
			} catch (Exception e) {
			}
		}
		/*
		 * Class modelClazz = clazz;
		 * 
		 * if (!form.getFormClass().equals(form.getModelClass())) { try { modelClazz =
		 * Class.forName(form.getModelClass()); } catch (ClassNotFoundException e) {
		 * e.printStackTrace(); } }
		 */

		List<HtmlElementWrapper> elements = getHtmlElements(form, true);

		form.setElements(elements);

		return elements;

	}

	private List<HtmlElementWrapper> getHtmlElementsFromProperties(HtmlFormWrapper form, ResourceBundle bundle) {
		List<HtmlElementWrapper> elements = new ArrayList<HtmlElementWrapper>();
		
		Class<?> entityClazz = FormEntityCache.getFormClass(form.getEntityClass());
		Method[] methods = entityClazz.getMethods();
		HtmlElementWrapper descriptionElement = null;
		HtmlElementWrapper remarkElement = null;
		HtmlElementWrapper commentElement = null;
		HtmlElementWrapper statusElement = null;
		HtmlElementWrapper deletedElement = null;

		for (Method method : methods) {
			if (!method.getName().startsWith("get")) {
				continue;
			}
			String attributeName = ReflectionUtil.getAttributeFromAccessorMethod(method);
			if (JetFormUtil.excludeAttributeList.contains(attributeName)) {
				continue;
			}
			String modifiers = Modifier.toString(method.getModifiers());
			if (modifiers.contains("final") || modifiers.contains("static")) {
				continue;
			}

			HtmlElementWrapper element = new HtmlElementWrapper(attributeName, method, entityClazz);

			if (attributeName.equalsIgnoreCase("name") || attributeName.equalsIgnoreCase("code")) {
				element.setRequired(true);
				element.setUnique(true);
			}
/*
			RelationWrapper relation = element.getRelation();
			if (relation != null && !relation.isNon()) {
				if (relation.getModelClass() == null) {
					String modelClassSimpleName = attributeName.substring(0, attributeName.length() - 2);
					//Class relationModelClass = FormEntityCache.getFormClassBySimpleName(modelClassSimpleName);
					relation.setModelClass(modelClassSimpleName);
				}

				if (StringUtils.isEmpty(element.getDepends())) {
					List<KeyValue> listOptions = JetFormDataUtil.getListOptions(element.getRelation());
					element.setListOptions(listOptions);
				}
			}
		*/	
			try {
				if (bundle != null) {
					String bundleLabel = null;
					try {
						bundleLabel = bundle
								.getString(entityClazz.getSimpleName() + ".fields." + element.getName());
					} catch (Exception ex1) {
					}

					try {
						if (bundleLabel == null) {
							bundleLabel = bundle
									.getString(entityClazz.getSimpleName() + ".fields." + element.getName());
						}
					} catch (Exception ex1) {
					}

					if (StringUtils.isNotEmpty(bundleLabel)) {
						element.setLabel(bundleLabel);
					}
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			/*
			 * boolean key=false; String relationName=null; String relationClassName=null;
			 * if(attributeName.toLowerCase().endsWith("id")) {
			 * relationName=attributeName.substring(0, attributeName.length()-2);
			 * relationName=StringUtils.capitalize(relationName);
			 * if(relationName.equals(formClazz.getSimpleName())) { key=true; } if(!key) {
			 * relationClassName=formClazz.getPackage().getName()+"."+relationName; }
			 * 
			 * }
			 */

			// This to add descriptive elements at the bottom

			if (element.getName().toLowerCase().contains("description")) {
				descriptionElement = element;
			} else if (element.getName().toLowerCase().contains("remark")) {
				remarkElement = element;
			} else if (element.getName().toLowerCase().contains("comment")) {
				commentElement = element;
			} else if (element.getName().equalsIgnoreCase("status")) {
				statusElement = element;
			} else if (element.getName().equalsIgnoreCase("deleted")) {
				deletedElement = element;
			} else {
				elements.add(element);
			}
		}
		// This to add descriptive elements at the bottom
		if (remarkElement != null) {
			elements.add(remarkElement);
		}
		if (commentElement != null) {
			elements.add(commentElement);
		}
		if (descriptionElement != null) {
			elements.add(descriptionElement);
		}
		/*
		 * if(statusElement!=null) { elements.add(statusElement); }
		 */

		if (deletedElement != null) {
			elements.add(deletedElement);
		}
		return elements;
	}

	private List<HtmlElementWrapper> getHtmlElements(HtmlFormWrapper form, HtmlElementGroupWrapper group,
			HtmlElement[] elementAttns) {
		List<HtmlElementWrapper> elements = new ArrayList<HtmlElementWrapper>();
		boolean fileElementFound = false;
		for (HtmlElement elementAttn : elementAttns) {

			if (elementAttn.transientElement()) {
				continue;
			}

			if (elementAttn.controlType() == ControlType.fileUpload && !fileElementFound) {
				fileElementFound = true;
			}
			HtmlElementWrapper element = new HtmlElementWrapper(elementAttn.name(), elementAttn);

			if (elementAttn != null && (elementAttn.controlType() == ControlType.form
					|| elementAttn.controlType() == ControlType.list)) {
				// element.setControlType(elementAttn.type().name());
				// element.setDataType(field.getType().getName());
				// element.setFormDefinition(getHtmlForm(field));
				elements.add(element);
				continue;
			}

			if (elementAttn.options() != null && elementAttn.options().length > 0) {
				for (String s : elementAttn.options()) {
					String[] kv = s.split(":");
					element.addListOption(new KeyValue(kv[0], kv[1]));
				}
			}

			if (elementAttn.events() != null && elementAttn.events().length > 0) {
				for (HtmlEvent event : elementAttn.events()) {
					element.addEvent(event);
				}
			}
			if (elementAttn.rules() != null) {
				element.setRules(elementAttn.rules());
			}
			if (element.isControlType(ControlType.select) || element.isControlType(ControlType.checkbox)
					|| element.isControlType(ControlType.radio)) {

				if (StringUtils.isEmpty(element.getListField())) {
					element.setListField("name");
					element.setListable(true);
				}
				/*
				 * if (element.getRelation() != null) { if
				 * (StringUtils.isEmpty(element.getDepends())) { List<KeyValue> listOptions =
				 * JetFormDataUtil.getListOptions(element.getRelation());
				 * element.setListOptions(listOptions); } else {
				 * 
				 * } }
				 */
			}

			elements.add(element);
		}
		if (fileElementFound) {
			form.setEncType(HtmlForm.ENC_TYPE_MULTIPART);
		}
		return elements;
	}

	private List<HtmlElementWrapper> getHtmlElements(HtmlFormWrapper form, HtmlElement[] elementAttns,
			ResourceBundle bundle) {
		Class entClass = FormEntityCache.getFormClass(form.getEntityClass());
		
		List<HtmlElementWrapper> elements = new ArrayList<HtmlElementWrapper>();
		boolean fileElementFound = false;
		for (HtmlElement elementAttn : elementAttns) {

			if (elementAttn.transientElement()) {
				continue;
			}

			if (elementAttn.controlType() == ControlType.fileUpload && !fileElementFound) {
				fileElementFound = true;
			}
			HtmlElementWrapper element = new HtmlElementWrapper(elementAttn.name(), elementAttn);

			/*
			 * if (elementAttn != null && (elementAttn.controlType() == ControlType.form ||
			 * elementAttn.controlType() == ControlType.list)) { continue; }
			 */

			/*
			 * if (element.getRelation() != null && !element.getRelation().isNon()) { if
			 * (StringUtils.isEmpty(element.getDepends())) { List<KeyValue> listOptions =
			 * JetFormDataUtil.getListOptions(element.getRelation());
			 * element.setListOptions(listOptions); } else {
			 * 
			 * } }
			 */
			try {
				if (bundle != null) {
					String bundleLabel = null;
					try {
						bundleLabel = bundle
								.getString(entClass + ".fields." + element.getName());
					} catch (Exception ex1) {
					}

					try {
						if (bundleLabel == null) {
							bundleLabel = bundle
									.getString(entClass.getSimpleName() + ".fields." + element.getName());
						}
					} catch (Exception ex1) {
					}

					if (StringUtils.isNotEmpty(bundleLabel)) {
						element.setLabel(bundleLabel);
					}
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			elements.add(element);
		}
		if (fileElementFound) {
			form.setEncType(HtmlForm.ENC_TYPE_MULTIPART);
		}
		return elements;
	}

	private HtmlFormWrapper getHtmlForm(Field field) {
		HtmlFormWrapper form = null;
		if (AnnotationUtil.isCollectionType(field.getType())) {
			ParameterizedType pType = (ParameterizedType) field.getGenericType();
			Type[] types = pType.getActualTypeArguments();
			if (types != null && types.length > 0) {
				form = getHtmlForm(((Class) types[0]), (HtmlForm) null);
			}
		} else if (field.isAnnotationPresent(HtmlForm.class)) {
			form = getHtmlForm(field.getType(), (field.getAnnotation(HtmlForm.class)));
		} else {
			form = getHtmlForm(field.getType(), (HtmlForm) null);
		}
		return form;
	}

	
	private HtmlFormWrapper getHtmlForm(String className) {
		try {
			return getHtmlFormByClass(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	private List<HtmlElementWrapper> getHtmlElements(HtmlFormWrapper form, boolean autoLoadFields) {
		List<HtmlElementWrapper> elements = new ArrayList<HtmlElementWrapper>();
		boolean fileElementFound = false;

		if (fileElementFound) {
			form.setEncType(HtmlForm.ENC_TYPE_MULTIPART);
		}
		return elements;
	}

	

	@Reference
	JetFormDataHelper dataHelper;

}