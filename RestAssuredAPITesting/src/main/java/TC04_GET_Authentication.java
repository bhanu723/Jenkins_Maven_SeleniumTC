import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC04_GET_Authentication {

	@Test
	public void authenticationTest() {

		// Specify Base URI(Uniform Resource Identifier)
		RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";

		//Basic Authentication
		PreemptiveBasicAuthScheme authscheme = new PreemptiveBasicAuthScheme();
		authscheme.setUserName("ToolsQA");
		authscheme.setPassword("TestPassword");
		RestAssured.authentication = authscheme;
		
		// Create Request Object
		RequestSpecification httpRequest = RestAssured.given();

		// Create Response Object & pass what kind of Method we send
		// request(GET/POST etc..)
		Response response = httpRequest.request(Method.GET, "/");
		

		// Status Code validation: 200 is successful response
		int intStatusCd = response.getStatusCode();
		System.out.println("Status cd: " + intStatusCd);
		Assert.assertEquals(200, intStatusCd);

		// Print response in console for verification
		System.out.println(response.getBody().asString());

	}
}
