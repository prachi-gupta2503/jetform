package com.adjecti.jetform.list.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ListDef implements Serializable {

	private static final long serialVersionUID = 1L;
	private String configKey;
	private String objectClass;
	private DataSet dataSet;
	private boolean loadOnStart;
	private boolean searchInResult;
	private boolean exportFromResult;
	private boolean exportFilter;
	private boolean pagination;
	private boolean searchable;
	private boolean exportable;
	private boolean rowIndex=true;
	private String searchAlignment;
	private String controlAlignment;
	private List<FieldDef> fields = new ArrayList<FieldDef>();
	private List<FilterDef> filters = new ArrayList<FilterDef>();
	private List<StyleDef> styles = new ArrayList<StyleDef>();
	private List<ActionControl> controls = new ArrayList<ActionControl>();
	private Map<String, String> parameters = new HashMap<String, String>();
	private List<String> titles=new ArrayList<String>();
	private List<RowFormat> rowConditionalFormats=new ArrayList<RowFormat>();
	private String chartType;
	private ChartDef chartDef;
	private List dataList=new ArrayList();

	public String getConfigKey() {
		return configKey;
	}

	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}

	public String getObjectClass() {

		return objectClass;
	}

	public void setObjectClass(String objectClass) {

		this.objectClass = objectClass;
	}

	public DataSet getDataSet() {

		return dataSet;
	}

	public void setDataSet(DataSet dataSet) {

		this.dataSet = dataSet;
	}

	public boolean isLoadOnStart() {
		return loadOnStart;
	}

	public void setLoadOnStart(boolean loadOnStart) {
		this.loadOnStart = loadOnStart;
	}

	public boolean isSearchInResult() {
		return searchInResult;
	}

	public void setSearchInResult(boolean searchInResult) {
		this.searchInResult = searchInResult;
	}

	public boolean isExportFromResult() {
		return exportFromResult;
	}

	public void setExportFromResult(boolean exportFromResult) {
		this.exportFromResult = exportFromResult;
	}

	public boolean isExportFilter() {
		return exportFilter;
	}

	public void setExportFilter(boolean exportFilter) {
		this.exportFilter = exportFilter;
	}

	public boolean isPagination() {
		return pagination;
	}

	public void setPagination(boolean pagination) {
		this.pagination = pagination;
	}

	public boolean isSearchable() {

		return searchable;
	}

	public void setSearchable(boolean searchable) {

		this.searchable = searchable;
	}

	public boolean isExportable() {
		return exportable;
	}

	public void setExportable(boolean exportable) {
		this.exportable = exportable;
	}

	public boolean isRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(boolean rowIndex) {
		this.rowIndex = rowIndex;
	}

	public String getSearchAlignment() {
		return searchAlignment;
	}

	public void setSearchAlignment(String searchAlignment) {
		this.searchAlignment = searchAlignment;
	}

	public String getControlAlignment() {
		return controlAlignment;
	}

	public void setControlAlignment(String controlAlignment) {
		this.controlAlignment = controlAlignment;
	}

	public List<FieldDef> getFields() {
		return fields;
	}

	public void setFields(List<FieldDef> fields) {
		this.fields = fields;
	}

	public List<FilterDef> getFilters() {
		return filters;
	}

	public void setFilters(List<FilterDef> filters) {
		this.filters = filters;
	}

	public List<StyleDef> getStyles() {
		return styles;
	}

	public void setStyles(List<StyleDef> styles) {
		this.styles = styles;
	}
	
	public List<ActionControl> getControls() {
		return controls;
	}

	public void setControls(List<ActionControl> controls) {
		this.controls = controls;
	}

	public Map<String, String> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}

	public List getDataList() {
		return dataList;
	}

	public void setDataList(List dataList) {
		this.dataList = dataList;
	}

	public List<String> getTitles() {
		return titles;
	}

	public void setTitles(List<String> titles) {
		this.titles = titles;
	}

	public List<RowFormat> getRowConditionalFormats() {
		return rowConditionalFormats;
	}

	public void setRowConditionalFormats(List<RowFormat> rowConditionalFormats) {
		this.rowConditionalFormats = rowConditionalFormats;
	}

	public String getDataSetType() {
		return dataSet.getType();
	}

	public void setDataSetType(String type) {
		dataSet.setType(type);
	}

	public String getDataSetValue() {
		return dataSet.getValue();
	}

	public void setDataSetValue(String value) {
		dataSet.setValue(value);
	}

	public boolean isNamedDataSet() {
		return dataSet.isNamed();
	}

	public void setNamedDataSet(boolean named) {
		dataSet.setNamed(named);
	}

	public ChartDef getChartDef() {
		return chartDef;
	}

	public void setChartDef(ChartDef chartDef) {
		this.chartDef = chartDef;
	}

	public String getChartType() {
		return chartType;
	}

	public void setChartType(String chartType) {
		this.chartType = chartType;
	}

	public int fieldsSize() {
		return fields.size();
	}

	public boolean isFieldsEmpty() {
		return fields.isEmpty();
	}

	public boolean containsField(Object o) {
		return fields.contains(o);
	}

	public Iterator<FieldDef> fieldIterator() {
		return fields.iterator();
	}

	public boolean addField(FieldDef e) {
		return fields.add(e);
	}

	public boolean removeField(Object o) {
		return fields.remove(o);
	}

	public boolean addAllFields(Collection<? extends FieldDef> c) {
		return fields.addAll(c);
	}

	public boolean removeAllFields(Collection<?> c) {
		return fields.removeAll(c);
	}

	public void clearFields() {
		fields.clear();
	}

	public FieldDef getField(int index) {
		return fields.get(index);
	}

	public void addField(int index, FieldDef element) {
		fields.add(index, element);
	}

	public FieldDef removeField(int index) {
		return fields.remove(index);
	}

	public int indexOfField(Object o) {
		return fields.indexOf(o);
	}

	public int filtersSize() {
		return filters.size();
	}

	public boolean isFiltersEmpty() {
		return filters.isEmpty();
	}

	public boolean containsFilter(Object o) {
		return filters.contains(o);
	}

	public Iterator<FilterDef> filtersIterator() {
		return filters.iterator();
	}

	public boolean addFilter(FilterDef e) {
		return filters.add(e);
	}

	public boolean removeFilter(Object o) {
		return filters.remove(o);
	}

	public boolean addAllFilters(Collection<? extends FilterDef> c) {
		return filters.addAll(c);
	}

	public void clearFilters() {
		filters.clear();
	}

	public FilterDef getFilter(int index) {
		return filters.get(index);
	}

	public FilterDef getFilterByName(String name) {
		FilterDef filter=null; 
		for(FilterDef f:filters){
			if(f.getName().equalsIgnoreCase(name)){
				filter=f;
				break;
			}
		}
		return filter;
	}

	public FilterDef setFilter(int index, FilterDef element) {
		return filters.set(index, element);
	}

	public void addFilter(int index, FilterDef element) {
		filters.add(index, element);
	}

	public FilterDef removeFilter(int index) {
		return filters.remove(index);
	}

	public int indexOfFilter(Object o) {
		return filters.indexOf(o);
	}

	public int stylesSize() {
		return styles.size();
	}

	public boolean isStylesEmpty() {
		return styles.isEmpty();
	}

	public boolean containsStyle(Object o) {
		return styles.contains(o);
	}

	public Iterator<StyleDef> stylesIterator() {
		return styles.iterator();
	}

	public boolean addStyle(StyleDef e) {
		return styles.add(e);
	}

	public boolean removeStyle(Object o) {
		return styles.remove(o);
	}

	public boolean containsAllStyles(Collection<?> c) {
		return styles.containsAll(c);
	}

	public boolean addAllStyles(Collection<? extends StyleDef> c) {
		return styles.addAll(c);
	}

	public boolean removeAllStyles(Collection<?> c) {
		return styles.removeAll(c);
	}

	public void clearStyles() {
		styles.clear();
	}

	public StyleDef getStyle(int index) {
		return styles.get(index);
	}

	public StyleDef setStyle(int index, StyleDef element) {
		return styles.set(index, element);
	}

	public void addStyle(int index, StyleDef element) {
		styles.add(index, element);
	}

	public StyleDef removeStyle(int index) {
		return styles.remove(index);
	}

	public int indexOfStyle(Object o) {
		return styles.indexOf(o);
	}
	
}
