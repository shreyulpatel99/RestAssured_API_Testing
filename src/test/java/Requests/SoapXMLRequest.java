package Requests;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

import java.io.FileInputStream;
import java.io.IOException; 

public class SoapXMLRequest {
	
	
	@Test
	public void SoapXMLadd () throws IOException {
		
		FileInputStream f = new FileInputStream("D:\\QA\\SeleniumWorkSpace\\RestAssured_API_Testing\\src\\main\\java\\Resources\\add.xml");
		String add = IOUtils.toString(f,"UTF-8"); //it works as we load the file input stream 
		baseURI = "http://www.dneonline.com"; 
		
		given()
			.contentType("text/xml")
			.accept(ContentType.XML)
			.body(add)
		.when()
			.post("/calculator.asmx")
		.then()
			.statusCode(200)
			.log().all()
		.and()
			.body("//*:AddResult.text()", equalTo("5")); //using xpath to validate the soap console output in the console
		//1. copy the soap xml result from the cosole 
		//2. go to free fromatter and test teh xml xpath 
		//3. use .text() to get the value and user equalTo to match 
	}
	
	@Test
	public void SoapXMLdivide() throws IOException {
		
		FileInputStream f = new FileInputStream("D:\\QA\\SeleniumWorkSpace\\RestAssured_API_Testing\\src\\main\\java\\Resources\\divide.xml");
		String add = IOUtils.toString(f,"UTF-8"); //it works as we load the file input stream 
		baseURI = "http://www.dneonline.com"; 
		
		given()
			.contentType("text/xml")
			.accept(ContentType.XML)
			.body(add)
		.when()
			.post("/calculator.asmx")
		.then()
			.statusCode(200)
			.log().all()
		.and()
			.body("//*:DivideResult.text()", equalTo("2")); 
			

	}
	
	
	@Test
	public void SoapXMLmultiply() throws IOException {
		
		FileInputStream f = new FileInputStream("D:\\QA\\SeleniumWorkSpace\\RestAssured_API_Testing\\src\\main\\java\\Resources\\multiply.xml");
		String add = IOUtils.toString(f,"UTF-8"); //it works as we load the file input stream 
		baseURI = "http://www.dneonline.com"; 
		
		given()
			.contentType("text/xml")
			.accept(ContentType.XML)
			.body(add)
		.when()
			.post("/calculator.asmx")
		.then()
			.statusCode(200)
			.log().all()
		.and()
			.body("//*:MultiplyResult.text()", equalTo("4"));

	}
	
	@Test
	public void SoapXMLsubtract() throws IOException {
		
		FileInputStream f = new FileInputStream("D:\\QA\\SeleniumWorkSpace\\RestAssured_API_Testing\\src\\main\\java\\Resources\\subtract.xml");
		String add = IOUtils.toString(f,"UTF-8"); //it works as we load the file input stream 
		baseURI = "http://www.dneonline.com"; 
		
		given()
			.contentType("text/xml")
			.accept(ContentType.XML)
			.body(add)
		.when()
			.post("/calculator.asmx")
		.then()
			.statusCode(200)
			.log().all()
		.and()
			.body("//*:SubtractResult.text()", equalTo("4"));

	}
	
	
	
}
