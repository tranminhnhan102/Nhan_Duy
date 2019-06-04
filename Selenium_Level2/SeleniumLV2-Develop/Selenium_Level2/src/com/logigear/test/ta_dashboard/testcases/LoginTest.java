package com.logigear.test.ta_dashboard.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.logigear.test.ta_dashboard.pom.HomePage;
import com.logigear.test.ta_dashboard.pom.LoginPage;
import com.logigear.testfw.common.BaseTest;

public class LoginTest extends BaseTest{

	@Test
	public void TC001() {
		System.out.println(
				"TC001 - Verify that user can login specific repository successfully via Dashboard login page with correct credentials");
		
		String USERNAME = "administrator";
		String PASSWORD = "";
		String SAMPLE_REPO = "SampleRepository";
		
		LoginPage loginpage = new LoginPage();
		HomePage homePage = loginpage.login(USERNAME, PASSWORD, SAMPLE_REPO);

		String actualMsg = homePage.getRepoName();
		String expectedMsg = "SampleRepository";
		Assert.assertEquals(actualMsg, expectedMsg, "Can't login with correct credentials");
	}
}
