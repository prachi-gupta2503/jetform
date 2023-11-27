package com.adjecti.jetform.list.model;

import java.util.ArrayList;
import java.util.List;

public class BarPieDoughnutChartDef implements ChartDef {
	private static final long serialVersionUID = 5284610035500501320L;
	private String xSeries;
	private List<String> ySeries = new ArrayList<String>();
	private int xSeriesCount;
	private boolean legend=true; 
	private String legendTemplate;
	
	public String getxSeries() {
		return xSeries;
	}

	public void setxSeries(String xSeries) {
		this.xSeries = xSeries;
	}

	public List<String> getySeries() {
		return ySeries;
	}

	public void setySeries(List<String> ySeries) {
		this.ySeries = ySeries;
	}

	public int getxSeriesCount() {
		return xSeriesCount;
	}

	public void setxSeriesCount(int xSeriesCount) {
		this.xSeriesCount = xSeriesCount;
	}

	public boolean isLegend() {
		return legend;
	}

	public void setLegend(boolean legend) {
		this.legend = legend;
	}

	public String getLegendTemplate() {
		return legendTemplate;
	}

	public void setLegendTemplate(String legendTemplate) {
		this.legendTemplate = legendTemplate;
	}

	public int ySeriesSize() {
		return ySeries.size();
	}

	public boolean isySeriesEmpty() {
		return ySeries.isEmpty();
	}

	public boolean containsySeries(Object o) {
		return ySeries.contains(o);
	}

	public boolean addySeries(String e) {
		return ySeries.add(e);
	}

	public boolean removeySeries(Object o) {
		return ySeries.remove(o);
	}

	public void clearySeries() {
		ySeries.clear();
	}

	public String getySeries(int index) {
		return ySeries.get(index);
	}

	public String removeySeries(int index) {
		return ySeries.remove(index);
	}
	
	
}
