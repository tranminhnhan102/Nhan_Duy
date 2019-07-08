package com.logigear.test.ta_dashboard.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.logigear.test.ta_dashboard.data_object.User;
import com.logigear.test.ta_dashboard.pom.HomePage;
import com.logigear.test.ta_dashboard.pom.LoginPage;

public class LOGIN_Testsuite extends GeneralTest{

	@Test
	public void TC001() {
		System.out.println(
				"TC001 - Verify that user can login specific repository successfully via Dashboard login page with correct credentials");
		
		User user = new User("administrator", "", "SampleRepository");
		HomePage homePage = new LoginPage().login(user.getRepository(),user.getUserName(),user.getPassword());
//		HomePage homePage = loginpage.login(user);
		boolean actual = homePage.checkMainPageApears();
		boolean expected = true;
		Assert.assertEquals(actual,expected, "Can't login with correct credentials");
	}
}
