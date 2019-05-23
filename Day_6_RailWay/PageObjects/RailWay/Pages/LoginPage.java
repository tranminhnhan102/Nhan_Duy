package RailWay.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;
import RailWay.Pages.HomePage;
import RailWay.Pages.LoginPage;

public class LoginPage extends GeneralPageRailway{
	// Locations
	
		private final By _txtUsername = By.xpath("//input[@id='username']");
		private final By _txtPassword = By.xpath("//input[@id='password']");
		private final By _btnLogin = By.xpath("//input[@value='login']");
		private final By _lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
		
		//Elements
		public WebElement getTxtUsername() {
			return Constant.WEBDRIVER.findElement(_txtUsername);
		}
		
		public WebElement getTxtPassword() {
			return Constant.WEBDRIVER.findElement(_txtPassword);
		}
		
		public WebElement getBtnLogin() {
			return Constant.WEBDRIVER.findElement(_btnLogin);
		}
		
		public WebElement getLblLoginErrorMsg() {
			return Constant.WEBDRIVER.findElement(_lblLoginErrorMsg);
		}
		
		
		//Methods
		public HomePage login(String username, String password) {
			
			System.out.println("Login by username: "+ username + " and password: " + password );
			this.getTxtUsername().sendKeys(username);
			this.getTxtPassword().sendKeys(password);
			this.getBtnLogin().click();
			
			return new HomePage();
		}
		
		public HomePage loginValid(String username, String password) {
			this.login(username, password);
			return new HomePage();
		}
		
		public LoginPage loginError(String username, String password) {
			this.login(username, password);
			return new LoginPage();
		}
		
		public String getLoginErrorMsg() {
			return this.getLblLoginErrorMsg().getText();
		}
		
		public boolean isLoginPageExist() {
			return (this.getBtnLogin().isDisplayed() && this.getTxtUsername().isDisplayed());
		}
		
		public LoginPage loginSeveralTimes(String username, String password, int time) {
			for (int n = 1; n<=time;n++) {
				this.getTxtUsername().sendKeys(username);
				this.getTxtPassword().sendKeys(password);
				this.getBtnLogin().click();
				this.getTxtUsername().clear();
				this.getTxtPassword().clear();
			}
			
			return new LoginPage();
		}
		
}
