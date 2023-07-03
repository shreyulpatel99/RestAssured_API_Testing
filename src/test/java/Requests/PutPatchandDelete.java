package Requests;

import static io.restassured.RestAssured.*;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;


public class PutPatchandDelete {
	
	
	@Test
	public void testPUT() {
		
		Map<String,Object> map = new HashMap<String,Object>(); 
		
		//to convert the output in the json format we have created the object for JSONObject
		JSONObject request = new JSONObject(map); 
		request.put("name","Shreyul");
		request.put("job","Service");
		System.out.println(request.toJSONString());
		
		baseURI="https://reqres.in/api";
		
		given().
		body(request.toJSONString()). //this is getting the value from above methods 
		when().
		put("/users/2"). //put means to update. We have to pass the end point of the url in this "/users/2"
		then().
		statusCode(200).log().all(); //201 code is to check put
		
	}
	
	
	
	@Test
	public void testPATCH() {
		
		Map<String,Object> map = new HashMap<String,Object>(); 
		
		//to convert the output in the json format we have created the object for JSONObject
		JSONObject request = new JSONObject(map); 
		request.put("name","Shreyul");
		request.put("job","Service");
		System.out.println(request.toJSONString());
		
		baseURI="https://reqres.in";
		
		given().
		body(request.toJSONString()). //this is getting the value from above methods 
		when().
		patch("/api/users/2"). //patch means to update. We have to pass the end point of the url in this "/users/2"
		then().
		statusCode(200).log().all(); //201 code is to check patch
		
	}
	
	
	@Test
	public void testDELETE() {
		
		baseURI="https://reqres.in";
		
		when().
		delete("/api/users/2"). //put means to update. We have to pass the end point of the url in this "/users/2"
		then().
		statusCode(204).log().all(); //204 code is to check delete
		
	}

	

}
