package Requests;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;

public class GET {
	
	
	@Test
	public void test1() {
		
		//Base URL of the request 
		Response response =get("https://reqres.in/api/users?page=2");
		
		//print response in console 
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		
		int statusCode = response.getStatusCode(); 
		Assert.assertEquals(statusCode, 200);
		
		
	}
	
	@Test
	public void test2() {
		 
		//this is the base URI then we can define the get value
		baseURI="https://reqres.in/api";
		//we are using the bdd framework statements here, given and then 
		given().
			get("/users?page=2"). // We have to pass the end point of the url in this "/users?page=2"
			//this will take the URI value first and then add the get value this will make the complete URL
			then(). 
			statusCode(200). 
			body("data[1].id", equalTo(8)). //first value is the path "data[1].id" and 2nd is to check if it is available
			log().all(); //to log the console output
	}

}
