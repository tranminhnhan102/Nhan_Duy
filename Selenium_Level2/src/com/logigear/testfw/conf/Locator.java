package com.logigear.testfw.conf;

import org.openqa.selenium.By;

public class Locator {
	private String type;
	private String value;
	private By by;
	
	public Locator(String type, String value) {
		this.type = type;
		this.value = value;
	}
	
	public String getType() {
		return type;
	}
	
	public String getValue() {
		return value;
	}
		
	public void setBy(By by) {
		this.by = by;
	}
	
//	public void initBy(Object... args) {
//		String tmp = String.format(value, args);
//		by = LocatorLoader.getByLocator(type, tmp);
//	}
	
	public By getBy() {
		return by;
	}
}
