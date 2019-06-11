package com.logigear.test.ta_dashboard.pom;

import com.logigear.testfw.common.BasePOM;
import com.logigear.testfw.common.Common;
import com.logigear.testfw.element.Element;

public class GeneralPage extends BasePOM {

	// Element
	protected Element lnkMyProfile;
	protected Element tabExecutionDashboard;
	
	public GeneralPage(Class<?> derivedClass) {
		super(derivedClass);
	}

	@Override
	public void initPageElements() {
		this.lnkMyProfile = new Element(getLocator("lnkMyProfile").getBy());
		this.tabExecutionDashboard = new Element(getLocator("tabExecutionDashboard").getBy());
	}

}
