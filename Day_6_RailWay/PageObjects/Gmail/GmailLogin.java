package Gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;
import General.GeneralPage;

public class GmailLogin extends GeneralPage{
	
	private final By _txtUsername= By.xpath("//input[@type='email']");
	private final By _btnNextUsername = By.xpath("//div[@id='identifierNext']//span");
	private final By _txtPass =  By.xpath("//input[@type='password']");
	private final By _btnNextPass = By.xpath("//div[@id='passwordNext']//span");
	
//	seltrain2015@gmail.com
//	!logigear123
	private WebElement getTxtUsername() {
		return this.waitForElement(_txtUsername) ; 
	}
	
	private WebElement getTxtPass() {
		return this.waitForElement(_txtPass); 
	}
	
	
	private WebElement getBtnNextUsername() {
		return this.waitForElement(_btnNextUsername); 
	}
	
	private WebElement getBtnNextPassword() {
		return this.waitForElement(_btnNextPass); 
	}
	
	//method
	
	public GmailHome login(String username, String password){
		getTxtUsername().sendKeys(username);
		getBtnNextUsername().click();
		getTxtPass().sendKeys(password);
		getBtnNextPassword().click();
		
		return new GmailHome();
	}
	
}
