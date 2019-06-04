package com.logigear.test.ta_dashboard.pom;

import com.logigear.testfw.common.BasePOM;
import com.logigear.testfw.element.Element;

public class GeneralPage extends BasePOM {

	// Element
	protected Element txtRepoName;

	public GeneralPage(Class<?> derivedClass) {
		super(derivedClass);
	}

	@Override
	public void initPageElements() {
		this.txtRepoName = new Element(getLocator("txtRepoName").getBy());
	}

	public String getRepoName() {
		return txtRepoName.getText();
	}

}
