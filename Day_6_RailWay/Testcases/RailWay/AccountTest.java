package RailWay;

import org.testng.Assert;
import org.testng.annotations.Test;

import Account.Account;
import Constant.Constant;
import RailWay.Pages.GeneralPageRailway;
import RailWay.Pages.HomePage;
import RailWay.Pages.RegisterPage;

public class AccountTest extends BaseTest{
	@Test
	public void TC07_CreateNewAccount() {
		System.out.println("User can create new account");

		HomePage homePage = new HomePage();
		
		Account account = new Account();
		account.InitUserData();

		String ErrorMsg = ((GeneralPageRailway) homePage.openUrl(Constant.RAIWAY_URL))
				.gotoRegisterPage()
				.RegisterAccountSuccess(account).getErrorMsg();
		String expectedMsg = "Thank you for registering your account";
		
		Assert.assertEquals(ErrorMsg, expectedMsg, "Register Success message is not displayed as expected");
	}
	
	@Test
	public void TC08_CannotLoginWithAccountHasnotActivated() {
		System.out.println("User can't login with an account hasn't been activated");

		HomePage homePage = new HomePage();
		
		Account account = new Account();
		account.InitUserData();

		String actualMsg = ((GeneralPageRailway) homePage.openUrl(Constant.RAIWAY_URL))
				.gotoRegisterPage()
				.RegisterAccountSuccess(account).openUrl(Constant.RAIWAY_URL)
				.gotoLoginPage()
				.loginError(account.getEmail(), account.getPassword())
				.getLoginErrorMsg();
		String expectedMsg = "Invalid username or password. Please try again.";

		Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");

	}
	
	@Test
	public void TC09_CannotChangePassword() {
		System.out.println("User can't change password when \"New Password\" and \"Confirm Password\" are different.");

		HomePage homePage = new HomePage();
		
		Account account = new Account();
		account.InitUserData();
		
		String actualMsg = ((GeneralPageRailway) homePage.openUrl(Constant.RAIWAY_URL))
				.gotoLoginPage()
				.login(Constant.USERNAME, Constant.PASSWORD)
				.gotoChangePasswordPage()
				.changePasswordFail(account.getPassword(),"a123:\"/{}!@$\\","b456:\"/{}!@$\\")
				.getMsgChangeFail();
		
		String expectedMsg = "User can't change password when \"New Password\" and \"Confirm Password\" are different.";

		Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");

	}
	
	@Test
	public void TC10_CannotCreateAccountAlreadyInUse(){
		System.out.println("User can't create account with an already in-use email");

		HomePage homePage = new HomePage();
		
		Account account = new Account();
		account.InitUserDataWrongEmail();

		String actualMsg = ((GeneralPageRailway) homePage.openUrl(Constant.RAIWAY_URL))
				.gotoRegisterPage()
				.RegisterAccountFail(account)
				.getRegisterFailMsg();
		
		String expectedMsg = "This email address is already in use.";

		Assert.assertEquals(actualMsg, expectedMsg, "Error message is not displayed as expected");
	}
	
	@Test
	public void TC11_CannotCreateAccountWhilePasswordAndPIDEmpty(){
		System.out.println("User can't create account while password and PID fields are empty");

		Account account = new Account();
		account.InitUserDataEmptyPwdAndPid();
		
		RegisterPage registerpage = ((GeneralPageRailway) new HomePage()
				.openUrl(Constant.RAIWAY_URL))
				.gotoRegisterPage()
				.RegisterAccountSuccess(account);
		
		Assert.assertEquals(registerpage.getRegisterFailMsg(), "There're errors in the form. Please correct the errors and try again.", "Error message is not displayed as expected");
		Assert.assertEquals(registerpage.getInvalidPassLengthErrorMsg(), "Invalid password length.", "Error message is not displayed as expected");
		Assert.assertEquals(registerpage.getInvalidPidLengthErrorMsg(), "Invalid ID length.", "Error message is not displayed as expected");
		
	}
	
}
