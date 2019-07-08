package com.logigear.test.ta_dashboard.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;


import com.logigear.test.ta_dashboard.data_object.PanelChartDataObject;
import com.logigear.test.ta_dashboard.data_object.User;
import com.logigear.test.ta_dashboard.pom.HomePage;
import com.logigear.test.ta_dashboard.pom.PanelDialog;
import com.logigear.test.ta_dashboard.pom.PanelListPage;

public class PANEL_Testsuite extends GeneralTest {

	/**
	 * @author Nhan.Tran Verify that no special character except '@' character is
	 *         allowed to be inputed into "Chart Title" field
	 */
	@Test
	public void DA_PANEL_TC035() {
		// Prepare data
		User user = new User("test", "test", "SampleRepository");
		PanelChartDataObject panelInvalid = new PanelChartDataObject("Chart", "", "Logigear", "Chart#$%", "", "", "",
				"  Name", true);
		PanelChartDataObject panelValid = new PanelChartDataObject("Chart", "", "Logigear@", "Chart@", "", "", "",
				"  Name", true);

//		Step	Navigate to Dashboard login page
//		Step	Login with valid account
		HomePage homePage = precondition(user);

//		Step	Click Administer link
//		Step	Click Panel link
//		Step	Click Add New link
		PanelDialog newPanel = homePage.openPanelListPage().clickLinkAddNew();

//		Step	Enter value into Display Name field
//				Enter value into Chart Title field with special characters except "@"
//		Step	Click OK button
		newPanel = newPanel.setFieldForChart(panelInvalid);
		newPanel.clickOKWithInvalid();
		
//		VP	Observe the current page
		String actualAlertStr = newPanel.getAlertText();
		String expectedAlertStr = "Invalid title name. The name cannot contain high ASCII characters or any of the following characters: /:*?<>|\"#[]{}=%;";

//		Step	Close Warning Message box				
		newPanel = newPanel.closeAlert();
//		Step	Click Add New link
//		Step	Enter value into Display Name field
//		Enter value into Chart Title field with special character is @		
		PanelListPage panelPage = newPanel.setFieldForChart(panelValid).clickOK();
		
		//Delete and logout
		panelPage.deleteItem(panelValid.getDisplayName());
		panelPage.logout();
//		VP	Observe the current page
		assertEquals(actualAlertStr, expectedAlertStr, "Alert mesage is not match from TC");
		assertEquals(panelPage.isLoadedPage(), true);
	}

}
