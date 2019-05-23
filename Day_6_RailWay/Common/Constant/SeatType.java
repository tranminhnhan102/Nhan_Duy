package Constant;

public enum SeatType {

		//Input textbox
		HARDSEAT("Hard seat"),
		SOFTSEAT("Soft seat"),
		HARDBED("Hard bed"),
		SOFTSEAT_AIR("Soft seat with air conditioner"),
		SOFTBED("Soft bed"),
		SOFTBED_AIR("Soft bed with air conditioner");
			
		private String value;

		SeatType(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
			
}
