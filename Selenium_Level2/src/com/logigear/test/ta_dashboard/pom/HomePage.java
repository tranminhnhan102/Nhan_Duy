package com.logigear.test.ta_dashboard.pom;

import org.apache.commons.logging.Log;

import com.logigear.testfw.common.Common;
import com.logigear.testfw.element.Element;

public class HomePage extends GeneralPage {

	// Element
	protected Element menuExecutionDashboard;

	public HomePage() {
		super(HomePage.class);
	}

	@Override
	public void initPageElements() {
		super.initPageElements();
		this.menuExecutionDashboard = new Element(getLocator("menuExecutionDashboard").getBy());
	}

	/**
	 * @author nhan.tran
	 * @description wait page loading.
	 * @param timeOutInSeconds
	 * @return
	 */
	public HomePage waitForLoading(int timeOutInSeconds) {
		menuExecutionDashboard.waitForDisplay(timeOutInSeconds);
		LOG.info("Page is loaded successfully");
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public HomePage waitForLoading() {
		waitForLoading(Common.ELEMENT_TIMEOUT);
		return this;
	}
}
