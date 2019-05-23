package Constant;

public enum MenuTab {
	
	//Tab of menu
	HOME("Home"),
	FAQ("FAQ"),
	CONTACT("Contact"),
	TIMETABLE("Timetable"),
	TICKET_PRICE("Ticket price"),
	BOOK_TICKET("Book ticket"),
	REGISTER("Register"),
	LOGIN("Login"),
	LOGOUT("Logout"),
	CHANGE_PASSWORD("Change password");
	
	private String value;

	MenuTab(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
