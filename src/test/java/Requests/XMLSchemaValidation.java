package Requests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;
import static org.hamcrest.Matchers.*;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class XMLSchemaValidation {
	
	
	@Test
	public void schemaValidationAdd() throws IOException {
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
			.body("//*:AddResult.text()", equalTo("5"))
		.and()
			.assertThat().body(matchesXsdInClasspath("calculator.xsd"));
	}

}
