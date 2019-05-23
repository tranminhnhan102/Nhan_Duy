package RailWay.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;
import RailWay.Pages.ChangePasswordPage;

public class ChangePasswordPage {
	// Locators:
			private final By _titleChangePassword = By.xpath("//h1[@align='center' and text()='Change password']");
			private final By _txtCurrentPassword = By.xpath("//input[@type='password' and @id='currentPassword']");
			private final By _txtNewPassword = By.xpath("//input[@type='password' and @id='newPassword']");
			private final By _txtConfirmNewPassword = By.xpath("//input[@type='password' and @id='confirmPassword']");
			private final By _btnChangePassword = By.xpath("//input[@type='submit' and @value='Change Password']");
			private final By _lblChangePassFailMsg = By.xpath("//label[@class='validation-error']");

		// Elements:
			protected WebElement getTitleChangePassowrd() {
				return Constant.WEBDRIVER.findElement(_titleChangePassword);
			}

			protected WebElement getTxtCurrentPassword() {
				return Constant.WEBDRIVER.findElement(_txtCurrentPassword);
			}

			protected WebElement getTxtNewPassword() {
				return Constant.WEBDRIVER.findElement(_txtNewPassword);
			}

			protected WebElement getTxtConfirmNewPassword() {
				return Constant.WEBDRIVER.findElement(_txtConfirmNewPassword);
			}

			protected WebElement getBtnChangePassword() {
				return Constant.WEBDRIVER.findElement(_btnChangePassword);
			}

			protected WebElement getChangePassFailMessage() {
				return Constant.WEBDRIVER.findElement(_lblChangePassFailMsg);
			}

		// Methods:
			public boolean isChangePassowrdPageDisplay() {
				return (this.getTitleChangePassowrd().isDisplayed() && this.getBtnChangePassword().isDisplayed());
			}

			public void changePassword(String currentpassword, String newpassword, String confirmnewpassword) {
				this.getTxtCurrentPassword().sendKeys(currentpassword);
				this.getTxtNewPassword().sendKeys(newpassword);
				this.getTxtConfirmNewPassword().sendKeys(confirmnewpassword);
				this.getBtnChangePassword().click();
			}
			
			public ChangePasswordPage changePasswordFail(String currentpassword, String newpassword, String confirmnewpassword) {
				changePassword(currentpassword, newpassword, confirmnewpassword);
				return new ChangePasswordPage();
			} 
			
			public String getMsgChangeFail() {
				return this.getChangePassFailMessage().getText();
			}
}
