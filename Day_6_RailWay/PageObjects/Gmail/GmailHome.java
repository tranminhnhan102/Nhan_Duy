package Gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import General.GeneralPage;


public class GmailHome extends GeneralPage {
	
	////div[./span[text()='Your']]/a
	
	String _txtConfirmEmail = "(//tr[.//div[@title='Inbox']]//span[text()='Please confirm your account {0}'])[2]";
	private final By _txtSearchEmail = By.xpath("//input[@class='gb_Cf']");
	private final By _linkConfirm = By.xpath("//div[./span[text()='Your']]/a");
	
	private WebElement getTxtConfirmEmail(String username) {
		//dynamic xpath
		
		String email = _txtConfirmEmail.replace("{0}", username);
		return this.waitForElement(By.xpath(email)); 
	}
	
	private WebElement txtSearchEmail() {
		return this.waitForElement(_txtSearchEmail); 
	}
	
	private WebElement linkConfirm() {
		return this.waitForElement(_linkConfirm); 
	}
	
	
	public GmailHome searchForEmail(String Email){
		//wait for search email stable
		this.waitForClickAble(_txtSearchEmail);
		txtSearchEmail().sendKeys("Please confirm your account " + Email + Keys.ENTER);
		//wait for  email stable
		this.waitForClickAble(By.xpath(_txtConfirmEmail.replace("{0}", Email)));
		getTxtConfirmEmail(Email).click();
		//wait for register link stable
		
		return this;
	}
	
	public GmailHome selectVerifyLink() {
		this.waitForClickAble(_linkConfirm);
		//get url link
		String url = linkConfirm().getAttribute("href");
		//click on link
		this.openUrl(url);
		return this;
	}
}
