package com.adjecti.jetform.annotation;

import com.adjecti.common.util.AnnotationUtil;
import com.adjecti.common.util.FormEntityCache;
import com.adjecti.common.util.ReflectionUtil;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

public class HtmlFormWrapper implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Log LOGGER = LogFactoryUtil.getLog(HtmlFormWrapper.class.getName());
	private String id;
	private String formClass;
	private String entityClass;

	private String accessType;
	private int columns;
	private String title;
	private boolean caption;
	private boolean advanceFilter;
	private String groupAlignment;
	private String listOrder;
	private String encType;
	private boolean autoLabelElements;
	private boolean addNew = true;
	private boolean tab = false;
	private int elementsPerRow = 1;
	private int childTabCount = 0;
	private String formType;
	private String tabLayout;
	private String template;
	private String elementNamespace;
	private boolean selectable;
	//private HtmlFormFlowWrapper flowControl;
	private boolean formFlow;
	private boolean formFlowProcess;
	private boolean associationEntity=false;
	private String associationOneKey;
	private String associationManyKey;
	private String[] tabTitles = new String[] {};
	private List<HtmlElementWrapper> elements = new ArrayList<HtmlElementWrapper>();
	private List<HtmlFormActionWrapper> actions = new ArrayList<HtmlFormActionWrapper>();
	private List<HtmlElementGroupWrapper> elementGroups = new ArrayList<HtmlElementGroupWrapper>();
	private List<HtmlElementRuleGroupWrapper> ruleGroups = new ArrayList<HtmlElementRuleGroupWrapper>();
	Map<String, String> filter=new HashMap<String, String>();
	private Object entity;
	Map<String, Object> relationEntities=new HashMap<String, Object> ();
	private Serializable primaryKey;
	private boolean crud;
	private boolean readOnly;
	
	public HtmlFormWrapper() {
		super();
	}

	public HtmlFormWrapper(String formClass, HtmlForm annotation) {
		
		setFormClass(formClass);

		if (annotation != null) {
			
			setId(annotation.formId());
			setAccessType(annotation.accessType());
			setColumns(annotation.columns());
			setTitle(annotation.title());
			setCaption(annotation.caption());
			setAdvanceFilter(annotation.advanceFilter());
			setAutoLabelElements(annotation.autoLabelElements());
			setActions(annotation.actions());
			setGroupAlignment(annotation.groupAlignment());
			setEncType(annotation.encType());
			setListOrder(annotation.listOrder());
			setElementsPerRow(annotation.elementsPerRow());
			setTabTitles(annotation.tabTitles());
			setTab(annotation.tabTitles().length > 0);
			setFormType(annotation.formType().name());
			setTabLayout(annotation.tabLayout());
			setTemplate(annotation.template());
			setElementNamespace(annotation.elementNamespace());
			//LOGGER.info("annotation.entityClass().getName() :"+annotation.entityClass().getName());
			setEntityClass(!annotation.entityClass().getName().equals(Object.class.getName())?annotation.entityClass().getName():formClass);
			setSelectable(annotation.selectable());
			setFormFlow(annotation.formFlow());
			setFormFlowProcess(annotation.formFlowProcess());
			setFilter(annotation.filter());
			setCrud(annotation.crud());
			setReadOnly(annotation.readOnly());
			setAssociationEntity(annotation.associationEntity());
			setAssociationOneKey(annotation.associationOneKey());
			setAssociationManyKey(annotation.associationManyKey());
			
		}
	
		Class entClass =FormEntityCache.getFormClass(entityClass);
	
		setTitle((annotation != null && StringUtils.isNotEmpty(annotation.title())) ? annotation.title()
				: AnnotationUtil.getItemLabel(entClass.getSimpleName()));
	}
	

	public boolean isReadOnly() {
		return readOnly;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getColumns() {
		return columns;
	}

	public String getFormClass() {
		return formClass;
	}

	public void setFormClass(String formClass) {
		this.formClass = formClass;
	}


	public String getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(String entityClass) {
		this.entityClass = entityClass;
	}

	public boolean isAssociationEntity() {
		return associationEntity;
	}

	public void setAssociationEntity(boolean associationEntity) {
		this.associationEntity = associationEntity;
	}

	public String getAssociationOneKey() {
		return associationOneKey;
	}

	public void setAssociationOneKey(String associationOneKey) {
		this.associationOneKey = associationOneKey;
	}

	public String getAssociationManyKey() {
		return associationManyKey;
	}

	public void setAssociationManyKey(String associationManyKey) {
		this.associationManyKey = associationManyKey;
	}

	public String getAccessType() {
		return accessType;
	}

	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isCaption() {
		return caption;
	}

	public void setCaption(boolean caption) {
		this.caption = caption;
	}

	public boolean isAdvanceFilter() {
		return advanceFilter;
	}

	public void setAdvanceFilter(boolean advanceFilter) {
		this.advanceFilter = advanceFilter;
	}

	public String getGroupAlignment() {
		return groupAlignment;
	}

	public void setGroupAlignment(String groupAlignment) {
		this.groupAlignment = groupAlignment;
	}

	public String getListOrder() {
		return listOrder;
	}

	public void setListOrder(String listOrder) {
		this.listOrder = listOrder;
	}

	public void setEncType(String encType) {
		this.encType = encType;

	}

	public String getEncType() {
		return encType;
	}

	public boolean isAutoLabelElements() {
		return autoLabelElements;
	}

	public void setAutoLabelElements(boolean autoLabelElements) {
		this.autoLabelElements = autoLabelElements;
	}

	public boolean isAddNew() {
		return addNew;
	}

	public void setAddNew(boolean addNew) {
		this.addNew = addNew;
	}

	public boolean isTab() {
		return tab;
	}

	public void setTab(boolean tab) {
		this.tab = tab;
	}

	public String[] getTabTitles() {
		return tabTitles;
	}

	public void setTabTitles(String[] tabTitles) {
		this.tabTitles = tabTitles;
	}

	public int getChildTabCount() {
		return childTabCount;
	}

	public void setChildTabCount(int childTabCount) {
		this.childTabCount = childTabCount;
	}

	public Map<String, String> getFilter() {
		return filter;
	}
	@JsonSetter
	public void setFilter(Map<String, String> filter) {
		this.filter = filter;
	}
	
	
	
	public void setFilter(String[] arrFilter) {
		if(arrFilter!=null) {
			for(String strFilter:arrFilter) {
				if(strFilter==null || strFilter.trim().equals("")) {
					continue;
				}
				String[] keyVal=strFilter.split(":");
				if(keyVal!=null && keyVal.length>1) {
					filter.put(keyVal[0].trim(), keyVal[1].trim());
				}
			}
		}
	}
	
	public int getElementsPerRow() {
		return elementsPerRow;
	}

	public void setElementsPerRow(int elementsPerRow) {
		this.elementsPerRow = elementsPerRow;
	}

	public Object getEntity() {
		return entity;
	}

	public void setEntity(Object entity) {
		this.entity = entity;
		if(entity!=null) {
			String pkStr=String.valueOf(primaryKey);
			if(primaryKey==null ||  "0".equals(pkStr) || "-1".equals(pkStr) || "null".equals(pkStr)) {
				try {
					Serializable pk=(Serializable)ReflectionUtil.getPrimaryKey(entity);
					setPrimaryKey(pk);
				}catch(Exception e) {}
			}
		}
	}

	public Map<String, Object> getRelationEntities() {
		return relationEntities;
	}

	public void setRelationEntities(Map<String, Object> relationEntities) {
		this.relationEntities = relationEntities;
	}

	public Serializable getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(Serializable primaryKey) {
		this.primaryKey = primaryKey;
	}

	private String getEntityValue(String key) {
		if(StringUtils.isNotEmpty(key)) {
			if(entity!=null) {
				try {
					Class entClass = FormEntityCache.getFormClass(entityClass);
					Method method = entClass.getMethod(key, new Class[] {});
					String value= String.valueOf(method.invoke(entity, new Object[] {}));
					return value;
				} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					LOGGER.info(e);
				}
			}
		}
		return null;
	}
	
	private String getRelationValue(String key) {
		if(key.contains(".")) {
			String objectKey=key.substring(0, key.lastIndexOf(".")-1);
			String attrKey=key.substring(key.lastIndexOf(".")+1);
			Object object = relationEntities.get(objectKey);
			if(object!=null) {
				String value= String.valueOf(ReflectionUtil.invokeGet(object, attrKey));
				return value;
			}
		}
		return null;
	}
	
	public String getFormType() {
		return formType;
	}

	public void setFormType(String formType) {
		this.formType = formType;
	}

	public String getTabLayout() {
		return tabLayout;
	}

	public void setTabLayout(String tabLayout) {
		this.tabLayout = tabLayout;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getElementNamespace() {
		return (elementNamespace!=null?elementNamespace:"");
	}

	public void setElementNamespace(String elementNamespace) {
		this.elementNamespace = elementNamespace;
	}

	public boolean isSelectable() {
		return selectable;
	}

	public boolean isFormFlow() {
		return formFlow;
	}

	public void setFormFlow(boolean formFlow) {
		this.formFlow = formFlow;
	}

	public boolean isFormFlowProcess() {
		return formFlowProcess;
	}

	public void setFormFlowProcess(boolean formFlowProcess) {
		this.formFlowProcess = formFlowProcess;
	}

	public void setSelectable(boolean selectable) {
		this.selectable = selectable;
	}

	public List<HtmlElementWrapper> getElements() {
		return elements;
	}
	

	

	public boolean isCrud() {
		return crud;
	}

	public void setCrud(boolean crud) {
		this.crud = crud;
	}

	public void setElements(List<HtmlElementWrapper> elements) {
		this.elements = elements;
		this.childTabCount = 0;
		for (HtmlElementWrapper e : elements) {
			if (e.isTab()) {
				this.childTabCount++;
			}
		}
	}

	public List<HtmlElementWrapper> getAllElements() {
		List<HtmlElementWrapper> allElements=new LinkedList<HtmlElementWrapper>();
		
		if (CollectionUtils.isNotEmpty(elements)) {
			allElements.addAll(elements);
		}
	
		if (CollectionUtils.isNotEmpty(elementGroups)) {
			for (HtmlElementGroupWrapper group : elementGroups) {
				if (CollectionUtils.isNotEmpty(group.getElements())) {
					allElements.addAll(group.getElements());
				}
			}
		}
		
		return allElements;
	}
	
	public HtmlElementWrapper getElementByName(String name) {
		HtmlElementWrapper result = null;
		if (elements == null) {
			return result;
		}
		for (HtmlElementWrapper e : elements) {
			if (e.getName().equalsIgnoreCase(name)) {
				result = e;
				break;
			}
		}
		if(result==null) {
			if(CollectionUtils.isNotEmpty(elementGroups)) {
				for(HtmlElementGroupWrapper g:elementGroups) {
					result=g.getElementByName(name);
					if(result!=null) {
						break;
					}
				}
			}
		}
		return result;
	}
	
	public HtmlElementWrapper getElementByIndex(int index) {
		HtmlElementWrapper result = null;
		if (elements == null) {
			return result;
		}
		for (int i=0; i<elements.size();i++) {
			if(i==index) {
				result=elements.get(i);
				break;
			}
		}
		
		return result;
	}
	
	@JSON(include=false)
	public HtmlElementWrapper getKeyElement() {
		HtmlElementWrapper result = null;
		if (elements == null) {
			return result;
		}
		for (HtmlElementWrapper e : elements) {
			if (e.isKey()) {
				result = e;
				break;
			}
		}
		return result;
	}
	
	@JSON(include=false)
	public HtmlElementWrapper getFormFlowKeyElement() {
		HtmlElementWrapper result = null;
		for(HtmlElementWrapper element:getElements()) {
			if(element.isFormFlowKey()) {
				result=element;
				break;
			}
		}
		return result;
	}
	public List<HtmlFormActionWrapper> getActions() {
		return actions;
	}

	@JsonSetter
	public void setActions(List<HtmlFormActionWrapper> actions) {
		this.actions = actions;
	}

	
	public void setActions(HtmlFormAction[] actions) {
		boolean _mAddNew = false;
		for (HtmlFormAction action : actions) {
			this.actions.add(new HtmlFormActionWrapper(action));
			if (action.name().toLowerCase().equals("add")) {
				_mAddNew = true;
			}
		}
		setAddNew(_mAddNew);
	}

	public void addAction(HtmlFormAction action) {
		this.actions.add(new HtmlFormActionWrapper(action));
	}

	public void addAction(HtmlFormActionWrapper action) {
		this.actions.add(action);
	}

	public HtmlFormActionWrapper getActionByName(String name) {
		HtmlFormActionWrapper action = null;
		for (HtmlFormActionWrapper a : actions) {
			if (name.equals(a.getName())) {
				action = a;
			}
		}
		return action;
	}

	public List<HtmlElementGroupWrapper> getElementGroups() {
		return elementGroups;
	}

	public void setElementGroups(List<HtmlElementGroupWrapper> groups) {
		this.elementGroups = groups;
	}

	public void addElementGroup(HtmlElementGroupWrapper group) {
		elementGroups.add(group);
	}

	public void addElementGroup(HtmlElementGroup group) {
		elementGroups.add(new HtmlElementGroupWrapper(group));
	}

	public HtmlElementGroupWrapper getGroupById(String id) {
		if (elementGroups == null) {
			return null;
		}
		HtmlElementGroupWrapper group = null;
		for (HtmlElementGroupWrapper g : elementGroups) {
			if (g.getId().equalsIgnoreCase(id)) {
				group = g;
			}
		}
		return group;
	}
	
	public HtmlElementGroupWrapper getElementGroupByIndex(int index) {
		if (elementGroups == null) {
			return null;
		}
		
		return elementGroups.get(index);
	}

	/*
	 * public HtmlFormFlowWrapper getFlowControl() { return flowControl; }
	 */

	//public void setFlowControl(HtmlFormFlowWrapper flowControl) {
	//	this.flowControl = flowControl;
	//}

	/*
	 * public void setFlowControl(HtmlFormFlow flowControlAnnot) { if
	 * (flowControlAnnot != null && flowControlAnnot.key() != null &&
	 * !flowControlAnnot.key().equals("")) { this.flowControl = new
	 * HtmlFormFlowWrapper(flowControlAnnot.key(), flowControlAnnot.values()); } }
	 */

	public List<HtmlElementRuleGroupWrapper> getRuleGroups() {
		return ruleGroups;
	}

	@JsonSetter
	public void setRuleGroups(List<HtmlElementRuleGroupWrapper> ruleGroups) {
		this.ruleGroups = ruleGroups;
	}

	
	public void setRuleGroups(HtmlElementRuleGroup[] ruleGroups) {
		for (HtmlElementRuleGroup group : ruleGroups) {
			this.ruleGroups.add(new HtmlElementRuleGroupWrapper(group));
		}
	}

	public void addRuleGroup(HtmlElementRuleGroup group) {
		this.ruleGroups.add(new HtmlElementRuleGroupWrapper(group));
	}

	public HtmlElementRuleGroupWrapper getRuleGroupByName(String name) {
		HtmlElementRuleGroupWrapper group = null;
		for (HtmlElementRuleGroupWrapper g : this.ruleGroups) {
			if (g.getName().equals(name)) {
				group = g;
				break;
			}
		}
		return group;
	}

	@Override
	public String toString() {
		return "HtmlFormWrapper [formClass=" + formClass + ", modelClass=" + entityClass + ", accessType=" + accessType
				+ ", columns=" + columns + ", title=" + title + ", caption=" + caption + ", groupAlignment="
				+ groupAlignment + ", listOrder=" + listOrder + ", encType=" + encType + ", addNew=" + addNew + ", tab="
				+ tab + ", elementsPerRow=" + elementsPerRow + ", childTabCount=" + childTabCount + ", formType="
				+ formType + ", tabLayout=" + tabLayout + 
				//", flowControl=" + flowControl + 
				", tabTitles="
				+ Arrays.toString(tabTitles) + ", elements=" + elements + ", actions=" + actions + ", elementGroups="
				+ elementGroups + ", ruleGroups=" + ruleGroups + ", model=" + entity + "]";
	}
	
}
