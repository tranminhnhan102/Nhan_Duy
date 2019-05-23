package Constant;

public enum locations {
	
	SAIGON("Sài Gòn"),
	PHANTHIET("Phan Thiết"),
	NHATRANG("Nha Trang"),
	DANANG("Đà Nẵng"),
	HUE("Huế"),
	QUANGNGAI("Quảng Ngãi");	
	
	private String value;
	
	locations(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
