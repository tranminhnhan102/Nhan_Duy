package com.logigear.testfw.utilities;

import org.testng.asserts.SoftAssert;

public class SortAssertion {
	
	SoftAssert softAssertion = new SoftAssert();
	
	public void sortAssertEquals (String actual, String expected)
	{
		softAssertion.assertEquals(actual, expected);
	}
	
	public void sortAssertTrue (Boolean condition)
	{
		softAssertion.assertTrue(condition);
	}
}
