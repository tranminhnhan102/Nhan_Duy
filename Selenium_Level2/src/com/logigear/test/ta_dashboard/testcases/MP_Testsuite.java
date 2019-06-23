package com.logigear.test.ta_dashboard.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.logigear.test.ta_dashboard.data_object.Page;
import com.logigear.test.ta_dashboard.pom.HomePage;
import com.logigear.test.ta_dashboard.pom.PageDialog;
import com.logigear.testfw.common.BaseTest;

public class MP_Testsuite extends BaseTest{
	
	/**
	 * @author nhan.tran
	 * */
	@Test
	public void DA_MP_TC011()
	{
		HomePage homePage = precondition();
		PageDialog pageDialog = homePage.selectAddPage();
		boolean actualResult = pageDialog.isOpenAddPageAgains();
		assertEquals(actualResult, false,"the second dialog is opened");
	}
	
	/**
	 * @author Nhan.Tran
	 * */
	@Test
	public void DA_MP_TC012()
	{
//		Step	Navigate to Dashboard login page
//		Step	Login with valid account
		HomePage homePage = precondition();
		
//		Step	Go to Global Setting -> Add page
		PageDialog pageDialog = homePage.selectAddPage();
		
//		Step	Enter Page Name field
//		Step	Click OK button
		Page page = new Page().loadDefaultData();
		homePage = pageDialog.createNewPage(page);
		
//		VP	Check "Test" page is displayed besides "Overview" page
		String expected = page.getPageName();
		String actual = homePage.getTextOfElementAfter(page.getDisplayAfter());	
		assertEquals(actual, expected);
	}
}
