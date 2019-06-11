package com.logigear.test.ta_dashboard.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.logigear.test.ta_dashboard.pom.GeneralPage;
import com.logigear.test.ta_dashboard.pom.HomePage;
import com.logigear.test.ta_dashboard.pom.LoginPage;
import com.logigear.testfw.common.BaseTest;
import com.logigear.testfw.element.Element;

public class LOGIN_Testsuite extends BaseTest{

	@Test
	public void TC001() {
		System.out.println(
				"TC001 - Verify that user can login specific repository successfully via Dashboard login page with correct credentials");
		
		String USERNAME = "administrator";
		String PASSWORD = "";
		String SAMPLE_REPO = "SampleRepository";
		
		LoginPage loginpage = new LoginPage();
		GeneralPage generalPage = loginpage.login(USERNAME, PASSWORD, SAMPLE_REPO);
		
		String checkTab;
		try {
			checkTab = generalPage.tabExecutionDashboad.getClass().toString();
		} catch (Exception e) {
			checkTab = "";
		}
		
		System.out.print(checkTab);
		String expectedTab = "active";
		Assert.assertEquals(checkTab, expectedTab, "Can't login with correct credentials");
	}
}
