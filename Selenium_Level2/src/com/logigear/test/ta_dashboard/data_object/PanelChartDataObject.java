package com.logigear.test.ta_dashboard.data_object;

public class PanelChartDataObject extends PanelDataObject{
	
	String chartTitle, chartType, style, category, series;
	boolean showTitle;
	
	public PanelChartDataObject(String panelType, String dataProfile, String displayName, String chartTitle,
			String chartType, String style, String category, String series, boolean showTitle) {
		super(panelType, dataProfile, displayName);
		this.chartTitle = chartTitle;
		this.chartType = chartType;
		this.style = style;
		this.category = category;
		this.series = series;
		this.showTitle = showTitle;
	}

	public String getChartTitle() {
		return chartTitle;
	}

	public void setChartTitle(String chartTitle) {
		this.chartTitle = chartTitle;
	}

	public String getChartType() {
		return chartType;
	}

	public void setChartType(String chartType) {
		this.chartType = chartType;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public boolean isShowTitle() {
		return showTitle;
	}

	public void setShowTitle(boolean showTitle) {
		this.showTitle = showTitle;
	}

}
