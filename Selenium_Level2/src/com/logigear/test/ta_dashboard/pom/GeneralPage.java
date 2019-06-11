package com.logigear.test.ta_dashboard.pom;

import com.logigear.testfw.common.BasePOM;
import com.logigear.testfw.common.Common;
import com.logigear.testfw.element.Element;

public class GeneralPage extends BasePOM {

	// Element
	protected Element lnkMyProfile;
	public Element tabExecutionDashboad;
	
	public GeneralPage(Class<?> derivedClass) {
		super(derivedClass);
	}

	@Override
	public void initPageElements() {
		this.lnkMyProfile = new Element(getLocator("lnkMyProfile").getBy());
		this.tabExecutionDashboad = new Element(getLocator("tabExecutionDashboad").getBy());
	}
	
	public GeneralPage waitForLoading(int timeOutInSeconds) {
		lnkMyProfile.waitForClickable(timeOutInSeconds);
		return this;
	}

	public GeneralPage waitForLoading() {
		lnkMyProfile.waitForClickable(Common.ELEMENT_TIMEOUT);
		return this;
	}

}
