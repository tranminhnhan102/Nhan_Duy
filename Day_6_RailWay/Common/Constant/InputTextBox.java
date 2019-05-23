package Constant;

public enum InputTextBox {
	
	//Input textbox
	USERMANE("username"),
	PASSWORD("password"),
	EMAIL("email"),
	CONFIRM_PASSWORD("confirmPassword"),
	PID("pid"),
	CURRENT_PASSWORD("currentPassword"),
	NEW_PASSWORD("newPassword");
		
	private String value;

	InputTextBox(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
		
}
