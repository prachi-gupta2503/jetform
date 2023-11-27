package com.adjecti.jetform.list.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class FilterDef implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String label;
	private String field;
	private String fieldType;
	private String criteria;
	private String defaultValue;
	private String control;
	private String dataSetClass;
	private String dataSetType;
	private String dataSetValue;
	private boolean hidden;
	private boolean exportable;
	private boolean advance;
	private int range;
	private boolean required;
	private String cascadeType;
	private String cascadeCriteria;
	private String cascadeAlias;
	private boolean cascadeLoad;
	private List<String> cascadeChildren=new ArrayList<String>();
	
	private List<KeyValuePair> controlData = new ArrayList<KeyValuePair>();

	
	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public String getLabel() {

		return label;
	}

	public void setLabel(String label) {

		this.label = label;
	}

	public String getField() {

		return field;
	}

	public void setField(String field) {

		this.field = field;
	}

	public String getFieldType() {

		return fieldType;
	}

	public void setFieldType(String fieldType) {

		this.fieldType = fieldType;
	}

	public String getCriteria() {

		return criteria;
	}

	public void setCriteria(String criteria) {

		this.criteria = criteria;
	}

	public String getDefaultValue() {

		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {

		this.defaultValue = defaultValue;
	}

	public String getControl() {
		return control;
	}

	public void setControl(String control) {
		this.control = control;
	}

	public String getDataSetType() {
		return dataSetType;
	}

	public void setDataSetType(String dataSetType) {
		this.dataSetType = dataSetType;
	}

	public String getDataSetClass() {
		return dataSetClass;
	}

	public void setDataSetClass(String dataSetClass) {
		this.dataSetClass = dataSetClass;
	}

	public String getDataSetValue() {
		return dataSetValue;
	}

	public void setDataSetValue(String dataSetValue) {
		this.dataSetValue = dataSetValue;
	}

	public boolean isHidden() {

		return hidden;
	}

	public void setHidden(boolean hidden) {

		this.hidden = hidden;
	}

	public boolean isExportable() {
		return exportable;
	}

	public void setExportable(boolean exportable) {
		this.exportable = exportable;
	}

	public boolean isAdvance() {

		return advance;
	}

	public void setAdvance(boolean advance) {

		this.advance = advance;
	}

	public int getRange() {

		return range;
	}

	public void setRange(int range) {

		this.range = range;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public String getCascadeType() {
		return cascadeType;
	}

	public void setCascadeType(String cascadeType) {
		this.cascadeType = cascadeType;
	}

	public String getCascadeCriteria() {
		return cascadeCriteria;
	}

	public void setCascadeCriteria(String cascadeCriteria) {
		this.cascadeCriteria = cascadeCriteria;
	}

	public String getCascadeAlias() {
		return cascadeAlias;
	}

	public void setCascadeAlias(String cascadeAlias) {
		this.cascadeAlias = cascadeAlias;
	}

	public boolean isCascadeLoad() {
		return cascadeLoad;
	}

	public void setCascadeLoad(boolean cascadeLoad) {
		this.cascadeLoad = cascadeLoad;
	}

	public List<String> getCascadeChildren() {
		return cascadeChildren;
	}

	public void setCascadeChildren(List<String> cascadeChildren) {
		this.cascadeChildren = cascadeChildren;
	}

	public List<KeyValuePair> getControlData() {
		return controlData;
	}

	public void setControlData(List<KeyValuePair> controlData) {
		this.controlData = controlData;
	}
	
	public int controlDataSize() {
		return controlData.size();
	}

	public boolean isControlDataEmpty() {
		return controlData.isEmpty();
	}

	public boolean containsControlData(Object o) {
		return controlData.contains(o);
	}

	public Iterator<KeyValuePair> controlDataIterator() {
		return controlData.iterator();
	}

	public Object[] controlDataToArray() {
		return controlData.toArray();
	}

	public <T> T[] controlDataToArray(T[] a) {
		return controlData.toArray(a);
	}

	public boolean addControlData(KeyValuePair e) {
		return controlData.add(e);
	}

	public boolean removeControlData(Object o) {
		return controlData.remove(o);
	}

	public boolean addAllControlData(Collection<? extends KeyValuePair> c) {
		return controlData.addAll(c);
	}

	public boolean removeAllControlData(Collection<?> c) {
		return controlData.removeAll(c);
	}

	public void clearControlData() {
		controlData.clear();
	}

	public KeyValuePair getControlData(int index) {
		return controlData.get(index);
	}

	public KeyValuePair setControlData(int index, KeyValuePair element) {
		return controlData.set(index, element);
	}

	public void addControlData(int index, KeyValuePair element) {
		controlData.add(index, element);
	}

	public KeyValuePair removeControlData(int index) {
		return controlData.remove(index);
	}

	public int indexOfControlData(Object o) {
		return controlData.indexOf(o);
	}

}
