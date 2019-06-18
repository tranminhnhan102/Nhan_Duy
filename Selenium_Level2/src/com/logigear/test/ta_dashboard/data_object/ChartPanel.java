package com.logigear.test.ta_dashboard.data_object;

public class ChartPanel extends GeneralPanel{
	private String _chartTitle, _chartType, _category, _categoryCaption, _series, _seriesCaption, _legends, _style;
	private boolean isShowTitle;
	private String[] _dataLabels;
	
	public String getChartTitle() {
		return _chartTitle;
	}
	public void setChartTitle(String chartTitle) {
		this._chartTitle = chartTitle;
	}
	public String getChartType() {
		return _chartType;
	}
	public void setChartType(String _chartType) {
		this._chartType = _chartType;
	}
	public String getCategory() {
		return _category;
	}
	public void setCategory(String _category) {
		this._category = _category;
	}
	public String getCategoryCaption() {
		return _categoryCaption;
	}
	public void setCategoryCaption(String __categoryCaption) {
		this._categoryCaption = __categoryCaption;
	}
	public String getSeries() {
		return _series;
	}
	public void setSeries(String series) {
		this._series = series;
	}
	public String getSeriesCaption() {
		return _seriesCaption;
	}
	public void setSeriesCaption(String _seriesCaption) {
		this._seriesCaption = _seriesCaption;
	}
	public String getLegends() {
		return _legends;
	}
	public void setLegends(String _legends) {
		this._legends = _legends;
	}
	public String getStyle() {
		return _style;
	}
	public void setStyle(String _style) {
		this._style = _style;
	}
	public boolean getIsShowTitle() {
		return isShowTitle;
	}
	public void setShowTitle(boolean isShowTitle) {
		this.isShowTitle = isShowTitle;
	}
	public String[] getDataLabels() {
		return _dataLabels;
	}
	public void setDataLabels(String[] _dataLabels) {
		this._dataLabels = _dataLabels;
	}
	
	public ChartPanel(String panelType, String displayName, String series) {
		this._panelType = panelType;
		this._displayName = displayName;
		this._series = series;
	}
	
}