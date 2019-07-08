package com.logigear.test.ta_dashboard.testcases;

import com.logigear.test.ta_dashboard.data_object.User;
import com.logigear.test.ta_dashboard.pom.HomePage;
import com.logigear.test.ta_dashboard.pom.LoginPage;
import com.logigear.testfw.common.BaseTest;

public class GeneralTest extends BaseTest{
	/**
	 * @author Nhan.Tran
	 * @description: Precondition with user input
	 * @param: user
	 * */
	public HomePage precondition(User user) {
		HomePage homePage = new LoginPage().login(user.getRepository(),user.getUserName(),user.getPassword());
		return homePage;
	}	
}
