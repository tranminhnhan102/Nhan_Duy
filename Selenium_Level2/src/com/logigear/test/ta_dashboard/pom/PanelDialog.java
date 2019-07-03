package com.logigear.test.ta_dashboard.pom;

import com.logigear.test.ta_dashboard.data_object.PanelChartDataObject;
import com.logigear.testfw.common.Common;
import com.logigear.testfw.common.TestExecutor;
import com.logigear.testfw.driver.BaseDriver;
import com.logigear.testfw.element.Element;

public class PanelDialog extends GeneralPage {
	protected Element lblPopupTitle;
	protected Element tabDisplaySettings;
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
	protected Element itemOfSeriesField;
//
//	protected BaseDriver driver = TestExecutor.getInstance().getCurrentDriver();
	public PanelDialog() {
		super(PanelDialog.class);
	}

	@Override
	public void initPageElements() {
		this.lblPopupTitle = new Element(getLocator("lblPopupTitle").getBy());
		this.tabDisplaySettings = new Element(getLocator("tabDisplaySettings").getBy());
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

	/**
	 * @author nhan.tran Set field for chart type
	 * @param : PanelChartDataObject
	 */
	public PanelDialog setFieldForChart(PanelChartDataObject data) {
		if (data.getPanelType().toUpperCase().equals("CHART")) {
			radChart.check();
		} else
			return null;
		if (!data.getDataProfile().equals("")) {
			cbbProfile.selectByText(data.getDataProfile());
		}
		if (!data.getDisplayName().equals("")) {
			txtDisplayName.enter(data.getDisplayName());
		} else
			IsEmptyrequiredField("Display Name");
		if (!data.getChartTitle().equals("")) {
			txtChartTitle.enter(data.getChartTitle());
		}

		switch (data.getChartType().toUpperCase()) {
		case "PIE":
			if (data.getSeries().equals(""))
				IsEmptyrequiredField(data.getSeries());
			data.setCategory("");
			break;
		case "SINGGLE BAR":
			if (data.getSeries().equals(""))
				IsEmptyrequiredField(data.getSeries());
			data.setCategory("");
			break;
		case "STACKED BAR":
			if (data.getCategory().equals(""))
				IsEmptyrequiredField(data.getCategory());
			if (data.getSeries().equals(""))
				IsEmptyrequiredField(data.getSeries());
			break;
		case "GROUP":
			if (data.getCategory().equals(""))
				IsEmptyrequiredField(data.getCategory());
			if (data.getSeries().equals(""))
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
		if (!category.equals("")) {
			this.cbbCategoryField.selectByText(category);
		}
		if (!series.equals("")) {
//			this.cbbSeriesField.selectByText(series);
			cbbSeriesField.selectOptGroupByValue("Action",series);

		}
		if (!staticField.equals("")) {

		}
	}

	/**
	 * @author nhan.tran click OK button
	 */
	public PanelListPage clickOK() {
		this.btnOK.click();
		return new PanelListPage();
	}

	public void clickOKWithInvalid() {
		this.btnOK.click();
	}

	public String getAlertText() {
		String alertText = "";
		BaseDriver driver = TestExecutor.getInstance().getCurrentDriver();
		if (driver.isExistAlert() != null) {
			alertText = driver.getTextAlert();
		}

		return alertText;
	}

	public PanelDialog waitForLoading(int timeOutInSeconds) {
		lblPopupTitle.waitForDisplay(timeOutInSeconds);
		LOG.info("Panel Dialog is loaded successfully");
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public PanelDialog waitForLoading() {
		waitForLoading(Common.ELEMENT_TIMEOUT);
		return this;
	}
}