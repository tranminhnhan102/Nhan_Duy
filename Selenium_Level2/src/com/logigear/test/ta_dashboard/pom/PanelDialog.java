package com.logigear.test.ta_dashboard.pom;

import com.logigear.test.ta_dashboard.data_object.PanelChartDataObject;
import com.logigear.testfw.element.Element;

public class PanelDialog extends GeneralPage {
	protected Element tabDisplaySetting;
	protected Element radChart;
	protected Element radIndicator;
	protected Element radReport;
	protected Element radHeatMap;
	protected Element txtDisplayName;
	protected Element txtChartTitle;
	protected Element cbbSeriesField;
	protected Element txtIndicatorTitle;

	public PanelDialog() {
		super(PanelDialog.class);
	}

	@Override
	public void initPageElements() {
		this.tabDisplaySetting = new Element(getLocator("tabDisplaySetting").getBy());
		this.radChart = new Element(getLocator("radChart").getBy());
		this.radIndicator = new Element(getLocator("radIndicator").getBy());
		this.radReport = new Element(getLocator("radReport").getBy());
		this.radHeatMap = new Element(getLocator("radHeatMap").getBy());
		this.txtDisplayName = new Element(getLocator("txtDisplayName").getBy());
		this.txtChartTitle = new Element(getLocator("txtChartTitle").getBy());
		this.cbbSeriesField = new Element(getLocator("cbbSeriesField").getBy());
		this.txtIndicatorTitle = new Element(getLocator("txtIndicatorTitle").getBy());
	}

//	/*
//	 * Author: Tien Tran
//	 * Method name: clickRadioButton()
//	 * Purpose/Description: click all radio button on the page
//	 * clickIndicatorRadioButton()
//	 * clickReportRadioButton()
//	 * clickHeatMapRadioButton()
//	 */
//
//	public PanelDialog clickIndicatorRadioButton() {
//		radIndicator.click();
//		return this;
//	}	
//	
//	public PanelDialog clickReportRadioButton() {
//		radReport.click();
//		return this;
//	}
//
//	public PanelDialog clickHeatMapRadioButton() {
//		radHeatMap.click();
//		return this;
//	}

	/**
	 * @author nhan.tran
	 * set field for chart type
	 * @param : PanelChartDataObject
	 * */
	public PanelDialog setFieldForChart(PanelChartDataObject data)
	{
		
		return this;
	}
	
	/**
	 * @author nhan.tran
	 * click OK button
	 * */
	public PanelListPage clickOK() {
		return new PanelListPage();
	}

	public PanelDialog setField() {
		// TODO Auto-generated method stub
		return null;
	}
}