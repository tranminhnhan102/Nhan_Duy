package com.logigear.test.ta_dashboard.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import com.logigear.test.ta_dashboard.data_object.GeneralPanel;
import com.logigear.test.ta_dashboard.data_object.PanelChartDataObject;
import com.logigear.test.ta_dashboard.data_object.User;
import com.logigear.test.ta_dashboard.pom.GeneralPage;
import com.logigear.test.ta_dashboard.pom.HomePage;
import com.logigear.test.ta_dashboard.pom.PanelDialog;
import com.logigear.test.ta_dashboard.pom.PanelListPage;
import com.logigear.testfw.common.BaseTest;
import com.logigear.testfw.driver.BaseDriver;

public class PANEL_Testsuite extends BaseTest{

	/**
	 * @author Nhan.Tran
	 * Verify that no special character except '@' character is allowed to be inputed into "Chart Title" field	
	 * */
	@Test
	public void DA_PANEL_TC035()
	{
		//Prepage data
		User user = new User("test","test","SampleRepository");
		PanelChartDataObject panelInvalid = new PanelChartDataObject("Chart", "", "Logigear", "Chart#$%", "", "", "", "  Name", true);
		PanelChartDataObject panelValid = new PanelChartDataObject("Chart", "", "Logigear@", "Chart@", "", "", "", "name", true);
		
//		Step	Navigate to Dashboard login page
//		Step	Login with valid account
		HomePage homePage = precondition(user);
		
//		Step	Click Administer link
//		Step	Click Panel link
//		Step	Click Add New link
		PanelDialog newPanel = homePage.openPanelListPage().clickLinkAddNew();
//		Step	Enter value into Display Name field
//				Enter value into Chart Title field with special characters except "@"
//		Step	Click Ok button
		newPanel = newPanel.setFieldForChart(panelInvalid);
//		VP	Observe the current page
		String actualAlertStr = newPanel.getAlertText();
		String expectedAlertStr = "Invalid display name. The name can't contain high ASCII characters or any of following characters: /:*?<>|\"#{[]{};";
		assertEquals(actualAlertStr, expectedAlertStr, "");
//		Step	Close Warning Message box
//		Step	Click Add New link
//		Step	Enter value into Display Name field
//			Enter value into Chart Title field with special character is @
//		VP	Observe the current page
	}
	
}
