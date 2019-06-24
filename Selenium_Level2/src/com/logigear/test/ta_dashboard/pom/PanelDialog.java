package com.logigear.test.ta_dashboard.pom;

import com.logigear.test.ta_dashboard.data_object.PanelChartDataObject;
import com.logigear.testfw.element.Element;

public class PanelDialog extends GeneralPage {
	protected Element tabDisplaySetting;
	protected Element radChart;
	protected Element radIndicator;
	protected Element radReport;
	protected Element radHeatMap;
	protected Element cbbProfile;
	protected Element txtDisplayName;
	protected Element txtChartTitle;
	protected Element cbbCategoryField;
	protected Element cbbSeriesField;
	protected Element txtIndicatorTitle;
	protected Element btnOK;

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
		this.cbbProfile = new Element(getLocator("cbbProfile").getBy());
		this.txtDisplayName = new Element(getLocator("txtDisplayName").getBy());
		this.txtChartTitle = new Element(getLocator("txtChartTitle").getBy());
		this.cbbCategoryField = new Element(getLocator("cbbCategoryField").getBy());
		this.cbbSeriesField = new Element(getLocator("cbbSeriesField").getBy());
		this.txtIndicatorTitle = new Element(getLocator("txtIndicatorTitle").getBy());
		this.btnOK = new Element(getLocator("btnOK").getBy());
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
	 * @author nhan.tran set field for chart type
	 * @param : PanelChartDataObject
	 */
	public PanelDialog setFieldForChart(PanelChartDataObject data) {
//		protected Element tabDisplaySetting;
//		protected Element radChart;
//		protected Element radIndicator;
//		protected Element radReport;
//		protected Element radHeatMap;
//		protected Element txtDisplayName;
//		protected Element txtChartTitle;
//		protected Element cbbSeriesField;
//		protected Element txtIndicatorTitle;
		if (data.getPanelType() == "" || data.getPanelType().toUpperCase() == "CHART") {
			this.radChart.check();
		} else
			return null;
		if (data.getDataProfile() != "") {
			this.cbbProfile.selectByText(data.getDataProfile());
		}
		if (data.getDisplayName() != "") {
			this.txtDisplayName.enter(data.getDisplayName());
		} else
			IsEmptyrequiredField("Display Name");
		if (data.getChartTitle() != "") {
			this.txtChartTitle.enter(data.getChartTitle());
		}
		
		switch (data.getChartType().toUpperCase()) {
		case "PIE":
			if(data.getSeries()=="")
				IsEmptyrequiredField(data.getSeries());
			data.setCategory("");
			break;
		case "SINGGLE BAR":
			if(data.getSeries()=="")
				IsEmptyrequiredField(data.getSeries());
			data.setCategory("");
			break;
		case "STACKED BAR":
			if(data.getCategory()=="")
				IsEmptyrequiredField(data.getCategory());
			if(data.getSeries()=="")
				IsEmptyrequiredField(data.getSeries());
			break;
		case "GROUP":
			if(data.getCategory()=="")
				IsEmptyrequiredField(data.getCategory());
			if(data.getSeries()=="")
				IsEmptyrequiredField(data.getSeries());
			break;		
		default:
			break;
		}
		setSettingField(data.getCategory(), data.getSeries(), "");
		
		return this;
	}

	protected PageDialog IsEmptyrequiredField(String emptyItem) {
		LOG.info(String.format("The required field: %s is empty", emptyItem));
		return null;
	}

	protected void setSettingField(String category, String series, String staticField) {
		if (category != "") {
			this.cbbCategoryField.selectByText(category);
		}
		if (series != "") {
			this.cbbSeriesField.selectByText(series);
		} 
		if(staticField !="")
		{
			
		}
	}

	/**
	 * @author nhan.tran click OK button
	 */
	public PanelListPage clickOK() {
		this.btnOK.click();
		try {
			
		} catch (Exception error) {
			// TODO: handle exception
		}
		return new PanelListPage();
	}

	public PanelDialog setField() {
		// TODO Auto-generated method stub
		return null;
	}
}