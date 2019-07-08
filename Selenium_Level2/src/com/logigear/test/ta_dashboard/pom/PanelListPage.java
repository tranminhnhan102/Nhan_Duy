package com.logigear.test.ta_dashboard.pom;

import com.logigear.testfw.common.Common;
import com.logigear.testfw.common.TestExecutor;
import com.logigear.testfw.element.Element;
import com.logigear.test.ta_dashboard.pom.PanelDialog;

public class PanelListPage extends GeneralPage {

	protected Element lnkAddNew;
	protected Element lblPanelName;
	protected Element btnDeleteItem;
	public PanelListPage() {
		super(PanelListPage.class);
	}

	@Override
	public void initPageElements() {
		this.lnkAddNew = new Element(getLocator("lnkAddNew").getBy());
		this.lblPanelName = new Element(getLocator("lblPanelName").getBy());
	}

	/*
	 * Author: Tien Tran Method name: clickLinkAddNew() Purpose/Description: Click
	 * "Add New" on Panel List page.
	 * 
	 */

	public PanelDialog clickLinkAddNew() {
		this.lnkAddNew.click();
		return new PanelDialog();
	}

	public PanelListPage waitForLoading(int timeOutInSeconds) {
		lblPanelName.waitForDisplay(timeOutInSeconds);
		LOG.info("Panel page is loaded successfully");
		return this;
	}

	/**
	 * @author minhn
	 * @return
	 */
	public PanelListPage waitForLoading() {
		waitForLoading(Common.ELEMENT_TIMEOUT);
		return this;
	}
	
	public boolean isLoadedPage()
	{
		return lblPanelName.isDisplayed();
	}
	
	public void deleteItem(String displayName) {
		String xpath= String.format("//tr[//td/a[text()='%s']]//a[text()='Delete']", displayName);
		btnDeleteItem = new Element(xpath);
		btnDeleteItem.click();
		TestExecutor.getInstance().getCurrentDriver().acceptAlert();
	}
}
