package com.logigear.test.ta_dashboard.pom;

import com.logigear.testfw.common.BasePOM;
import com.logigear.testfw.common.Common;
import com.logigear.testfw.element.Element;

public class GeneralPage extends BasePOM {

	// Element
	protected Element txtRepoName;

	public GeneralPage() {
		loadLocators(GeneralPage.class);
	}

	@Override
	public void initPageElements() {
		this.txtRepoName = new Element(getLocator("txtRepoName").getBy());
	}

	public String getRepoName() {
		System.out.println("repo name : " + txtRepoName.getText());
		return txtRepoName.getText();
	}
	
	/**
	 * 
	 * @param timeOutInSeconds
	 * @return
	 */
	public GeneralPage waitForLoading(int timeOutInSeconds) {
		txtRepoName.waitForDisplay(timeOutInSeconds);
		return this;
	}

	/**
	 * 
	 * @return
	 */
	public GeneralPage waitForLoading() 
	{
		waitForLoading(Common.ELEMENT_TIMEOUT);
		return this;
	}

}
