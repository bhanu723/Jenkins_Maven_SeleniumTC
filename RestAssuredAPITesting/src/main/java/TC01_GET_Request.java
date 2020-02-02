import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC01_GET_Request {

	// Test Case is to Validate Status Code and Status Line from weather API
	@Test
	void getWeatherDetailsTest() {

		// Specify Base URI(Uniform Resource Identifier)
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// Create Request Object
		RequestSpecification httpRequest = RestAssured.given();

		// Create Response Object & pass what kind of Method we send
		// request(GET/POST etc..)
		Response response = httpRequest.request(Method.GET, "/Coimbatore");

		// Print response in console for verification
		System.out.println(response.getBody().asString()); // convert Jason
															// response in a
															// String

		// Status Code validation: 200 is successful response
		int intStatusCd = response.getStatusCode();
		System.out.println("Status cd: " + intStatusCd);
		Assert.assertEquals(200, intStatusCd);

		// Status Line validation
		String strStatusln = response.statusLine();
		System.out.println("Status Line : " + strStatusln);
		Assert.assertEquals("HTTP/1.1 200 OK", strStatusln);

		
		//Get all Headers
		Headers allHeaders = response.getHeaders();

		for (Header header : allHeaders) {
			System.out.println(header.getName() + " : " + header.getValue());
		}
		
		//Validate whether weather report is from Coimbatore
		 Assert.assertTrue(response.jsonPath().get("City").equals("Coimbatore"));
		 
		 //Validate all json object key & values are correct
		 
		 JsonPath jsonpath = response.jsonPath();
		 Assert.assertTrue(jsonpath.get("City").equals("Coimbatore"));
		 
	}
}
