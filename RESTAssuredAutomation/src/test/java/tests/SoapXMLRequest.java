package tests;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class SoapXMLRequest {
	@Test
	public void validateSoapXML() throws IOException {
		
		File file=new File("./SoapRequest/Add.xml");
		
		FileInputStream fileinputstream=new   FileInputStream(file);
		String requestBody  = IOUtils.toString(fileinputstream, "UTF-8");
		
		RestAssured.baseURI ="http://www.dneonline.com";
		given()
		.contentType("text/xml")
		.accept(ContentType.XML)
		.body(requestBody)
		.when()
		.post("/calculator.asmx")
		.then()
		.statusCode(500)
		.log().all();
		
	}

}
