package com.logigear.test.ta_dashboard.testcases;

import org.testng.annotations.Test;

import com.logigear.test.ta_dashboard.data_object.User;
import com.logigear.test.ta_dashboard.pom.HomePage;
import com.logigear.test.ta_dashboard.pom.LoginPage;
import com.logigear.testfw.common.BaseTest;
import com.logigear.testfw.utilities.SortAssertion;

public class LoginTest_TC_006 extends BaseTest {
	
	protected com.logigear.testfw.utilities.Logger logger = new com.logigear.testfw.utilities.Logger();
	SortAssertion sortassertion = new SortAssertion();
	
	@Test
	public void TC006() {
		logger.printMessage("DA_LOGIN_TC006: Verify that \"Password\" input is case sensitive.");
		User user = new User("test", "TEST", "SampleRepository");
		LoginPage loginpage = new LoginPage();
		HomePage homepage = loginpage.login(user.getUserName(), user.getPassword(), user.getRepository());
		
		String observedUrl = homepage.getUrl();
		String expectedUrl = "http://localhost/TADashboard/2f9njff6y9.page";
		
		sortassertion.sortAssertEquals(observedUrl, expectedUrl);
		
		
	}
}
