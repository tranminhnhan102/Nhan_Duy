package com.logigear.test.ta_dashboard.pom;

import com.logigear.testfw.common.Common;
import com.logigear.testfw.element.Element;

public class HomePage extends GeneralPage {

	// Element
	protected Element txtBoardByPriority;

	public HomePage() {
		super(HomePage.class);
	}

	@Override
	public void initPageElements() {
		super.initPageElements();
		this.txtBoardByPriority = new Element(getLocator("txtBoardByPriority").getBy());
	}

	/**
	 * 
	 * @param timeOutInSeconds
	 * @return
	 */
	public HomePage waitForLoading(int timeOutInSeconds) {
		txtBoardByPriority.waitForDisplay(timeOutInSeconds);
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
