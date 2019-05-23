package RailWay;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Account.Account;
//import Account.Account;
import Common.Utilities;
import Constant.Constant;
import Gmail.GmailLogin;
import RailWay.Pages.GeneralPageRailway;

//import Railway.HomePage;;

public class BaseTest{
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Pre-condition");
		
		System.setProperty("webdriver.chrome.driver", Utilities.getProjectPath() + "\\Executables\\chromedriver.exe");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();

	}
	
	@AfterMethod
	public void afterMethod() {
		//System.out.println("Post-condition");
		
		//Constant.WEBDRIVER.quit();
	}
	
	public Account preconditionCreateNewAccount(){
		//create account
		Account account = new Account();
		// implement account data
		account.InitUserData();
		//register new account
		GeneralPageRailway generalPage = new GeneralPageRailway();
		 ((GeneralPageRailway) generalPage.openUrl(Constant.RAIWAY_URL)).gotoRegisterPage().RegisterAccountSuccess(account);
		 GmailLogin gmail = new GmailLogin ();
		 ((GmailLogin) gmail.openUrl(Constant.GMAIL))
		 						.login(Constant.USERNAME_GMAIL,Constant.PASSWORD_GMAIL)
		 							.searchForEmail(account.getEmail())
		 								.selectVerifyLink();
		 	
		return account;
	}
	
}
