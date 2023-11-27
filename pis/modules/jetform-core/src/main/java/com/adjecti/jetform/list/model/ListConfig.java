package com.adjecti.jetform.list.model;

import com.adjecti.common.util.FormatUtils;
import com.adjecti.common.util.PropUtils;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

public class ListConfig {

	public static final String LIST_CONFIG_RESOURCE = "list.properties";

	public static final String PROP_LIST_CONFIG = "listConfig";
	public static final String PROP_LOAD_ONSTART = "loadOnStart";
	public static final String PROP_SEARCH_INRESULT = "searchInResult";
	public static final String PROP_EXPORT_FROMRESULT = "exportFromResult";
	public static final String PROP_EXPORT_FILTER = "exportFilter";
	public static final String PROP_ROW_INDEX = "rowIndex";
	public static final String PROP_PAGINATION = "pagination";
	public static final String PROP_OBJECT_CLASS = "object.class";
	public static final String PROP_OBJECT_DATASET_TYPE = "object.dataSet.type";
	public static final String PROP_OBJECT_DATASET_VALUE = "object.dataSet.value";
	public static final String PROP_OBJECT_DATASET_NAMED = "object.dataSet.named";
	public static final String PROP_CONTROL_ALIGNMENT = "control.alignment";

	public static final String PROP_EXPORT_ENABLED = "export.enabled";
	public static final String PROP_SEARCH_ENABLED = "search.enabled";
	public static final String PROP_SEARCH_ALIGNMENT = "search.alignment";
	public static final String PROP_SEARCH_FILTER = "search.filter.{0}";
	public static final String PROP_SEARCH_FILTER_NAME = PROP_SEARCH_FILTER + ".name";
	public static final String PROP_SEARCH_FILTER_LABEL = PROP_SEARCH_FILTER + ".label";
	public static final String PROP_SEARCH_FILTER_FIELD = PROP_SEARCH_FILTER + ".field";
	public static final String PROP_SEARCH_FILTER_FIELD_TYPE = PROP_SEARCH_FILTER_FIELD + ".type";
	public static final String PROP_SEARCH_FILTER_FIELD_VALUE = PROP_SEARCH_FILTER_FIELD + ".value";
	public static final String PROP_SEARCH_FILTER_CRITERIA = PROP_SEARCH_FILTER + ".criteria";
	public static final String PROP_SEARCH_FILTER_HIDDEN = PROP_SEARCH_FILTER + ".hidden";
	public static final String PROP_SEARCH_FILTER_MAXRANGE = PROP_SEARCH_FILTER + ".maxrange";

	public static final String PROP_FIELD = "field.{0}";
	public static final String PROP_FIELD_NAME = PROP_FIELD + ".name";
	public static final String PROP_FIELD_DATA = PROP_FIELD + ".data";
	public static final String PROP_FIELD_DATA_FORMAT = PROP_FIELD_DATA + ".format";
	public static final String PROP_FIELD_DATA_STYLE = PROP_FIELD_DATA + ".style";
	public static final String PROP_FIELD_LABEL = PROP_FIELD + ".label";
	public static final String PROP_FIELD_LABEL_STYLE = PROP_FIELD_LABEL + ".format";
	public static final String PROP_FIELD_HIDDEN = PROP_FIELD + ".hidden";
	public static final String PROP_FIELD_SORT = PROP_FIELD + ".sort";
	public static final String PROP_FIELD_ACTION = PROP_FIELD + ".action.{0}";
	public static final String PROP_FIELD_ACTION_TYPE = PROP_FIELD_ACTION + ".type";
	public static final String PROP_FIELD_ACTION_PARAM = PROP_FIELD_ACTION + ".param{0}";

	public static final String PROP_STYLE = "style.{0}";
	public static final String PROP_STYLE_FORMAT = PROP_STYLE + ".format";
	public static final String PROP_STYLE_ALIGN = PROP_STYLE + ".align";
	
	public static final String PROP_ROW_FORMAT = "row.format.{0}";

	public static final String[] STYLE_TYPES = { "integer", "double", "date", "datetime", "string" };

	private Map<String, ListDef> definitions = new HashMap<String, ListDef>();
	private static ListConfig config = null;
	
	public static ListConfig getInstance() {
		if (config == null) {
			config = new ListConfig();
		}
		return config;
	}

	private ListConfig() {
	}
	

	public ListDef getListDefinition(String resourceKey) {
		return getListDefinition(resourceKey, false);
	}
	
	public ListDef getListDefinition(String resourceKey, boolean loadData) {
		ListDef listDef = null;//definitions.get(resourceKey);
		
		if(listDef==null){
			listDef = createListDefinition(resourceKey);
		}
		
		if (listDef.isLoadOnStart() == loadData && loadData) {
			listDef.setDataList(getDefaultDataList(listDef));
		}else if(loadData){
			listDef.setDataList(getDefaultDataList(listDef));
		}
		
		definitions.put(resourceKey, listDef);
		
		return listDef;
	}

	private ListDef createListDefinition(String resourceKey) {
		ListDef listDef = new ListDef();
		try {
			Properties configuration=PropUtils.getProperties(resourceKey);

			listDef.setConfigKey(resourceKey);
			listDef.setLoadOnStart(PropUtils.getBoolean(configuration, PROP_LOAD_ONSTART));
			listDef.setSearchInResult(PropUtils.getBoolean(configuration, PROP_SEARCH_INRESULT));
			listDef.setExportFromResult(PropUtils.getBoolean(configuration, PROP_EXPORT_FROMRESULT));
			listDef.setRowIndex(PropUtils.getBoolean(configuration, PROP_ROW_INDEX, true));
			listDef.setPagination(PropUtils.getBoolean(configuration, PROP_PAGINATION));
			listDef.setObjectClass( PropUtils.getString(configuration,PROP_OBJECT_CLASS));
			listDef.setSearchable(PropUtils.getBoolean(configuration, PROP_SEARCH_ENABLED));
			listDef.setExportable(PropUtils.getBoolean(configuration, PROP_EXPORT_ENABLED));
			listDef.setSearchAlignment(PropUtils.getString(configuration, PROP_SEARCH_ALIGNMENT));
			listDef.setExportFilter(PropUtils.getBoolean(configuration, PROP_EXPORT_FILTER,true));

			listDef.setTitles(getTitles(configuration));
			listDef.setDataSet(getDataSet(configuration));
			listDef.setFilters(getFilters(configuration));
			listDef.setFields(getFields(configuration));
			listDef.setChartType(PropUtils.getString(configuration, "chart.type"));
			listDef.setChartDef(getChartDef(configuration, listDef.getChartType()));
			listDef.setStyles(getStyles(configuration));
			listDef.setControlAlignment(PropUtils.getString(configuration, PROP_CONTROL_ALIGNMENT,"bottom"));
			listDef.setControls(getControls(configuration));

			listDef.setRowConditionalFormats(getRowConditionalFormats(configuration));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listDef;
	}



	private List<String> getTitles(Properties configuration) {
		List<String> titles=new ArrayList<String>();
		for(int i=0;true;i++){
			String title=PropUtils.getString(configuration, "title."+i);
			if(StringUtils.isEmpty(title)){
				break;
			}
			titles.add(title);
		}
		return titles;
	}

	private List getDefaultDataList(ListDef listDef) {
		List list = new ArrayList();
		try {
			listDef.setParameters(getFilterParameters(listDef.getFilters()));
			//list = listService.getDataList(listDef, null);
			listDef.getParameters().clear();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
		/*
		 * long today=new Date().getTime();
		 * 
		 * OrderListModel m1=new OrderListModel(); m1.setOrderId(1);
		 * m1.setOrderNo("ORD001"); m1.setOrderDate(new Date(today));
		 * m1.setCustomerName("Vijay Dhanankar"); m1.setOrderStatusId(1);
		 * 
		 * OrderListModel m2=new OrderListModel(); m2.setOrderId(2);
		 * m2.setOrderNo("ORD002"); m2.setOrderDate(new
		 * Date(today-(1*24*60*60*1000))); m2.setCustomerName("Ashutosh Nayak");
		 * m2.setOrderStatusId(2);
		 * 
		 * OrderListModel m3=new OrderListModel(); m3.setOrderId(3);
		 * m3.setOrderNo("ORD003"); m3.setOrderDate(new
		 * Date(today-(2*24*60*60*1000))); m3.setCustomerName("Anshuman Nayak");
		 * m3.setOrderStatusId(3); list.add(m1); list.add(m2); list.add(m3);
		 * return list;
		 */
	}

	private DataSet getDataSet(Properties configuration) {
		DataSet dataSet = new DataSet();
		dataSet.setType(PropUtils.getString(configuration, PROP_OBJECT_DATASET_TYPE));
		dataSet.setValue(PropUtils.getString(configuration, PROP_OBJECT_DATASET_VALUE));
		dataSet.setNamed(PropUtils.getBoolean(configuration,  PROP_OBJECT_DATASET_NAMED));
		return dataSet;
	}

	private List<FilterDef> getFilters(Properties properties) {
		List<FilterDef> filters = new ArrayList<FilterDef>();
		for (int i = 0; true; i++) {
			String propFilterKey = MessageFormat.format(PROP_SEARCH_FILTER,i);
			String filterName = PropUtils.getString(properties,propFilterKey);

			if (StringUtils.isEmpty(filterName)) {
				filterName = propFilterKey;
			}

			String filterField = PropUtils.getString(properties,filterName + ".field");
			if (StringUtils.isEmpty(filterField)) {
				break;
			}

			FilterDef filter = new FilterDef();
			filter.setName(filterName);
			filter.setField(filterField);
			filter.setFieldType(PropUtils.getString(properties,filterName + ".field.type"));
			filter.setControl(PropUtils.getString(properties,filterName + ".control"));
			filter.setDataSetClass(PropUtils.getString(properties,filterName + ".dataset.class"));
			filter.setDataSetType(PropUtils.getString(properties,filterName + ".dataset.type"));
			filter.setDataSetValue(PropUtils.getString(properties,filterName + ".dataset." + StringUtils.trim(filter.getDataSetType())));
			filter.setLabel(PropUtils.getString(properties,filterName + ".label"));
			filter.setCriteria(PropUtils.getString(properties,filterName + ".criteria"));
			filter.setDefaultValue(PropUtils.getString(properties,filterName + ".default.value"));
			filter.setAdvance(PropUtils.getBoolean(properties, filterName + ".advance"));
			filter.setRange(PropUtils.getInt(properties, filterName + ".range"));
			filter.setRequired(PropUtils.getBoolean(properties, filterName + ".required"));
			filter.setCascadeType(PropUtils.getString(properties, filterName + ".cascade.type"));
			filter.setExportable(PropUtils.getBoolean(properties, filterName + ".exportable",true));
			
			if("parent".equalsIgnoreCase(filter.getCascadeType())){
				filter.setCascadeChildren(getCascadeChildren(filterName, properties));
			}else if("child".equalsIgnoreCase(filter.getCascadeType())){
				filter.setCascadeCriteria(PropUtils.getString(properties, filterName + ".cascade.criteria"));
				filter.setCascadeAlias(PropUtils.getString(properties, filterName + ".cascade.alias"));
				filter.setCascadeLoad(PropUtils.getBoolean(properties, filterName + ".cascade.load"));
			}
			if (StringUtils.isNotEmpty(filter.getDataSetClass())) {
				if("child".equalsIgnoreCase(filter.getCascadeType())){
					if(!filter.isCascadeLoad()){
						filter.setControlData(getControlData(filter.getDataSetType(), filter.getDataSetClass(), filter.getDataSetValue()));
					}
				}else{
					filter.setControlData(getControlData(filter.getDataSetType(), filter.getDataSetClass(), filter.getDataSetValue()));
				}
			}
			
			filter.setHidden("hidden".equalsIgnoreCase(filter.getControl()));
			filters.add(filter);
		}
		return filters;
	}

	private List<String> getCascadeChildren(String filterName, Properties properties) {
		List<String> cascadeChildren=new ArrayList<String>();
		String cascadeKeyName=filterName+".cascade.child.{0}";
		for (int i = 0; true; i++) {
			String cascadeKey = MessageFormat.format(cascadeKeyName, i);
			String cascadeChild = PropUtils.getString(properties,cascadeKey);
			if(StringUtils.isEmpty(cascadeChild)){
				break;
			}
			cascadeChildren.add(cascadeChild);
		}
		return cascadeChildren;
	}

	private List<KeyValuePair> getControlData(String dataSetType, String dataSetClass, String dataSetValue) {
		return null;
		//return listService.getFilterControlData(dataSetType, dataSetClass, dataSetValue, null, null);
	}

	private List<FieldDef> getFields(Properties properties) {
		List<FieldDef> fields = new ArrayList<FieldDef>();
		for (int i = 0; true; i++) {
			String propFieldKey = MessageFormat.format(PROP_FIELD, i);
			String fieldName = PropUtils.getString(properties,propFieldKey);

			boolean propFieldKeyAsfieldName=false;
			if (StringUtils.isEmpty(fieldName)) {
				fieldName = propFieldKey;
				propFieldKeyAsfieldName=true;
			}
			if (StringUtils.isEmpty(fieldName)) {
				break;
			}
			String fieldData = PropUtils.getString(properties,fieldName.trim() + ".data");
			
			if (StringUtils.isEmpty(fieldData)) {
				if(!propFieldKeyAsfieldName) {
					fieldData=fieldName;
				}else {
					break;
				}
			}

			FieldDef field = new FieldDef();
			field.setName(fieldName);
			field.setData(fieldData);
			field.setLabel(PropUtils.getString(properties,fieldName + ".label"));
			field.setDataType(PropUtils.getString(properties,fieldName + ".data.type"));
			field.setDataFormat(PropUtils.getString(properties,fieldName + ".data.format"));
			field.setDataStyle(PropUtils.getString(properties,fieldName + ".data.style"));
			field.setLabelStyle(PropUtils.getString(properties,fieldName + ".label.style"));
			field.setCssStyle(PropUtils.getString(properties,fieldName + ".style"));
			field.setCssClass(PropUtils.getString(properties,fieldName + ".class"));
			field.setWidth(PropUtils.getString(properties,fieldName + ".width"));
			field.setSort(PropUtils.getString(properties,fieldName + ".sort"));
			field.setHidden(PropUtils.getBoolean(properties, fieldName + ".hidden"));
			field.setControls(getFieldControls(i, fieldName, properties));

			fields.add(field);
		}
		return fields;
	}

	private List<ActionControl> getControls(Properties properties) {
		List<ActionControl> controls = new ArrayList<ActionControl>();
		String baseCtrlKey = "control.{0}";

		for (int i = 0; true; i++) {
			String ctrlKey = MessageFormat.format(baseCtrlKey, i);
			String ctrlName = PropUtils.getString(properties,ctrlKey);

			if (StringUtils.isEmpty(ctrlName)) {
				ctrlName=ctrlKey;
			}

			String caption=PropUtils.getString(properties,ctrlName + ".caption");
			
			if(StringUtils.isEmpty(caption)){
				break;
			}
			
			ActionControl ctrl = new ActionControl();
			ctrl.setName(ctrlName);
			ctrl.setElementId(PropUtils.getString(properties,ctrlName + ".elementId"));
			ctrl.setType(PropUtils.getString(properties,ctrlName + ".type"));
			ctrl.setCaption(caption);
			ctrl.setEvent(PropUtils.getString(properties,ctrlName + ".event"));
			ctrl.setEventAction(PropUtils.getString(properties,ctrlName + ".event.action"));
			ctrl.setCss(PropUtils.getString(properties,ctrlName + ".css"));
			ctrl.setEnable(PropUtils.getString(properties,ctrlName + ".enable"));
			ctrl.setVisible(PropUtils.getString(properties,ctrlName + ".visible"));
			ctrl.setParams(getEventActionParams(i, ctrlName, properties));
			ctrl.setIcon(PropUtils.getString(properties,ctrlName + ".icon"));
			
			controls.add(ctrl);
		}
		return controls;
	}
	private List<ActionControl> getFieldControls(int fieldIndex, String fieldName, Properties properties) {
		List<ActionControl> controls = new ArrayList<ActionControl>();
		String baseCtrlKey = fieldName + ".control.{0}";

		for (int i = 0; true; i++) {
			String ctrlKey = MessageFormat.format(baseCtrlKey, i);
			String ctrlName = PropUtils.getString(properties,ctrlKey);

			if (StringUtils.isEmpty(ctrlName)) {
				break;
			}

			ActionControl ctrl = new ActionControl();
			ctrl.setName(ctrlName);
			ctrl.setType(PropUtils.getString(properties,ctrlKey + ".type"));
			ctrl.setCaption(PropUtils.getString(properties,ctrlKey + ".caption"));
			ctrl.setEvent(PropUtils.getString(properties,ctrlKey + ".event"));
			ctrl.setEventAction(PropUtils.getString(properties,ctrlKey + ".event.action"));
			ctrl.setElementId(PropUtils.getString(properties,ctrlKey + ".elementId"));
			ctrl.setCss(PropUtils.getString(properties,ctrlKey + ".css"));
			ctrl.setEnable(PropUtils.getString(properties,ctrlKey + ".enable"));
			ctrl.setVisible(PropUtils.getString(properties,ctrlKey + ".visible"));
			ctrl.setParams(getEventActionParams(i, ctrlKey, properties));
			ctrl.setIcon(PropUtils.getString(properties,ctrlKey + ".icon"));
			controls.add(ctrl);
		}
		return controls;
	}
	private List<String> getEventActionParams(int controlIndex, String ctrlKey, Properties properties) {
		List<String> params = new ArrayList<String>();
		for (int i = 0; true; i++) {
			String paramKey = MessageFormat.format(ctrlKey + ".param.{0}", i);
			String paramValue = PropUtils.getString(properties,paramKey);
			if (StringUtils.isEmpty(paramValue)) {
				break;
			}

			params.add(paramValue);
		}
		return params;
	}

	private List<StyleDef> getStyles(Properties properties) {
		List<StyleDef> styles = new ArrayList<StyleDef>();
		for (String type : STYLE_TYPES) {
			String format = PropUtils.getString(properties,MessageFormat.format(PROP_STYLE_FORMAT, type));
			String align = PropUtils.getString(properties,MessageFormat.format(PROP_STYLE_ALIGN, type));
			if (StringUtils.isEmpty(format) && StringUtils.isEmpty(align)) {
				continue;
			}
			StyleDef style = new StyleDef();
			style.setType(type);
			style.setFormat(format);
			style.setAlign(align);
			styles.add(style);
		}
		return styles;
	}
	
	private List<RowFormat> getRowConditionalFormats(Properties configuration) {
		List<RowFormat> formats = new ArrayList<RowFormat>();
		for (int i = 0; true; i++) {
			String propFormatKey = MessageFormat.format(PROP_ROW_FORMAT,i);
			String formatName = PropUtils.getString(configuration, propFormatKey);

			if (StringUtils.isEmpty(formatName)) {
				formatName = propFormatKey;
			}
			String cssClass=PropUtils.getString(configuration,formatName + ".css.class");
			String cssStyle=PropUtils.getString(configuration,formatName + ".css.style");
			if(StringUtils.isEmpty(cssClass) && StringUtils.isEmpty(cssStyle)){
				break;
			}
			RowFormat format = new RowFormat();
			format.setName(formatName);
			format.setCssClass(cssClass);
			format.setCssStyle(cssStyle);
			format.setExpr(PropUtils.getString(configuration,formatName + ".expr"));
			
			formats.add(format);
		}
		return formats;
	}
	
	private Map<String, String> getFilterParameters(List<FilterDef> filters) {
		Map<String, String> parameters = new HashMap<String, String>();
		for (FilterDef filter : filters) {
			String criteria=StringUtils.trim(filter.getCriteria());
			
			if (Date.class.getName().equalsIgnoreCase(filter.getFieldType())) {
				Calendar cal = Calendar.getInstance();
				if (criteria.toLowerCase().contains(" between ")) {
					parameters.put(filter.getField() + "_to", FormatUtils.formatDate(cal.getTime(), "dd/MM/yyyy"));
					cal.roll(Calendar.DATE, filter.getRange() * (-1));
					parameters.put(filter.getField() + "_from", FormatUtils.formatDate(cal.getTime(), "dd/MM/yyyy"));
				} else {
					parameters.put(filter.getField(), cal.getTime().toString());
				}
			} else if (StringUtils.isNotEmpty(filter.getDefaultValue())) {
				if (criteria.toLowerCase().contains(" like ")) {
					parameters.put(filter.getField(), '%'+filter.getDefaultValue()+'%');
				}else{
					parameters.put(filter.getField(), filter.getDefaultValue());
				}
			}
		}
		return parameters;
	}
	
	private ChartDef getChartDef(Properties configuration, String chartType) {
		ChartDef chart=null;
		if(StringUtils.isEmpty(chartType)){
			return chart;
		}
		
		if("bar".equalsIgnoreCase(chartType.trim()) || "pie".equalsIgnoreCase(chartType.trim()) || "doughnut".equalsIgnoreCase(chartType.trim())){
			chart=getBarPieDoughnutChartDef(configuration);
		}
		return chart;
	}

	private ChartDef getBarPieDoughnutChartDef(Properties configuration) {
		BarPieDoughnutChartDef chart=new BarPieDoughnutChartDef();
		chart.setLegend(PropUtils.getBoolean(configuration, "chart.legend",true));
		chart.setxSeries(PropUtils.getString(configuration, "chart.x"));
		chart.setxSeriesCount(PropUtils.getInt(configuration,"chart.x.count",5));
		chart.setLegendTemplate(PropUtils.getString(configuration,"chart.legend.template"));
		int y=0;
		while(true){
			String ySeries=PropUtils.getString(configuration, "chart.y."+y);
			if(StringUtils.isEmpty(ySeries)){
				break;
			}
			chart.addySeries(ySeries);
			y++;
		}
		return chart;
	}


	public static void main(String[] p) {
		ListDef def = new ListConfig().getListDefinition("order.created");
		def.setDataList(getListData());
		
		//Gson gson = new Gson();
		//System.out.println(JSONFactoryUtil.serialize(def));
	}

	public static List getListData() {
		long today = new Date().getTime();
		List list = new ArrayList();
		/*OrderListModel m1 = new OrderListModel();
		m1.setOrderId(1);
		m1.setOrderNo("ORD001");
		m1.setOrderDate(new Date(today));
		m1.setCustomerName("Vijay Dhanankar");
		m1.setOrderStatusId(1);

		OrderListModel m2 = new OrderListModel();
		m2.setOrderId(2);
		m2.setOrderNo("ORD002");
		m2.setOrderDate(new Date(today - (1 * 24 * 60 * 60 * 1000)));
		m2.setCustomerName("Ashutosh Nayak");
		m2.setOrderStatusId(2);

		OrderListModel m3 = new OrderListModel();
		m3.setOrderId(3);
		m3.setOrderNo("ORD003");
		m3.setOrderDate(new Date(today - (2 * 24 * 60 * 60 * 1000)));
		m3.setCustomerName("Anshuman Nayak");
		m3.setOrderStatusId(3);
		list.add(m1);
		list.add(m2);
		list.add(m3);*/
		return list;
	}
}
