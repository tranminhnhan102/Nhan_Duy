package com.logigear.test.ta_dashboard.pom;

import com.logigear.testfw.element.Element;
import com.logigear.test.ta_dashboard.data_object.GeneralPanel;
import com.logigear.test.ta_dashboard.pom.PanelDialog;
public class PanelListPage extends GeneralPage {

	protected Element lnkAddNew;
	
	public PanelListPage() {
		super(PanelListPage.class);
	}

	@Override
	public void initPageElements() {
		this.lnkAddNew = new Element(getLocator("lnkAddNew").getBy());
	}

	/*
	 * Author: Tien Tran
	 * Method name: clickLinkAddNew()
	 * Purpose/Description: Click "Add New" on Panel List page.
	 * 
	 * */

	public PanelDialog clickLinkAddNew() {
		this.lnkAddNew.click();
		return new PanelDialog();
	}	
}
