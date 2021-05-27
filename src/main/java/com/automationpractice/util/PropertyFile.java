package com.automationpractice.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {

	Properties properties = new Properties();

	public String PropertyFileReader(String dataKey) {
		try {
			properties.load(new FileInputStream("src\\test\\resources\\config.properties"));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Properties file is not loaded");
		}

		String dataValue = properties.getProperty(dataKey);
		return dataValue;
	}

}
