package com.adjecti.liferay.chart.config;

import com.adjecti.liferay.chart.constants.ChartViewPortletKeys;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = ChartViewPortletKeys.CONFIGURATION_ID)
public interface ChartConfiguration {

	@Meta.AD(deflt = "bar", 
			name = "chart", 
			optionLabels = { "%Bar", "%Donut", "%Pie" }, 
			optionValues = { "bar", "donut", "pie" }, 
			required = false
		)
	

		public String chart();
		public String labels();
		public String values();
		public String name();

}
