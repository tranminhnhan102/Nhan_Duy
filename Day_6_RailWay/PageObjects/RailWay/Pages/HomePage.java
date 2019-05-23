package RailWay.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constant.Constant;
import RailWay.Pages.ChangePasswordPage;

public class HomePage extends GeneralPageRailway{
	// Locations
		private final By _tabLogout = By.xpath("//a[@href='/Account/Logout']");
		private final By _tabChangePassword = By.xpath("//a[@href='/Account/ChangePassword.cshtml']");
		
	// Elements
		protected WebElement getTabLogout() {
			WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(_tabLogout));
			return Constant.WEBDRIVER.findElement(_tabLogout);
		}
		
		protected WebElement getTabChangePassword() {
			return Constant.WEBDRIVER.findElement(_tabChangePassword);
		}
		
	// Methods

		
		public boolean isChangePasswordTabDisplay() {
			return this.getTabChangePassword().isDisplayed();
		}
		
		public ChangePasswordPage gotoChangePasswordPage() {
			this.getTabChangePassword().click();
			return new ChangePasswordPage();
		}
}
