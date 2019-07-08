package com.logigear.test.ta_dashboard.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.logigear.test.ta_dashboard.data_object.Page;
import com.logigear.test.ta_dashboard.data_object.User;
import com.logigear.test.ta_dashboard.pom.HomePage;
import com.logigear.test.ta_dashboard.pom.PageDialog;

public class MP_Testsuite extends GeneralTest{
	
	/**
	 * @author nhan.tran
	 * */
//	@Test
//	public void DA_MP_TC011()
//	{
//		User user = new User("administrator", "", "SampleRepository");
//		HomePage homePage = precondition(user);
//		PageDialog pageDialog = homePage.selectAddPage();
//		boolean actualResult = pageDialog.isOpenAddPageAgains();
//		assertEquals(actualResult, false,"the second dialog is opened");
//	}
	
	@Test
	public void DA_MP_TC012()
	{
//		Step	Navigate to Dashboard login page
//		Step	Login with valid account
		User user = new User("test","test","SampleRepository");
		HomePage homePage = precondition(user);
		
//		Step	Go to Global Setting -> Add page
		PageDialog pageDialog = homePage.selectAddPage();
		
//		Step	Enter Page Name field
//		Step	Click OK button
		//load data 
		Page page = new Page().loadDefaultData();
		homePage = pageDialog.createNewPage(page);
		
//		VP	Check "Test" page is displayed besides "Overview" page
		String expected = page.getPageName();
		String actual = homePage.getTextOfElementAfter(page.getDisplayAfter());	
		assertEquals(actual, expected);
	}
	
}
