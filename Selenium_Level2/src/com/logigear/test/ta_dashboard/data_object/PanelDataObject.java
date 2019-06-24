package com.logigear.test.ta_dashboard.data_object;

public class PanelDataObject extends BaseDataObject{
	String panelType, dataProfile, displayName;
	public PanelDataObject(String panelType, String dataProfile, String displayName) {
		super();
		this.panelType = panelType;
		this.dataProfile = dataProfile;
		this.displayName = displayName;
	}

	public String getPanelType() {
		return panelType;
	}

	public void setPanelType(String panelType) {
		this.panelType = panelType;
	}

	public String getDataProfile() {
		return dataProfile;
	}

	public void setDataProfile(String dataProfile) {
		this.dataProfile = dataProfile;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
}
