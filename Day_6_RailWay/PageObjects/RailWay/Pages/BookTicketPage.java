package RailWay.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Constant.Constant;
import Ticket.Ticket;

public class BookTicketPage extends GeneralPageRailway{
	

	private String _optionDate = "//select[@name='Date']";
	private String _optionDepart = "//select[@name='DepartStation']";
	private String _optioDestination = "//select[@name='ArriveStation']";
	private String _optionSeat = "//select[@name='SeatType']";
	
	
	private Select optionDate(){ // select support by selenium
		return new Select( waitForElement(By.xpath(_optionDate)));
	}
	
	private Select optionDepart(){ // select support by selenium
		return new Select( waitForElement(By.xpath(_optionDepart)));
	}
	
	private Select optioDestination(){ // select support by selenium
		return new Select( waitForElement(By.xpath(_optioDestination)));
	}
	
	
	private Select optionSeat(){ // select support by selenium
		return new Select( waitForElement(By.xpath(_optionSeat)));
	}
	
	// Method 
	public void bookTicketMultipleTime(Ticket ticket){
		
		for(int  i = 0 ; i < ticket.getTicketAmount(); i++)
		{
			
			System.out.println("Select date");
			optionDate().selectByVisibleText(ticket.getDate());
			
			System.out.println("Select depart");
			optionDepart().selectByVisibleText(ticket.getDepart());
			
			System.out.println("Select destination");
			optioDestination().selectByVisibleText(ticket.getDestination());
			
			System.out.println("Select seat");
			optionSeat().deselectByVisibleText(ticket.getSeat());
			
			
			System.out.println("Select book ticket page");
			this.gotoBookTicketPage();
		}
	}
	
}
