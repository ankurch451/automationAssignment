package com.strabag.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigHelper {

	private final String fileName = "config.properties";
	Properties prop = new Properties();

	public  ConfigHelper() {
		File file = new File(fileName);
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getApplicationUrl() {
		return prop.getProperty("testUrl");
	}

	public String getUserLogin() {
		return prop.getProperty("userName");
	}

	public String getPassword() {
		return prop.getProperty("password");
	}
	
	public String getInvalidPassword() {
		return prop.getProperty("invalidPassword");
	}
}
