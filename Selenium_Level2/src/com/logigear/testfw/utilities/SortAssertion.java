package com.logigear.testfw.utilities;

import org.testng.asserts.SoftAssert;

public class SortAssertion {
	
	SoftAssert sortAssertion = new SoftAssert();
	
	public void sortAssertEquals (String actual, String expected)
	{
		sortAssertion.assertEquals(actual, expected);
	}
	
	public void sortAssertTrue (Boolean condition)
	{
		sortAssertion.assertTrue(condition);
	}
}
