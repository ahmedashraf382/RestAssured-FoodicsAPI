package com.FoodicsAPI.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
private static final String CONFIG_PATH = System.getProperty("user.dir")+"/src/test/java/com/FoodicsAPI/resources/";
	private static final String CREDENTIALS_CONFIG_PATH = CONFIG_PATH + "credentials.properties";
    protected static Properties credentialsConfig ;


    public static Properties setCredentialsProperties() throws IOException {
    	
        credentialsConfig = new Properties();
        FileInputStream inputStream = new FileInputStream(CREDENTIALS_CONFIG_PATH);
        credentialsConfig.load(inputStream);
        return credentialsConfig;
}
    }
//C:\Users\Ahmed\eclipse-workspace\FoodicsAPI\src\test\java\com\FoodicsAP\resources\credentials.properties (The system cannot find the path specified)

//C:\Users\Ahmed\eclipse-workspace\FoodicsAPI\src\test\java\com\FoodicsAPI\resources\credentials.properties