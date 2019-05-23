package Ticket;

import Constant.SeatType;
import Constant.locations;

public class Ticket {
	
	private String _departDate;
	private locations _departFrom;
	private locations _arrive;
	private SeatType _seatType;
	private int _ticketAmount;
	
	public Ticket(String date , locations depart, locations arrive, SeatType seat, int amount){
		_departDate = date;
		_departFrom = depart;
		_arrive = arrive;
		_seatType = seat;
		_ticketAmount =  amount ; 
	}
	
	
	public String getDate(){
		return _departDate;	
	}
	
	public String getDepart(){
		return _departFrom.getValue();	
	}
	
	public String getDestination(){
		return _arrive.getValue();	
	}
	
	public String getSeat(){
		return _seatType.getValue();	
	}
	
	public int getTicketAmount(){
		return _ticketAmount;	
	}
}
