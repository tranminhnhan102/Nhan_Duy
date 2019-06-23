package com.logigear.test.ta_dashboard.pom;

import com.logigear.test.ta_dashboard.data_object.Page;
import com.logigear.testfw.common.BasePOM;
import com.logigear.testfw.common.Common;
import com.logigear.testfw.common.TestExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.logigear.testfw.common.BasePOM;
import com.logigear.testfw.common.Common;
import com.logigear.testfw.common.TestExecutor;
import com.logigear.testfw.driver.BaseDriver;
import com.logigear.testfw.element.Element;

public class GeneralPage extends BasePOM {

	protected com.logigear.testfw.utilities.Logger logger = new com.logigear.testfw.utilities.Logger();

	// Variable
	private String xpathMainSection = ("//div[@id='container']//li//a[contains(.,'%s')]");
	private String xpathSubSection = ("//div[@id='container']//li/a[contains(.,'%s')]");

	// Element
	protected Element lnkMyProfile;
	protected Element tabExecutionDashboard;
	protected Element lnkGlobalSetting;
	protected Element lnkAddPage;
	protected Element lnkChoosePanels;
	protected Element btnCreateNewPanel;
	protected Element lnkCreatePanel;
	protected Element itemAdminister;
	protected Element lnkPanel;
	protected Element lnkPage;
	public Page page;
	
	
	public GeneralPage(Class<?> derivedClass) {
		super(derivedClass);
	}

	@Override
	public void initPageElements() {
		this.lnkMyProfile = new Element(getLocator("lnkMyProfile").getBy());
		this.tabExecutionDashboard = new Element(getLocator("tabExecutionDashboard").getBy());
		this.lnkGlobalSetting = new Element(getLocator("lnkGlobalSetting").getBy());
		this.lnkAddPage = new Element(getLocator("lnkAddPage").getBy());
		this.lnkChoosePanels = new Element(getLocator("lnkChoosePanels").getBy());
		this.btnCreateNewPanel = new Element(getLocator("btnCreateNewPanel").getBy());
		this.lnkCreatePanel = new Element(getLocator("lnkCreatePanel").getBy());
		this.itemAdminister = new Element(getLocator("itemAdminister").getBy());
		this.lnkPanel = new Element(getLocator("lnkPanel").getBy());
	}
	
	public void setPagename(String abc)
	{
		Element e = new Element(getLocator("lnkPage").getBy(abc));
	}

	/**
	 * Open Add New Page dialog or Edit Page dialog.
	 *
	 * @author hanh.nguyen
	 */
	public PageDialog openPageDialog() {
		logger.printMessage("Open \"New Page\" or \"Edit Page\" dialog.");
		lnkGlobalSetting.click();
		lnkAddPage.click();
		return new PageDialog();
	}

	/**
	 * Open Add New Panel dialog.
	 *
	 * @author hanh.nguyen
	 * @param isFromChoosePanels open the dialog from "Choose Panels" linked button
	 *                           or from "Global Setting" linked button
	 */
	public PanelDialog openPanelDialog(boolean isFromChoosePanels) {
		logger.printMessage("Open \"Add New Panel\" dialog.");
		if (isFromChoosePanels) {
			lnkChoosePanels.click();
			btnCreateNewPanel.click();
		} else if (!isFromChoosePanels) {
			lnkGlobalSetting.click();
			lnkCreatePanel.click();
		}
		return new PanelDialog();

	}

	/**
	 * @author nhan.tran
	 * @Description: Select menu item without <option>tab by hold/click
	 * @param selectedElement Element that should be select.
	 */

	public void selectMenuItem(Element menuElement, Element selectedElement) {
		try {
			menuElement.moveToElement();
			selectedElement.click();
		} catch (Exception error) {
			LOG.severe(String.format("Has error when select item in %d"));
		}
	}
	
	/**
	 * @author hanh.nguyen
	 * @Description: Verify that the page is opened or not
	 * @param pageName	name of the page
	 */
	public boolean isPageOpened(String pageName) {
		String actualTitle = TestExecutor.getInstance().getCurrentDriver().getTitle();
		return actualTitle.contains(pageName);
	}

	 /* @author nhan.tran
	 * @Des: select menu add new page from Global Setting menu
	 * @return: true if open dialog is successfully
	 * */
	
	 public PageDialog selectAddPage()
		{
			selectMenuItem(lnkGlobalSetting, lnkAddPage);
			return new PageDialog();
		}

	/**
	 * @author: duy.nguyen
	 * @Description: Navigate to the page
	 * @param: menuPath The full path can be separated by "/"
	 */

	public void goToPage(String menuPath, int timeOutInSeconds) {
		if (menuPath.contains("/")) {
			String[] path = menuPath.split("/");
			String path1 = path[0];
			String path2 = path[1];
			String xpathMainPath = String.format(xpathMainSection, path1);
			String xpathSubPath = String.format(xpathSubSection, path2);

			Element lnkXpathMainPath = new Element(xpathMainPath);
			Element lnkXpathSubPath = new Element(xpathSubPath);
			try {
				lnkXpathMainPath.waitForDisplay(timeOutInSeconds);
				lnkXpathMainPath.click();
				lnkXpathSubPath.waitForDisplay(timeOutInSeconds);
				lnkXpathSubPath.click();
			} catch (Exception error) {
				throw error;
			}
		} else {
			String xpathMainPath = String.format(xpathMainSection, menuPath);
			Element lnkXpathMainPath = new Element(xpathMainPath);
			
			try {
				lnkXpathMainPath.waitForDisplay(timeOutInSeconds);
				lnkXpathMainPath.click();
			} catch (Exception error) {
				throw error;
			}
		}
	}

	/**
	 * @author: duy.nguyen
	 * @Description: get the currently URL
	 * @param: url (output) URL
	 */

	public String getUrl() {
		String url = TestExecutor.getInstance().getCurrentDriver().getCurrentUrl();
		return url;
	}
	
	/**
	 * @author NhanTran
	 * @description: Get "Test" page is displayed besides "Overview" page
	 * */
	
	public String getTextOfElementAfter(String elementBefore)
	{
		String xpath = String.format("(//ul[./li/a[text()='%s']]/li)[2]", elementBefore);
		Element element = new Element(xpath);
		String result = element.getText();
		return result;
	}
	}
