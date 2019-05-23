package RailWay.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Account.Account;
import Constant.Constant;
import RailWay.Pages.RegisterPage;
import RailWay.Pages.HomePage;

public class RegisterPage {

	// Locators:
		private final By _txtEmail = By.xpath("//input[@name='email']");
		private final By _txtPwd = By.xpath("//input[@name='password']");
		private final By _txtConfirmPwd = By.xpath("//input[@name='confirmPassword']");
		private final By _txtPID = By.xpath("//input[@name='pid']");
		private final By _btnRegister = By.xpath("//input[@title='Register']");
		private final By _ErrorShow = By.xpath("//h2[i='Mailbox unavailable. The server response was: that smtp username is not allowed to send']");
		private final By _lblRegisterFail = By.xpath("//p[@class='message error']");
		private final By _lblInvaldPwdLength = By.xpath(
				"//li[@class='password']/label[@class='validation-error' and contains(text(),'Invalid password length')]");
		private final By _lblInvaldPidLength = By.xpath(
				"//li[@class='pid-number']/label[@class='validation-error' and contains(text(),'Invalid ID length')]");
			
	// Elements:
		protected WebElement getTxtEmail() {
			return Constant.WEBDRIVER.findElement(_txtEmail);
		}

		protected WebElement getTxtPwd() {
			return Constant.WEBDRIVER.findElement(_txtPwd);
		}

		protected WebElement getTxtConfirmPwd() {
			return Constant.WEBDRIVER.findElement(_txtConfirmPwd);
		}

		protected WebElement getTxtPID() {
			return Constant.WEBDRIVER.findElement(_txtPID);
		}

		protected WebElement getBtnRegister() {
			return Constant.WEBDRIVER.findElement(_btnRegister);
		}
		
		protected WebElement getLblErrorMsg() {
			return Constant.WEBDRIVER.findElement(_ErrorShow);
		}
		
		protected WebElement getLblRegisterFail() {
			return Constant.WEBDRIVER.findElement(_lblRegisterFail);
		}
		
		protected WebElement getLblInvalidPwdLength() {
			return Constant.WEBDRIVER.findElement(_lblInvaldPwdLength);
		}
		
		protected WebElement getLblInvalidIDLength() {
			return Constant.WEBDRIVER.findElement(_lblInvaldPidLength);
		}
		
	// Methods:
		private void RegisterAccount(Account account) {
			this.getTxtEmail().clear();
			this.getTxtEmail().sendKeys(account.getEmail());
			this.getTxtPwd().sendKeys(account.getPassword());
			this.getTxtConfirmPwd().sendKeys(account.getConfirmPwd());
			this.getTxtPID().sendKeys(account.getPID());
			this.getBtnRegister().click();
		}
		
		public RegisterPage RegisterAccountSuccess(Account account) {
			RegisterAccount(account);
			return new RegisterPage();
		}
		
		public RegisterPage RegisterAccountFail(Account account) {
			RegisterAccount(account);
			return new RegisterPage();

		}
		
		public String getRegisterFailMsg() {
			return this.getLblRegisterFail().getText();
		}
		
		public boolean isInvalidPassLengthErrorDisplay() {
			return (this.getLblInvalidPwdLength().isDisplayed()
					&& this.getLblInvalidPwdLength().getText() == "Invalid password length");
		}
		
		public String getErrorMsg() {
			return this.getLblErrorMsg().getText();
		}
		
		public String getInvalidPassLengthErrorMsg() {
			return this.getLblInvalidPwdLength().getText();
		}
		
		public String getInvalidPidLengthErrorMsg() {
			return this.getLblInvalidIDLength().getText();
		}
		
		public HomePage openUrl (String url){
			Constant.WEBDRIVER.get(url);
			return new HomePage();		
		}
}
