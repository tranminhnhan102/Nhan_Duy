package com.logigear.test.ta_dashboard.pom;

public class HomePage extends GeneralPage {

	public HomePage() {
		super();
		loadLocators(HomePage.class);
	}

	@Override
	public void initPageElements() {
	}

	public HomePage waitForPageDisplay() {
		// TODO
		return this;
	}

}
