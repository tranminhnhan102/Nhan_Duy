package General;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constant.Constant;
import Gmail.GmailLogin;
import RailWay.Pages.GeneralPageRailway;


public class GeneralPage {
	
	private int _timeOut = 60 ;
	
	private void wait(int second){	
		try
		{
		    Thread.sleep(second * 1000);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
	}
	
	protected boolean isExist(By locator){
		//check if element exist;
		if(Constant.WEBDRIVER.findElement(locator)==null){
			return false;
		}
		else{
			return true;
		}
	}
	
	protected WebElement waitForElement(By locator){
		while(_timeOut > 0){
			if(waitForElementDisplay(locator))
			{
				return Constant.WEBDRIVER.findElement(locator);
			}
			wait(1);
			_timeOut--;
		}
		return null;
	}
	
	protected boolean waitForElementDisplay(By locator){
		//check if element exist;
		while(_timeOut > 0){
			if(isExist(locator))
			{
				if (Constant.WEBDRIVER.findElement(locator).isDisplayed()){
					return true;
				}
			}
			wait(1);
			_timeOut--;
		}	
		return false;
	}
	
	protected void waitForClickAble(By by) {
		int timeout = 60;
		WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}
	
	protected boolean waitForElementEnable(By locator){
		//check if element exist;
		while(_timeOut > 0){
			if(isExist(locator))
			{
				if (Constant.WEBDRIVER.findElement(locator).isEnabled()){
					break;
				}
			}
			wait(1);
			_timeOut--;
		}	
		return false;
	}
	
	public Object openUrl (String url){
		System.out.println("Open URL:" + url);
		Constant.WEBDRIVER.get(url);
		if(url.equals(Constant.RAIWAY_URL))
			return new GeneralPageRailway();
		else
			return new GmailLogin();
	}
}
