package com.logigear.test.ta_dashboard.data_object;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

public class BaseDataObject {

	String tcName ="";
	ArrayList<Object> obj = null;
	public BaseDataObject() {
		// TODO Auto-generated constructor stub
		this.obj = 
	}
	public BaseDataObject parseData(String dataName) {
		String filePath = new StringBuilder()
				.append(System.getProperty("user.dir")).append(File.separator)
				.append("resources").append(File.separator)
				.append("dataInput").append(File.separator)
				.append(dataName + ".json").toString();

		String jsonString = "";
		try {
			jsonString = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BaseDataObject data = new Gson().fromJson(jsonString, BaseDataObject.class);
		return data;
		// Show it.
	}
}
