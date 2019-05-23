package RailWay;


import org.testng.Assert;
import org.testng.annotations.Test;

import Constant.Constant;
import RailWay.Pages.GeneralPageRailway;
import RailWay.Pages.HomePage;

public class LoginTest extends BaseTest{
	
	@Test
	public void TC01_LoginSucess() {
		
		System.out.println("TC01 - User can log into Railway with valid username and password");
		HomePage homPage = new HomePage();
		
		String actualMsg = ((GeneralPageRailway) homPage.openUrl(Constant.RAIWAY_URL))
				.gotoLoginPage()
				.login(Constant.USERNAME, Constant.PASSWORD)
				.getWelcomeMessage();
		String expectedMsg = "Welcome " + Constant.USERNAME;
		
		Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
		
	}
	
	@Test
	public void TC02_LoginFailedWithBlankUsername() {
		System.out.println("User can't login with blank 'Username' textbox");

		HomePage homePage = new HomePage();
		
		String actualMsg = ((GeneralPageRailway) homePage.openUrl(Constant.RAIWAY_URL))
				.gotoLoginPage()
				.loginError("", Constant.PASSWORD)
				.getLoginErrorMsg();
		String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

		Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
	}
	
	@Test
	public void TC03_LoginFailedWithInvaildPassword() {
		System.out.println("User cannot log into Railway with invalid password ");

		HomePage homePage = new HomePage();
		
		String actualMsg = ((GeneralPageRailway) homePage.openUrl(Constant.RAIWAY_URL))
				.gotoLoginPage()
				.loginError(Constant.USERNAME, "123456")
				.getLoginErrorMsg();
		String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

		Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
	}
	
	@Test
	public void TC04_RedirectedBookTicketAfterLogin() {
		System.out.println("User is redirected to Book ticket page after logging in");

		HomePage homePage = new HomePage();
		
		boolean actualMsg = ((GeneralPageRailway) homePage
							.openUrl(Constant.RAIWAY_URL))
							.gotoBookTicketWithoutLogin()
							.isLoginPageExist();

		Assert.assertTrue(actualMsg, "Login page is not returned as expected.");
		
		String actualMsg1 = ((GeneralPageRailway) homePage
							.openUrl(Constant.RAIWAY_URL))
							.gotoLoginPage()
							.login(Constant.USERNAME, Constant.PASSWORD)
							.getWelcomeMessage();
		String expectedMsg = "Welcome " + Constant.USERNAME;
		
		Assert.assertEquals(actualMsg1, expectedMsg, "Welcome message is not displayed as expected");
		
	}
	
	@Test
	public void TC05_ErrorMessageShowAfterEnterWrongPasswordSeveralTime() {
		System.out.println("System shows message when user enters wrong password several times");

		HomePage homePage = new HomePage();
		
		String actualMsg = ((GeneralPageRailway) homePage
							.openUrl(Constant.RAIWAY_URL))
							.gotoLoginPage()
							.loginSeveralTimes(Constant.USERNAME, "",5)
							.getLoginErrorMsg();
		String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";

		Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
	}
	
	@Test
	public void TC06_RedirectedToHomePageAfterLogout() {
		System.out.println("User is redirected to Home page after logging out");

		HomePage homePage = ((GeneralPageRailway) new HomePage()
								.openUrl(Constant.RAIWAY_URL))
								.gotoLoginPage()
								.login(Constant.USERNAME, Constant.PASSWORD)
								.gotoContactPage()
								.Logout();
		
		boolean isLogoutDisplay = homePage
								.isLogoutDisplay();
		
		Assert.assertFalse(isLogoutDisplay, "Logout is not disappeared as expected.");
		
	}
}
