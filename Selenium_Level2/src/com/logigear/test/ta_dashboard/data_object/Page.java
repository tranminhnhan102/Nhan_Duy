package com.logigear.test.ta_dashboard.data_object;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONObject;


public class Page{

	private String _pageName, _parentName, _numberOfColumns, _displayAfter;
	private boolean _isPublic;

	public Page(String pageName, String parentName, String numberOfColumns, String displayAfter, boolean isPublic) {
		this._pageName = pageName;
		this._parentName = parentName;
		this._numberOfColumns = numberOfColumns;
		this._displayAfter = displayAfter;
		this._isPublic = isPublic;
	}

	public String getPageName() {
		return _pageName;
	}

	public void setPageName(String _pageName) {
		this._pageName = _pageName;
	}

	public String getParentName() {
		return _parentName;
	}

	public void setParentName(String _parentName) {
		this._parentName = _parentName;
	}

	public String getNumberOfColumns() {
		return _numberOfColumns;
	}

	public void setNumberOfColumns(String _numberOfColumns) {
		this._numberOfColumns = _numberOfColumns;
	}

	public String getDisplayAfter() {
		return _displayAfter;
	}

	public void setDisplayAfter(String _displayAfter) {
		this._displayAfter = _displayAfter;
	}

	public boolean isIsPublic() {
		return _isPublic;
	}

	public void setIsPublic(boolean _isPublic) {
		this._isPublic = _isPublic;
	}

	/**
	 * @param platform
	 * @param className
	 * @return
	 */
	public static JSONObject getInputData(String dataName) {
		String filePath = new StringBuilder()
					.append(System.getProperty("user.dir")).append(File.separator)
					.append("resources").append(File.separator)
					.append("dataInput").append(File.separator)
					.append(dataName + ".json").toString();
		JSONObject jObject = null;
		try {
			String jsonString = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
			jObject = new JSONObject(jsonString);
		} catch (Exception e) {
			// file not exit or invalid format
			e.printStackTrace();
		}
		return jObject;
	}
}
