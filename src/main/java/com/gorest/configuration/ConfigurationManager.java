package com.gorest.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationManager {

	private Properties properties;
	private FileInputStream fileInputStream;
	
	public Properties initProperties() {
		properties = new Properties();
		try {
			fileInputStream = new FileInputStream("./src/test/resources/config/config.properties");
			properties.load(fileInputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
}
