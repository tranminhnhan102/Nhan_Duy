package RailWay;

import org.testng.annotations.Test;

import RailWay.Pages.GeneralPageRailway;
import Ticket.Ticket;
import Account.Account;
import Constant.Constant;
import Constant.locations;
import Constant.SeatType;
import Gmail.GmailLogin;
public class BookTicketTest extends BaseTest {
	
	
	//@Test
	public void TC14_User_can_book_many_tickets(){
		
		System.out.println("TC14 User can book many tickets at a time");
		Account account = preconditionCreateNewAccount();
		Ticket ticket = new Ticket("1/23/2019",locations.SAIGON, locations.PHANTHIET,SeatType.SOFTSEAT,1);
		GeneralPageRailway generalPage = new GeneralPageRailway();
		
		((GeneralPageRailway) generalPage.openUrl(Constant.RAIWAY_URL))
					.gotoLoginPage()
						.login(account.getEmail(), account.getPassword())
							.gotoBookTicketPage().bookTicketMultipleTime(ticket);
		
		
	}
	

}
