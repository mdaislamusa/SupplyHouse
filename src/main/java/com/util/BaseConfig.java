package com.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class BaseConfig {

	public static String getConfig(String value) throws Throwable {
		String path = "./src/test/resources/search.properties";

		FileInputStream fis = new FileInputStream(path);
		Properties prop = new Properties();
		prop.load(fis);

		return prop.getProperty(value);
	}
}
