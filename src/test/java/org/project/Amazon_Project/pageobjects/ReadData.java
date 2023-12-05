package org.project.Amazon_Project.pageobjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadData {

	public String GetItemName() throws IOException {
		String path = System.getProperty("user.dir") + "\\resources\\testdata\\testdata.properties";
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(path);
		prop.load(fs);
		String itemName = prop.getProperty("itemName");
		return itemName;
	}
	public String GetItemName2() throws IOException {
		String path = System.getProperty("user.dir") + "\\resources\\testdata\\testdata.properties";
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(path);
		prop.load(fs);
		String itemName = prop.getProperty("itemName2");
		return itemName;
	}
	
	public String GetName() throws IOException {
		String path = System.getProperty("user.dir") + "\\resources\\testdata\\testdata.properties";
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(path);
		prop.load(fs);
		String name = prop.getProperty("name");
		return name;
	}
	
	public String GetEmail() throws IOException {
		String path = System.getProperty("user.dir") + "\\resources\\testdata\\testdata.properties";
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(path);
		prop.load(fs);
		String email = prop.getProperty("email");
		return email;
	}
	
	public String GetPassword() throws IOException {
		String path = System.getProperty("user.dir") + "\\resources\\testdata\\testdata.properties";
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(path);
		prop.load(fs);
		String password = prop.getProperty("password");
		return password;
	}
	

}
