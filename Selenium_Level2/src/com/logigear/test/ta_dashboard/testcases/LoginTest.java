package com.logigear.test.ta_dashboard.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.logigear.test.ta_dashboard.data_object.User;
import com.logigear.test.ta_dashboard.pom.HomePage;
import com.logigear.test.ta_dashboard.pom.LoginPage;
import com.logigear.testfw.common.BaseTest;

public class LoginTest extends BaseTest{

	@Test
	public void TC001() {
		User user = new User().getDefaultUser();
		LoginPage loginpage = new LoginPage();
		HomePage homePage = loginpage.login(user.getRepository(), user.getUserName(), user.getPassword());
		boolean actual = homePage.checkMainPageApears();
		boolean expected = true;
		Assert.assertEquals(actual,expected, "Can't login with correct credentials");
	}
}
