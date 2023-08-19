package com.gorest.base;

import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.gorest.client.RestClient;
import com.gorest.configuration.ConfigurationManager;

public class BaseTest {
	
	public static final String GOREST_ENDPOINT = "/public/v2/users";
	
	protected ConfigurationManager configurationManager;
	protected Properties properties;
	protected RestClient restClient;
	protected String baseURI;
	
	
	//@Parameters({"baseURI"})
	@BeforeTest
	public void setUp() {
		configurationManager = new ConfigurationManager();
		properties = configurationManager.initProperties();
		baseURI = properties.getProperty("baseURI");
		restClient = new RestClient(properties, baseURI);
		//this.baseURI = baseURI;
	}

}
