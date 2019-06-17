package com.logigear.test.ta_dashboard.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

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
	
	
}
