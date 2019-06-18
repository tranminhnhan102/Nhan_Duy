package com.logigear.test.ta_dashboard.pom;

import com.logigear.test.ta_dashboard.data_object.Page;
import com.logigear.testfw.element.Element;

public class PageDialog extends GeneralPage {
	// Element
	protected Element txtPageName;
	protected Element cboParentPage;
	protected Element cboNumberOfColumns;
	protected Element cboDisplayAfter;
	protected Element chkIsPublic;
	protected Element btnOK;
	protected Element btnCancel;

	public PageDialog() {
		super(PageDialog.class);
	}

	@Override
	public void initPageElements() {
		this.txtPageName = new Element(getLocator("txtPageName").getBy());
		this.cboParentPage = new Element(getLocator("cboParentPage").getBy());
		this.cboNumberOfColumns = new Element(getLocator("cboNumberOfColumns").getBy());
		this.cboDisplayAfter = new Element(getLocator("cboDisplayAfter").getBy());
		this.chkIsPublic = new Element(getLocator("chkIsPublic").getBy());
		this.btnOK = new Element(getLocator("btnOK").getBy());
		this.btnCancel = new Element(getLocator("btnCancel").getBy());
	}

	/**
	 * Enter page form.
	 *
	 * @author hanh.nguyen
	 * @param pageName   the page name
	 * @param parentPage the parent page
	 * @param colNumber  the col number
	 * @param afterPage  the after page
	 * @param isPublic   the is public
	 */
	public PageDialog fillInfoInPageDialog(String pageName, String parentName, String numberOfColumns,
			String displayAfter, boolean isPublic) {
		if (txtPageName.getText() == null || txtPageName.getText() != pageName) {
			logger.printMessage("In \"Page Name\" textbox, enter: " + pageName);
			txtPageName.enter(parentName);
		}
		if (parentName != null && cboParentPage.getText() != parentName) {
			logger.printMessage("In \"Parent Page\" combobox, select: " + parentName);
			cboParentPage.selectByText(parentName);
		}
		if (numberOfColumns != null && cboParentPage.getText() != numberOfColumns) {
			logger.printMessage("In \"Number of Columns\" combobox, select: " + numberOfColumns);
			cboNumberOfColumns.selectByText(numberOfColumns);
		}
		if (displayAfter != null && cboParentPage.getText() != displayAfter) {
			logger.printMessage("In \"Display After\" combobox, select: " + displayAfter);
			cboDisplayAfter.selectByText(displayAfter);
		}
		if (chkIsPublic.isSelected() != isPublic) {
			logger.printMessage("In \"Public\" checkbox, check it: " + isPublic);
			chkIsPublic.check();
		}
		btnOK.click();
		return new PageDialog();
	}

	public PageDialog fillInfoInPageDialog(Page page) {
		fillInfoInPageDialog(page.getPageName(), page.getParentName(), page.getNumberOfColumns(),
				page.getDisplayAfter(), page.isIsPublic());
		return new PageDialog();
	}

	/**
	 * @author nhan.tran
	 * @Des: Check unable to open add page again
	 * @param:
	 * @return true if cannot open dialog false if can open dialog
	 */

	public boolean isOpenAddPageAgains() {
		try {
			selectAddPage();
			return true;
		} catch (Exception error) {
			return false;
		}
	}

	public void setField(Page data) {
		Page page = new Page();
		page.loadDefaultData();
		
		if (!page.getPageName().equals(null))
			txtPageName.setValue(page.getPageName());
		
		if (!page.getParentName().equals(null) && !page.getParentName().equals("Select parent"))
			cboParentPage.selectByText(page.getParentName());
		
		if (!page.getNumberOfColumns().equals(null))
			cboNumberOfColumns.selectByText(page.getNumberOfColumns());
		
		if (!page.getDisplayAfter().equals(null))
			txtPageName.setValue(page.getDisplayAfter());
		
		if (page.isIsPublic())
			chkIsPublic.check();
	}
	
	public HomePage submit()
	{
		btnOK.click();
		return new HomePage();
	}
}
