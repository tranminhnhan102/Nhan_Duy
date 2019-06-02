package com.logigear.test.ta_dashboard.pom;

import com.logigear.testfw.common.BasePOM;
import com.logigear.testfw.element.Element;

public class HomePage extends BasePOM {
	
	protected Element txtRepoName;
	
	public HomePage()
	{
		super(HomePage.class);
	}
	
	@Override
	public void initPageElements() {
		this.txtRepoName = new Element(getLocator("txtRepoName").getBy());
		
	}
	

	public String getRepoName() {
		System.out.println(txtRepoName.getText());
		return txtRepoName.getText();
	}
	

	public HomePage waitForPageDisplay()
	{
		// TODO
		return this;
	}
	
}
