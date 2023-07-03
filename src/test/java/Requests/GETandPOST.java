package Requests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class GETandPOST {
	
	
	@Test
	public void testGET() { 
		baseURI="https://reqres.in/api";
		
		given().
		get("/users?page=2"). //we use get to fetch the url that we need data from. We have to pass the end point of the url in this /users?page=2"
		then(). 
		statusCode(200). 
		body("data[4].first_name",equalTo("George")).
		body("data.first_name", hasItems("George","Rachel")); 
		
		
	}
	
	@Test
	public void testPOST() {
		
		Map<String,Object> map = new HashMap<String,Object>(); 
//		
//		map.put("name","Shreyul"); 
//		map.put("job","service");
//		System.out.println(map);
		
		//to convert the output in the json format we have created the object for JSONObject
		JSONObject request = new JSONObject(map); 
		request.put("name","Shreyul");
		request.put("job","service");
		System.out.println(request.toJSONString());
		
		baseURI="https://reqres.in/api";
		
		given().
		body(request.toJSONString()). //this is getting the value from above methods 
		when().
		post("/users"). //post means to crate. We have to pass the end point of the url in this "/users"
		then().
		statusCode(201).log().all(); //201 code is to check if the data is created
		
	}
	
	

}
