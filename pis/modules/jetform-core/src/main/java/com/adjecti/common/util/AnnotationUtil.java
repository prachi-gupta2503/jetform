package com.adjecti.common.util;

import com.adjecti.jetform.annotation.HtmlElement;
import com.adjecti.jetform.annotation.HtmlElementGroup;
import com.adjecti.jetform.annotation.HtmlElementGroupWrapper;
import com.adjecti.jetform.annotation.HtmlElementGroups;
import com.adjecti.jetform.annotation.HtmlElementRuleGroups;
import com.adjecti.jetform.annotation.HtmlElementWrapper;
import com.adjecti.jetform.annotation.HtmlForm;
import com.adjecti.jetform.annotation.HtmlFormFlow;
import com.adjecti.jetform.annotation.HtmlFormWrapper;
import com.adjecti.jetform.model.KeyValue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;


public class AnnotationUtil {
	public static enum Month {
		January, February, March, April, May, June, August, September, October, November, December
	}

	public static enum Gender {
		Male, Female, Transgender
	}

	public static enum Religion {
		Hindu, Muslim, Christian, Shikh, Buddhism
	}

	public static enum MaritalStatus {
		Married, Single, Widow, Divorced
	}

	public static enum BloodGroup {
		AP, AN, BP, BN, ABP, ABN, OP, ON;
	}

	public static String[] bloodGroups = { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" };

	public static HtmlFormWrapper getHtmlForm(String className){
		Class clazz = null;
		try {
			clazz = Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return getHtmlForm(clazz);
	}

	public static HtmlFormWrapper getHtmlForm(Class<?> clazz){
		HtmlFormWrapper formWrapper = new HtmlFormWrapper();
		List<HtmlElementWrapper> elements = new ArrayList<HtmlElementWrapper>();
		if (!clazz.isAnnotationPresent(HtmlForm.class)) {
			return formWrapper;
		}

		HtmlForm formAttn = (clazz.getAnnotation(HtmlForm.class));
		//HtmlFormFlow formFlowAttn = (clazz.getAnnotation(HtmlFormFlow.class));
		HtmlElementGroups formElementGroupsAttn = (clazz.getAnnotation(HtmlElementGroups.class));
		HtmlElementRuleGroups formRuleGroupsAttn = (clazz.getAnnotation(HtmlElementRuleGroups.class));

		if (!formAttn.enabled()) {
			return formWrapper;
		}
		formWrapper.setColumns(formAttn.columns());
		formWrapper.setTitle(formAttn.title());
		formWrapper.setCaption(formAttn.caption());
		//formWrapper.setFlowControl(formFlowAttn);

		if (formAttn.groups() != null && formAttn.groups().length > 0) {
			for (HtmlElementGroup group : formAttn.groups()) {
				formWrapper.addElementGroup(new HtmlElementGroupWrapper(group));
			}
			formWrapper.setGroupAlignment(formAttn.groupAlignment());
		} else {
			if (formElementGroupsAttn != null && formElementGroupsAttn.value() != null && formElementGroupsAttn.value().length > 0) {
				for (HtmlElementGroup group : formElementGroupsAttn.value()) {
					formWrapper.addElementGroup(new HtmlElementGroupWrapper(group));
				}
				formWrapper.setGroupAlignment(formElementGroupsAttn.alignment());
			}
		}

		if (formRuleGroupsAttn != null && formRuleGroupsAttn.value() != null && formRuleGroupsAttn.value().length > 0) {
			formWrapper.setRuleGroups(formRuleGroupsAttn.value());
		}

		for (Field field : clazz.getDeclaredFields()) {
			if (field.isAnnotationPresent(HtmlElement.class)) {
				HtmlElement elementAttn = (field.getAnnotation(HtmlElement.class));
				HtmlElementRuleGroups elementRuleGroupsAttn = (field.getAnnotation(HtmlElementRuleGroups.class));

				HtmlElementWrapper element = new HtmlElementWrapper(field.getName(), elementAttn);

				element.setName(field.getName());
				if (field.getType() == List.class || field.getType() == Set.class) {
					ParameterizedType pType = (ParameterizedType) field.getGenericType();
					Type[] types = pType.getActualTypeArguments();
					if (types != null && types.length > 0) {
						element.setDataType(((Class) types[0]).getName());
						if (elementAttn.controlType() == HtmlElement.ControlType.list) {
							element.setParentForm(getHtmlForm(((Class) types[0]).getName()));
						}
					}

				} else {
					element.setDataType(field.getType().getName());
				}
				
				if (elementAttn.controlType() == HtmlElement.ControlType.fileUpload) {
					formWrapper.setEncType(HtmlForm.ENC_TYPE_MULTIPART);
				}

				element.setKey(elementAttn.key());
				element.setLabel(elementAttn.label());
				element.setControlType(elementAttn.controlType().name());
				element.setValidType(elementAttn.validType().name());
				element.setExclude(elementAttn.exclude());
				element.setUnique(elementAttn.unique());
				element.setDepends(elementAttn.depends());
				element.setListField(elementAttn.listField());
				element.setListable(elementAttn.listable());
				element.setDisplayWidth(elementAttn.displayWidth());
				element.setRequired(elementAttn.required());
				element.setDataQuery(elementAttn.dataQuery());
				element.setGroup(elementAttn.group());

				if (elementRuleGroupsAttn != null && elementRuleGroupsAttn.value() != null && elementRuleGroupsAttn.value().length > 0) {
					element.setRuleGroups(elementRuleGroupsAttn.value());
				} else {
					HtmlElementRuleGroups ruleGroupsAnnotation = (field.getAnnotation(HtmlElementRuleGroups.class));
					if (ruleGroupsAnnotation != null && ruleGroupsAnnotation.value() != null && ruleGroupsAnnotation.value().length > 0) {
						element.setRuleGroups(ruleGroupsAnnotation.value());
					}
				}

				if (elementAttn.options() != null && elementAttn.options().length > 0) {
					for (String s : elementAttn.options()) {
						String[] kv = s.split(":");
						element.addListOption(new KeyValue(kv[0], kv[1]));
					}
				}

				element.setReadOnly(elementAttn.readOnly() ? "readonly" : "");
				if (element.getDataType().equals("java.lang.Integer") || element.getDataType().equals("java.lang.Long")
						|| element.getDataType().equals("java.lang.Float") || element.getDataType().equals("java.lang.Double")) {
					element.setDefaultValue("0");
				}
				elements.add(element);
			}
		}
		HtmlElementWrapper element = new HtmlElementWrapper();
		element.setName("class");
		element.setDataType(String.class.getName());
		element.setLabel("class");
		element.setControlType(HtmlElement.ControlType.hidden.name());
		element.setValidType(HtmlElement.ValidType.none.name());
		element.setDefaultValue(clazz.getName());

		elements.add(0, element);
		formWrapper.setElements(elements);
		return formWrapper;
	}

	public static String getItemLabel(String itemName) {
		String label = "";
		int xc = 0;
		for (char c : itemName.toCharArray()) {
			if (xc == 0) {
				label = label + "" + StringUtils.upperCase(new String(new char[] { c }));
			} else if (c >= 65 && c <= 90) {
				label = label + " " + c;
			} else {
				label = label + c;
			}
			xc++;
		}
		if(label.endsWith(" Id")) {
			label=label.substring(0, label.length()-3);
		}
		return label;
	}

	public static boolean isBasicType(String type) {
		return isBasicType(ReflectionUtil.loadClass(type));
	}
	
	public static boolean isBasicType(Class<?> type) {
		return isAlphaNumericType(type)  || type==Boolean.class || type==java.sql.Date.class || type==java.util.Date.class || type==Class.class;
	}
	public static boolean isAlphaNumericType(Class<?> type) {
		if(type==null) {
			return true;
		}
		return (type == String.class || type == Long.class || type == Integer.class || type == Float.class || type == Double.class);
	}

	public static boolean isAlphaNumericType(String type) {
		if(StringUtils.isEmpty(type)) {
			return false;
		}
		return isAlphaNumericType(ReflectionUtil.loadClass(type));
	}
	
	public static boolean isCollectionType(Class<?> type) {
		return (type == List.class || type == ArrayList.class || type == Set.class || type == HashSet.class);
	}

	public static boolean isNumericType(String type) {
		return isNumericType(ReflectionUtil.loadClass(type));
	}
	
	public static boolean isNumericType(Class type) {
		return (type == Long.class || type == Integer.class || type == Float.class || type == Double.class);
	}
	
	
	public static boolean isCollectionType(String type) {
		return isCollectionType(ReflectionUtil.loadClass(type));
	}
	
	public static boolean isDescriptiveType(Field field) {

		return (field.getType() == String.class && (field.getName().equalsIgnoreCase("remark") || field.getName().equalsIgnoreCase("comment")
				|| field.getName().equalsIgnoreCase("desc") || field.getName().equalsIgnoreCase("description")));
	}
	
	public static boolean isDescriptiveType(Method method) {

		return (method.getReturnType() == String.class && (method.getName().equalsIgnoreCase("getremark") || method.getName().equalsIgnoreCase("getcomment")
				|| method.getName().equalsIgnoreCase("getdesc") || method.getName().equalsIgnoreCase("getdescription")));
	}

	public static boolean isFixedSelectionType(Field field) {
		Class<?> type = field.getType();
		String name = field.getName();
		return isFixedSelectionType(type, name);
	}
	
	public static boolean isFixedSelectionType(Method method) {
		Class<?> type = method.getReturnType();
		String name = method.getName();
		if(name.startsWith("get")) {
			name=name.substring("get".length());
		}
		return isFixedSelectionType(type, name);
	}

	public static boolean isFixedSelectionType(String type, String fieldName) {
		try {
			return isFixedSelectionType(Class.forName(type), fieldName);
		} catch (ClassNotFoundException e) {
		}
		return false;
	}
	public static boolean isFixedSelectionType(Class<?> type, String fieldName) {
		return (type == String.class || type == Integer.class) && (fieldName.equalsIgnoreCase("gender") || fieldName.equalsIgnoreCase("religion")
				|| fieldName.equalsIgnoreCase("maritalStatus") || fieldName.equalsIgnoreCase("bloodGroup") || fieldName.equalsIgnoreCase("month"));
	}
	
	public static boolean isDate(Class<?> type) {
		return (type==java.sql.Date.class || type==java.util.Date.class);
	}
	
	public static boolean isBoolean(Class<?> type) {
		return (type==java.lang.Boolean.class);
	}
	
	public static boolean isFloatOrDouble(Class<?> type) {
		return (type==java.lang.Float.class || type==java.lang.Double.class);
	}
	
	public static boolean isIntegerOrLong(Class<?> type) {
		return (type==java.lang.Long.class || type==java.lang.Integer.class);
	}
	
	public static List<KeyValue> genderOptions() {

		List<KeyValue> list = new ArrayList<KeyValue>();
		for (Gender o : Gender.values()) {
			list.add(new KeyValue(o.ordinal()+1, o.name()));
		}
		return list;
	}

	public static List<KeyValue> religionOptions() {
		List<KeyValue> list = new ArrayList<KeyValue>();
		for (Religion o : Religion.values()) {
			list.add(new KeyValue(o.ordinal()+1, o.name()));
		}
		return list;
	}

	public static List<KeyValue> maritalStatusOptions() {
		List<KeyValue> list = new ArrayList<KeyValue>();
		for (MaritalStatus o : MaritalStatus.values()) {
			list.add(new KeyValue(o.ordinal()+1, o.name()));
		}
		return list;
	}

	public static List<KeyValue> monthOptions() {
		List<KeyValue> list = new ArrayList<KeyValue>();
		for (Month o : Month.values()) {
			list.add(new KeyValue(o.ordinal()+1, o.name()));
		}
		return list;
	}

	public static List<KeyValue> bloodGroupOptions() {
		List<KeyValue> list = new ArrayList<KeyValue>();
		for (BloodGroup o : BloodGroup.values()) {
			list.add(new KeyValue(o.ordinal()+1, bloodGroups[o.ordinal()]));
		}
		return list;
	}
	
	public static List<KeyValue> getFixedSelectOptions(String name) {
		if(name.equalsIgnoreCase("gender")){
			return genderOptions();
		}else if(name.equalsIgnoreCase("religion")){
			return religionOptions();
		}else if(name.equalsIgnoreCase("maritalStatus")){
			return maritalStatusOptions();
		}else if(name.equalsIgnoreCase("bloodGroup")){
			return bloodGroupOptions();
		}else if(name.equalsIgnoreCase("month")){
			return monthOptions();
		}
		return new ArrayList<KeyValue>();
	}

	public static boolean hasFinalStaticModifier(Field field) {
		String modifiers = Modifier.toString(field.getModifiers());
		return (modifiers.contains("static") || modifiers.contains("transient") || modifiers.contains("final") || modifiers.contains("volatile"));
	}
	public static boolean hasFinalModifier(Field field) {
		String modifiers = Modifier.toString(field.getModifiers());
		return modifiers.contains("final");
	}

	public static boolean isKey(String attributeName, String modelClassSimpleName) {
		return (attributeName.toLowerCase().equals(modelClassSimpleName.concat("Id").toLowerCase()));
	}	
	
	public static boolean isKey(String attributeName, Class modelClass) {
		return (attributeName.toLowerCase().equals(modelClass.getSimpleName().concat("Id").toLowerCase()));
	}

	public static boolean isRelation(String attributeName, String modelClassSimpleName) {
		return (!attributeName.toLowerCase().equals("emailid") && attributeName.endsWith("Id") && !isKey(attributeName, modelClassSimpleName));
	}	
}
