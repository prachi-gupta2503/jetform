package com.adjecti.jetform.annotation;

import com.adjecti.common.util.AnnotationUtil;
import com.adjecti.common.util.FormEntityCache;
import com.adjecti.common.util.ReflectionUtil;
import com.adjecti.jetform.annotation.HtmlElement.Alignment;
import com.adjecti.jetform.annotation.HtmlElement.ControlType;
import com.adjecti.jetform.annotation.HtmlElement.ValidType;
import com.adjecti.jetform.annotation.Relation.RelationType;
import com.adjecti.jetform.model.KeyValue;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.liferay.portal.kernel.json.JSON;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;

public class HtmlElementWrapper implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(HtmlElementWrapper.class.getName());
	private static final int MAX_LENGTH = 75;
	private static final int MAX_DESC_LENGTH = 255;
	String name = "";
	String attribute = "";
	String dataType = "";
	boolean transientElement = false;
	boolean key = false;
	String label = "";
	boolean exclude;
	boolean unique;
	boolean seachable;
	boolean hidden;
	String depends = "";
	String dependantKey = "";
	String placeHolder = "";
	String controlType = ControlType.text.name();
	String validType = ValidType.none.name();
	String defaultValue = "";
	String readOnly = "";
	String listField = "name";
	String formClass;
	String mappingField;
	String value = "";
	String format = "";
	int min = 0;
	int max = 0;
	int minLength = 0;
	int maxLength = 0;
	String regExp = "";
	int rows = 0;
	int cols = 0;
	
	// Used for document fileUpload components
	String folder = "/";
	String accept = "";
	boolean thumbnail= false;
	int width=0;
	int height=0;
	long fileSize=0;
	
	boolean folderAutoCreate = false;
	boolean formFlowKey;
	String customTemplate;
	RelationWrapper relation = null;
	boolean listable = true;
	String displayWidth = "";
	boolean required = false;
	String dataQuery;
	String tableRowAlign = Alignment.horizontal.name();
	int group = 0;
	boolean tab = false;
	boolean preview = false;
	boolean link = false;
	String linkAction = "";

	String dateBefore = "";
	String dateAfter = "";
	
 /*commented by prachi guupta on 27-07-2022
	int yearBefore = 0;
	int yearAfter = 0;
	int monthBefore = 0;
	int monthAfter = 0;
	int dayBefore = 0;
	int dayAfter = 0;
*/
	String yearBefore = "";
	String yearAfter = "";
	String monthBefore = "";
	String monthAfter = "";
	String dayBefore = "";
	String dayAfter = "";
	
	/*int yearLess = 0;
	int yearMore = 0;
	int monthLess = 0;
	int monthMore = 0;
	int dayLess = 0;
	int dayMore = 0;*/
	
	/* updated by Prachi gupta on 24 june 2022 */ 
	boolean tooltip=false;
	String helpText="";
	String matchWith="";
	
	
	int elementsPerColumn = 0;
	List<String> rules = new ArrayList<String>();
	List<HtmlElementRuleGroupWrapper> ruleGroups = new ArrayList<HtmlElementRuleGroupWrapper>();
	List<KeyValue> listOptions = new ArrayList<KeyValue>();
	transient HtmlFormWrapper parentForm;
	HtmlFormWrapper childForm;

	List<HtmlEventWrapper> events = new ArrayList<HtmlEventWrapper>();

	public HtmlElementWrapper() {
		super();
	}

	public HtmlElementWrapper(String name) {
		setName(name);
	}

	public HtmlElementWrapper(String name, HtmlElement annotation) {

		// LOGGER.info("HtmlElementWrapper.name = "+name);
		
			setName(name);
			if (StringUtils.isNotEmpty(name)) {
		} else {
			setName(annotation.name());
		}
		if (StringUtils.isEmpty(annotation.attribute())) {
			setAttribute(getName());
		} else {
			setAttribute(annotation.attribute());
		}

		setTransientElement(annotation.transientElement());

		setKey(annotation.key());
		setExclude(annotation.exclude());
		setSeachable(annotation.seachable());
		setDepends(annotation.depends());

		setListField(annotation.listField());
		setDisplayWidth(annotation.displayWidth());
		setReadOnly(annotation.readOnly() ? "readonly" : "");
		setDataQuery(annotation.dataQuery());
		setGroup(annotation.group());
		setTab(annotation.tab());
		setPlaceHolder(annotation.placeHolder());
		setElementsPerColumn(annotation.elementsPerColumn());

		setRequired(annotation.required());
		setMin(annotation.min());
		setMax(annotation.max());
		setMaxLength(annotation.maxLength());
		setMinLength(annotation.minLength());
		setValidType(annotation.validType().name());
		setUnique(annotation.unique());
		setRegExp(annotation.regExp());

		setFormClass(annotation.formClass().getSimpleName());
		setMappingField(annotation.mappingField());
		setValue(annotation.value());
		setFormat(annotation.format());
		setRows(annotation.rows());
		setCols(annotation.cols());

		setListable(annotation.listable());
		setFormFlowKey(annotation.formFlowKey());
		setCustomTemplate(annotation.customTemplate());
		setControlType(annotation.controlType().name());
		setHidden(isControlType(ControlType.hidden));
		
		setPreview(annotation.preview());
		setFolder(annotation.folder());
		setAccept(annotation.accept());
		setThumbnail(annotation.thumbnail());
		setWidth(annotation.width());
		setHeight(annotation.height());
		setFileSize(annotation.fileSize());
		
		setLink(annotation.link());
		setLinkAction(annotation.linkAction());

		setDateBefore(annotation.dateBefore());
		setDateAfter(annotation.dateAfter());
		
		setYearAfter(annotation.yearAfter());
		setYearBefore(annotation.yearBefore());
		
		setMonthAfter(annotation.monthAfter());
		setMonthBefore(annotation.monthBefore());
		
		setDayAfter(annotation.dayAfter());
		setDayBefore(annotation.dayBefore());
		
		/* updated by Prachi gupta on 24 june 2022 */ 
		setTooltip(annotation.tooltip());
		setHelpText(annotation.helpText());
		setMatchWith(annotation.matchWith());
		
		
		
/*		setYearLess(annotation.yearLess());
		setYearMore(annotation.yearMore());
		setMonthLess(annotation.monthLess());
		setMonthMore(annotation.monthMore());
		setDayLess(annotation.dayLess());
		setDayMore(annotation.dayMore());
*/		
		// setFormFlowProcess(annotation.formFlowProcess());

		if(StringUtils.isNotBlank(annotation.dependantKey())) {
			setDependantKey(annotation.dependantKey());
		}else {
			setDependantKey(annotation.depends());
		}
		
		String lowerName = name.toLowerCase();
		if (lowerName.contains("remark") || lowerName.contains("reason") || lowerName.contains("note")
				|| lowerName.contains("description") || lowerName.contains("comments")) {
			if(!isControlType(ControlType.hidden)) {
				setControlType(ControlType.textarea.name());
			}
		} /*
			 * else if (method.getReturnType() == Boolean.class || method.getReturnType() ==
			 * Boolean.TYPE) { LOGGER.info(attributeName + " -- " +
			 * method.getReturnType().getName() + " -- " + (method.getReturnType() ==
			 * Boolean.TYPE)); setControlType(ControlType.checkbox.name()); }
			 */

		Relation relation = annotation.relation();
		if (!relation.modelClass().getName().equalsIgnoreCase(Object.class.getName())) {
			setRelation(new RelationWrapper(relation));
			if (!isRelationControlType(annotation.controlType()) && !isControlType(HtmlElement.ControlType.hidden) ) {
				if(!isControlType(HtmlElement.ControlType.multiSelect) && !isControlType(HtmlElement.ControlType.select)) {
					
					setControlType(ControlType.select.name());
				}
			}
			
		}

		if (getControlType() == null || getControlType().equals(HtmlElement.ControlType.text.name())) {
			setControlType(annotation.controlType().name());
		}

		if (isControlType(ControlType.list.name())) {
			setListable(false);
			setTableRowAlign(annotation.tableRowAlign().name());
		}

		if (annotation.label() != null && !annotation.label().equals("")) {
			setLabel(annotation.label());
		} else {
			setLabel(AnnotationUtil.getItemLabel(name));
		}

		if (annotation.controlType() == ControlType.form || annotation.controlType() == ControlType.list) {
			return;
		}

	/*	if (annotation.options() != null && annotation.options().length > 0 && isRelationControlType()) {*/
		/* updated by prachi gupta on 12-07-2022 */
		if (annotation.options() != null && annotation.options().length > 0) {
			addListOption(annotation.options());
			/*
			 * for (String s : annotation.options()) {
			 * LOGGER.info("annotation.option = "+s); String[] kv=null; if(s.contains(":"))
			 * { kv = s.split(":"); }else if(s.contains("=")) { kv = s.split("="); } if(
			 * kv!=null && kv.length>1) { addListOption(new
			 * KeyValue(StringUtils.trim(kv[0]), StringUtils.trim(kv[1]))); }else {
			 * addListOption(new KeyValue(StringUtils.trim(s), StringUtils.trim(s))); } }
			 */
		}

		if (annotation.events() != null && annotation.events().length > 0) {
			for (HtmlEvent event : annotation.events()) {
				addEvent(event);
			}
		}

		if (annotation.rules() != null) {
			setRules(annotation.rules());
		}

		if (isControlType(ControlType.select) || isControlType(ControlType.multiSelect)
				|| isControlType(ControlType.checkbox) || isControlType(ControlType.radio)) {

			if (StringUtils.isEmpty(getListField())) {
				setListField("name");
			}
		}

		setEvents(annotation.events());
	}

	public HtmlElementWrapper(String attributeName, Method method, Class clazz) {
		String modelName = clazz.getSimpleName();
		if (StringUtils.isEmpty(attributeName)) {
			attributeName = ReflectionUtil.getAttributeFromAccessorMethod(method);
		}
		setName(attributeName);
		setAttribute(attributeName);
		setLabel(AnnotationUtil.getItemLabel(attributeName));
		setKey(AnnotationUtil.isKey(attributeName, modelName));
		setDataType(method.getReturnType().getName());

		String lowerAttributeName = attributeName.toLowerCase();

		if (lowerAttributeName.contains("remark") || lowerAttributeName.contains("reason")
				|| lowerAttributeName.contains("note") || lowerAttributeName.contains("description")
				|| lowerAttributeName.contains("comments")) {
			setControlType(ControlType.textarea.name());
		} else if (method.getReturnType() == Boolean.class || method.getReturnType() == Boolean.TYPE) {
			setControlType(ControlType.checkbox.name());
		} else if (method.getReturnType() == Date.class) {
			setControlType(ControlType.date.name());
		} else {
			setControlType(ControlType.text.name());
		}

		boolean isRelation = AnnotationUtil.isRelation(attributeName, modelName);
		// LOGGER.info(attributeName+" -- "+modelName+" -- "+isRelation);
		if (isRelation) {
			RelationWrapper relation = new RelationWrapper(clazz, attributeName);
			setRelation(relation);
			setControlType(ControlType.select.name());
		}

		if (isNumericDataType()) {
			setDefaultValue("0");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getControlType() {
		return controlType;
	}

	public void setControlType(String controlType) {
		this.controlType = controlType;
	}

	public boolean isTransientElement() {
		return transientElement;
	}

	public void setTransientElement(boolean transientElement) {
		this.transientElement = transientElement;
	}

	public boolean isKey() {
		return key;
	}

	public void setKey(boolean key) {
		this.key = key;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isTab() {
		return tab;
	}

	public void setTab(boolean tab) {
		this.tab = tab;
	}

	public boolean isExclude() {
		return exclude;
	}

	public void setExclude(boolean exclude) {
		this.exclude = exclude;
	}

	public boolean isUnique() {
		return unique;
	}

	public void setUnique(boolean unique) {
		this.unique = unique;
	}

	public boolean isSeachable() {
		return seachable;
	}

	public void setSeachable(boolean seachable) {
		this.seachable = seachable;
	}

	public boolean isHidden() {
		return hidden;
	}

	private void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public String getDepends() {
		return depends;
	}

	public void setDepends(String depends) {
		this.depends = depends;
	}

	public String getDependantKey() {
		return dependantKey;
	}

	public void setDependantKey(String dependantKey) {
		this.dependantKey = dependantKey;
	}

	public String getPlaceHolder() {
		return placeHolder;
	}

	public void setPlaceHolder(String placeHolder) {
		this.placeHolder = placeHolder;
	}

	public String getValidType() {
		return validType;
	}

	public void setValidType(String validType) {
		this.validType = validType;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getReadOnly() {
		return readOnly;
	}

	public void setReadOnly(String readOnly) {
		this.readOnly = readOnly;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getListField() {
		return listField;
	}

	public void setListField(String listField) {
		this.listField = listField;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getMinLength() {
		return minLength;
	}

	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}

	public int getMaxLength() {
		if(maxLength>0) {
			return maxLength;
		}
		String lowerName = name.toLowerCase();

		if (lowerName.contains("remark") || lowerName.contains("reason")
				|| lowerName.contains("note") || lowerName.contains("description")
				|| lowerName.contains("comments")) {
			return MAX_DESC_LENGTH;
		}else {
			return MAX_LENGTH;
		}
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public String getRegExp() {
		return regExp;
	}

	public void setRegExp(String regExp) {
		this.regExp = regExp;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public boolean isFolderAutoCreate() {
		return folderAutoCreate;
	}

	public void setFolderAutoCreate(boolean folderAutoCreate) {
		this.folderAutoCreate = folderAutoCreate;
	}

	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

	public boolean isThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(boolean thumbnail) {
		this.thumbnail = thumbnail;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public RelationWrapper getRelation() {
		return relation;
	}

	public void setRelation(RelationWrapper relation) {
		this.relation = relation;
	}

	public boolean isListable() {
		return listable;
	}

	public void setListable(boolean listable) {
		this.listable = listable;
	}

	public String getFormClass() {
		return formClass;
	}

	public void setFormClass(String formClass) {
		this.formClass = formClass;
	}

	public String getMappingField() {
		return mappingField;
	}

	public void setMappingField(String mappingField) {
		this.mappingField = mappingField;
	}

	public String getDisplayWidth() {
		return displayWidth;
	}

	public void setDisplayWidth(String displayWidth) {
		this.displayWidth = displayWidth;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public String getDataQuery() {
		return dataQuery;
	}

	public void setDataQuery(String dataQuery) {
		this.dataQuery = dataQuery;
	}

	public boolean isLink() {
		return link;
	}

	public void setLink(boolean link) {
		this.link = link;
	}

	public String getLinkAction() {
		return linkAction;
	}

	public void setLinkAction(String linkAction) {
		this.linkAction = linkAction;
	}

	public String getTableRowAlign() {
		return tableRowAlign;
	}

	public void setTableRowAlign(String tableRowAlign) {
		this.tableRowAlign = tableRowAlign;
	}

	public int getElementsPerColumn() {
		return elementsPerColumn;
	}

	public void setElementsPerColumn(int elementsPerColumn) {
		this.elementsPerColumn = elementsPerColumn;
	}

	public List<KeyValue> getListOptions() {
		return listOptions;
	}

	public void setListOptions(List<KeyValue> listOptions) {
		this.listOptions = listOptions;
	}

	public void addListOption(KeyValue kv) {
		if (this.listOptions == null) {
			this.listOptions = new ArrayList<KeyValue>();
		}
		this.listOptions.add(kv);
	}

	public void addListOption(String keyValue) {
		if (this.listOptions == null) {
			this.listOptions = new ArrayList<KeyValue>();
		}
		String[] kv = null;
		if (keyValue.contains(":")) {
			kv = keyValue.split(":");
		} else if (keyValue.contains("=")) {
			kv = keyValue.split("=");
		}
		if (kv != null && kv.length > 1) {
			addListOption(new KeyValue(StringUtils.trim(kv[0]), StringUtils.trim(kv[1])));
		} else {
			addListOption(new KeyValue(StringUtils.trim(keyValue), StringUtils.trim(keyValue)));
		}
	}

	public void addListOption(String[] options) {
		for (String s : options) {
			addListOption(s);
		}
	}

	public HtmlFormWrapper getParentForm() {
		return parentForm;
	}

	public void setParentForm(HtmlFormWrapper parentForm) {
		this.parentForm = parentForm;
	}

	public HtmlFormWrapper getChildForm() {
		return childForm;
	}

	public void setChildForm(HtmlFormWrapper childForm) {
		this.childForm = childForm;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public boolean isFormFlowKey() {
		return formFlowKey;
	}

	public void setFormFlowKey(boolean formFlowKey) {
		this.formFlowKey = formFlowKey;
	}

	/*
	 * public boolean isFormFlowProcess() { return formFlowProcess; }
	 * 
	 * public void setFormFlowProcess(boolean formFlowProcess) {
	 * this.formFlowProcess = formFlowProcess; }
	 */

	public boolean isPreview() {
		return preview;
	}

	public void setPreview(boolean preview) {
		this.preview = preview;
	}

	public String getCustomTemplate() {
		return customTemplate;
	}

	public void setCustomTemplate(String customTemplate) {
		this.customTemplate = customTemplate;
	}

	public List<String> getRules() {
		return rules;
	}

	public void setRules(List<String> rules) {
		this.rules = rules;
	}

	@JsonSetter
	public void setRules(String[] rules) {
		for (String rule : rules) {
			this.rules.add(rule);
		}
	}

	public void addRule(String rule) {
		this.rules.add(rule);
	}

	public List<HtmlElementRuleGroupWrapper> getRuleGroups() {
		return ruleGroups;
	}
	
	@JsonSetter
	public void setRuleGroups(List<HtmlElementRuleGroupWrapper> ruleGroups) {
		this.ruleGroups = ruleGroups;
	}

	public void addRuleGroup(HtmlElementRuleGroupWrapper ruleGroup) {
		this.ruleGroups.add(ruleGroup);
	}

	
	public void addRuleGroup(HtmlElementRuleGroup ruleGroup) {
		this.ruleGroups.add(new HtmlElementRuleGroupWrapper(ruleGroup));
	}


	public void setRuleGroups(HtmlElementRuleGroup[] ruleGroups) {
		for (HtmlElementRuleGroup g : ruleGroups) {
			this.ruleGroups.add(new HtmlElementRuleGroupWrapper(g));
		}
	}

	public void setRuleGroups(HtmlElementRuleGroups ruleGroups) {
		setRuleGroups(ruleGroups.value());
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

	public boolean isControlType(String controlType) {
		return StringUtils.equalsIgnoreCase(this.controlType, controlType);
	}

	public boolean isControlType(ControlType controlType) {
		return StringUtils.equalsIgnoreCase(this.controlType, controlType.name());
	}

	@JSON(include = false)
	public boolean isRelationControlType(ControlType controlType) {
		return (controlType.name().equals(ControlType.list.name())
				|| controlType.name().equals(ControlType.checkbox.name())
				|| controlType.name().equals(ControlType.radio.name())
				|| controlType.name().equals(ControlType.select.name()));
	}

	@JSON(include = false)
	public boolean isRelationControlType() {
		return (isControlType(ControlType.list) || isControlType(ControlType.checkbox)
				|| isControlType(ControlType.radio) || isControlType(ControlType.select));
	}

	public boolean isRelation(String relation) {
		return StringUtils.equalsIgnoreCase(this.relation.getType(), relation);
	}

	public boolean isRelation(RelationType relation) {
		return StringUtils.equalsIgnoreCase(this.relation.getType(), relation.name());
	}

	public boolean isDataType(String type) {
		return StringUtils.equalsIgnoreCase(dataType, type);
	}

	public boolean isDataType(Class type) {
		return StringUtils.equalsIgnoreCase(dataType, type.getName());
	}

	@JSON(include = false)
	public boolean isNumericDataType() {
		return StringUtils.equalsIgnoreCase(dataType, "java.lang.Integer")
				|| StringUtils.equalsIgnoreCase(dataType, "java.lang.Long")
				|| StringUtils.equalsIgnoreCase(dataType, "java.lang.Float")
				|| StringUtils.equalsIgnoreCase(dataType, "java.lang.Double");
	}
	@JSON(include = false)
	public boolean isCollectionDataType() {
		return AnnotationUtil.isCollectionType(dataType);
	}

	@JSON(include = false)
	public boolean isAlphaNumericDataType() {
		return AnnotationUtil.isAlphaNumericType(dataType);
	}

	@JSON(include = false)
	public boolean isValidFormClass() {
		return !(formClass.equals(Object.class.getName()));
	}

	@JSON(include = false)
	public String getRelationModelClass() {
		if (isValidRelationModelClass()) {
			
			return relation.getModelClass();
		}
		return null;
	}
	@JSON(include = false)
	public boolean isValidRelationModelClass() {
		if (relation != null && relation.getModelClass() != null
				&& !relation.getModelClass().equals(Object.class.getName())) {
			return true;
		}
		return false;
	}

	@JSON(include = false)
	public String getRelationMappingClass() {
		if (relation != null && relation.getModelClass() != null
				&& !relation.getMappingClass().equals(Object.class.getName())) {
			return relation.getMappingClass();
			
		}
		return null;
	}
	@JSON(include = false)
	public boolean isValidRelationMappingClass() {
		if (relation != null && relation.getModelClass() != null
				&& !relation.getMappingClass().equals(Object.class.getName())) {
			return true;
		}
		return false;
	}

	public List<HtmlEventWrapper> getEvents() {
		return events;
	}

	@JsonSetter
	public void setEvents(List<HtmlEventWrapper> events) {
		this.events = events;
	}

	public void addEvent(HtmlEvent event) {
		events.add(new HtmlEventWrapper(event));
	}

	
	public void setEvents(HtmlEvent[] events) {

		if (events == null || events.length == 0) {
			this.events.clear();
			return;
		}
		for (HtmlEvent event : events) {
			addEvent(event);
		}
	}

	public void updateEvents(List<HtmlElementWrapper> e, HtmlEventWrapper evt) {
		for (HtmlElementWrapper ele : e) {
			// if (ele.getName().equalsIgnoreCase(evt.getSource())) {
			if (!ele.getEvents().isEmpty()) {
				// for (HtmlEventWrapper setval : ele.getEvents()) {
				HtmlEventWrapper setval = new HtmlEventWrapper();
				setval.setProducer(evt.getProducer());
				setval.setReceiver(evt.getReceiver());
				setval.setName(evt.getName());
				setval.setAction(evt.getAction());
				ele.getEvents().add(setval);
				// }
			} else {
				ele.getEvents().add(evt);
			}

			// }
		}
	}

	public String getDateBefore() {
		return dateBefore;
	}

	public void setDateBefore(String dateBefore) {
		this.dateBefore = dateBefore;
	}

	public String getDateAfter() {
		return dateAfter;
	}

	public void setDateAfter(String dateAfter) {
		this.dateAfter = dateAfter;
	}


	public boolean isTooltip() {
		return tooltip;
	}

	public void setTooltip(boolean tooltip) {
		this.tooltip = tooltip;
	}

	public String getHelpText() {
		return helpText;
	}

	public void setHelpText(String helpText) {
		this.helpText = helpText;
	}

	public String getYearBefore() {
		return yearBefore;
	}

	public void setYearBefore(String yearBefore) {
		this.yearBefore = yearBefore;
	}

	public String getYearAfter() {
		return yearAfter;
	}

	public String getMatchWith() {
		return matchWith;
	}

	public void setMatchWith(String matchWith) {
		this.matchWith = matchWith;
	}

	public void setYearAfter(String yearAfter) {
		this.yearAfter = yearAfter;
	}

	public String getMonthBefore() {
		return monthBefore;
	}

	public void setMonthBefore(String monthBefore) {
		this.monthBefore = monthBefore;
	}

	public String getMonthAfter() {
		return monthAfter;
	}

	public void setMonthAfter(String monthAfter) {
		this.monthAfter = monthAfter;
	}

	public String getDayBefore() {
		return dayBefore;
	}

	public void setDayBefore(String dayBefore) {
		this.dayBefore = dayBefore;
	}

	public String getDayAfter() {
		return dayAfter;
	}

	public void setDayAfter(String dayAfter) {
		this.dayAfter = dayAfter;
	}
/*commented by prachi gupta
	public boolean hasDateValidation() {
		if (StringUtils.isNotBlank(dateBefore) || StringUtils.isNotBlank(dateAfter) || yearBefore > 0 || yearAfter > 0
				|| monthBefore > 0 || monthAfter > 0 || dayBefore > 0 || dayAfter > 0) {
			return true;
		} else {
			return false;
		}
	}
*/
	
	public boolean hasDateValidation() {
		if (StringUtils.isNotBlank(dateBefore) || StringUtils.isNotBlank(dateAfter) || StringUtils.isNotBlank(yearBefore) || StringUtils.isNotBlank(dateAfter)
				|| StringUtils.isNotBlank(monthBefore)  || StringUtils.isNotBlank(monthAfter)  || StringUtils.isNotBlank(dayBefore)  || StringUtils.isNotBlank(dayAfter)) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public String toString() {
		return "HtmlElementWrapper [name=" + name + ", attribute=" + attribute + ", dataType=" + dataType + ", key="
				+ key + ", label=" + label + ", exclude=" + exclude + ", unique=" + unique + ", depends=" + depends
				+ ", placeHolder=" + placeHolder + ", controlType=" + controlType + ", validType=" + validType
				+ ", defaultValue=" + defaultValue + ", readOnly=" + readOnly + ", listField=" + listField
				+ ", relation=" + relation + ", listable=" + listable + ", displayWidth=" + displayWidth + ", required="
				+ required + ", dataQuery=" + dataQuery + ", tableRowAlign=" + tableRowAlign + ", group=" + group
				+ ", tab=" + tab + ", elementsPerColumn=" + elementsPerColumn + ", rules=" + rules + ", ruleGroups="
				+ ruleGroups + ", listOptions=" + listOptions + ", formDefinition=" + parentForm + ", events="
				+ events + "]";
	}

}
