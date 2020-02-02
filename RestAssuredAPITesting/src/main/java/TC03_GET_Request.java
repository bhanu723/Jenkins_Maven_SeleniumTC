import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC03_GET_Request {

	
	// Test Case is to Validate Status Code and Status Line from weather API
	@Test  
	void googleMapTest(){
		
		//Specify Base URI(Uniform Resource Identifier)
		RestAssured.baseURI = "https://maps.googleapis.com";
		
		//Create Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Create Response Object & pass what kind of Method we send request(GET/POST etc..)
		Response response = httpRequest.request(Method.GET, "/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=upermarket&key=AIzaSyBjGCE3VpLU41gTqSTDmHmJ2HoELb4Jy1s");
		
		//Print response in console for verification
		System.out.println(response.getBody().asString()); //convert Jason response in a String
		
		//Status Code validation: 200 is successful response
		int intStatusCd = response.getStatusCode();
		System.out.println("Status cd: "+intStatusCd);
		Assert.assertEquals(200, intStatusCd);
		
		//Reading Headers from the response
		String contentType = response.header("Content-Type");
		System.out.println(contentType);
		Assert.assertEquals("applicatoin/xml;charset=UTF-8", contentType);
		
		//How to get all headers
		Headers allHeaders =  response.getHeaders();
		
		for(Header header:allHeaders)
		{
			System.out.println(header.getName()+" : "+header.getValue());
		}
		
			
		
		
	}
}
