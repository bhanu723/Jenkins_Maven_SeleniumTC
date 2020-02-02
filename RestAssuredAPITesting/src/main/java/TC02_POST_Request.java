import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC02_POST_Request {

	@Test
	public void registrationTest() {
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";

		RequestSpecification httpRequest = RestAssured.given();

		// Request Payload ( body ) sending along with POST Request
		JSONObject requestParam = new JSONObject();
		requestParam.put("FirstName", "JohnXYZ111");
		requestParam.put("LastName", "XYZJohn1111");
		requestParam.put("UserName", "JohnXYZ111");
		requestParam.put("Password", "JohnXYxyz111");
		requestParam.put("Email", "JohnXYZ111@gmail.com");

		// Specify which kind of request (JSON/XML)
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParam.toJSONString());

		// Create Response Object & pass what kind of Method we send
		// request(GET/POST etc..)
		Response response = httpRequest.request(Method.POST, "/register");

		// Print response in console for verification by converting it to string
		System.out.println(response.getBody().asString()); 

		// Status Code validation: 200 is successful response
		int intStatusCd = response.getStatusCode();
		System.out.println("Status cd: " + intStatusCd);
		Assert.assertEquals(201, intStatusCd);

		//Success code validation
		String successCd = response.jsonPath().get("SuccessCode");
		Assert.assertEquals("OPERATION_SUCCESS", successCd);

	}
}
