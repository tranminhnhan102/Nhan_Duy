package RailWay.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constant.Constant;
import General.GeneralPage;

public class GeneralPageRailway extends GeneralPage {

	// Location
		private final By _tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
		private final By _tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
		private final By _lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
		private final By _tabBookTicket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");
		private final By _tabContact = By.xpath("//a[@href='/Page/Contact.cshtml']");
		private final By _tabRegister = By.xpath("//a[@href='/Account/Register.cshtml']");
		
		private int _timeOut = 60 ;
		
	//Elements
		protected WebElement getTabLogin() {
			return Constant.WEBDRIVER.findElement(_tabLogin);
		}
		
		protected WebElement getTabLogout() {
			WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(_tabLogout));
			return Constant.WEBDRIVER.findElement(_tabLogout);
		}
		
		protected WebElement getLblWelcomeMessage() {
			return Constant.WEBDRIVER.findElement(_lblWelcomeMessage);
		}
		
		protected WebElement getTabBookTicket() {
			return Constant.WEBDRIVER.findElement(_tabBookTicket);
		}
		
		protected WebElement getTabContact() {
			return Constant.WEBDRIVER.findElement(_tabContact);
		}
		
		protected WebElement getTabRegister() {
			return Constant.WEBDRIVER.findElement(_tabRegister);
		}
		
	//Methods
		
		
		public String getWelcomeMessage() {
			return this.getLblWelcomeMessage().getText();
		}
		
		public LoginPage gotoLoginPage() {
			System.out.println("Select login page tab");
			this.getTabLogin().click();
			return new LoginPage();
		}
		
		public boolean isLogoutDisplay(){
			return getTabLogout().isDisplayed();
		}
		
		public HomePage Logout(){
			this.getTabLogout().click();
			return new HomePage();
		}
		
		public LoginPage gotoBookTicketWithoutLogin() {
			this.getTabBookTicket().click();
			return new LoginPage();
		}
		
		public BookTicketPage gotoBookTicketPage() {
			this.getTabBookTicket().click();
			return new BookTicketPage();
		}
		
		public ContactPage gotoContactPage(){
			this.getTabContact().click();
			return new ContactPage();
		}
		
		public RegisterPage gotoRegisterPage() {
			this.getTabRegister().click();
			return new RegisterPage();
		}
		
}
