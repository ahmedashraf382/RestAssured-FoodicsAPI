package com.FoodicsAPI.tests;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import com.FoodicsAPI.payload.CredentialsPayload;
import com.FoodicsAPI.utilities.ReadProperties;

public class FoodicsAPITest {
	CredentialsPayload credentialspayloadobj;
	
	
@Test 
public void checkValidCredntials() throws IOException {
	RestAssured.baseURI ="https://pay2.foodics.dev/";
	Response response  = (Response) given()
			.contentType("application/json")
			.body(creatCreadentialPayload(ReadProperties.setCredentialsProperties().getProperty("username"),ReadProperties.setCredentialsProperties().getProperty("password") ))
			.when().post("cp_internal/login")
			.then().statusCode(200);
}
@Test
public void checkInvalidCredentials() throws IOException {
	RestAssured.baseURI ="https://pay2.foodics.dev/";
	Response response  = (Response) given()
			.contentType("application/json")
			.body(creatCreadentialPayload(ReadProperties.setCredentialsProperties().getProperty("username"),ReadProperties.setCredentialsProperties().getProperty("password") ))
			.when().post("cp_internal/login")
			.then().statusCode(401);
}
@Test
public void checkCustomerShouldBeWhoAmI() throws IOException {
	RestAssured.baseURI ="https://pay2.foodics.dev/";
	Response response  = (Response) given()
			.contentType("application/json")
			.body(creatCreadentialPayload(ReadProperties.setCredentialsProperties().getProperty("username"),ReadProperties.setCredentialsProperties().getProperty("password") ))
			.when().get("cp_internal/whoami")
			.then().statusCode(401)
			.extract().response();
	 String whoamimessage = response.getBody().jsonPath().getString("whoami");
	 
	Assert.assertEquals(ReadProperties.setCredentialsProperties().getProperty("username"),whoamimessage);
	
}
public String creatCreadentialPayload(String username, String password) {
	credentialspayloadobj = new CredentialsPayload(username, password);
	ObjectMapper objMapper = new ObjectMapper();
    String username_password_json = null ;
    try {
        username_password_json = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(credentialspayloadobj);
    } catch (JsonProcessingException e) {
        e.printStackTrace();
    }
    return username_password_json;
}


}
