package Constant;

public enum Button {
	//Summit button
	LOGIN("login"),
	RESET_PASSWORD("reset password"),
	SEND_INSTRUCTIONS("Send Instructions"),
	REGISTER("register");
		
	private String value;

	Button(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
