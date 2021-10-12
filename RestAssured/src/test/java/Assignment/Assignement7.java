package Assignment;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Assignement7 {
Response response;
	
	@Test
	@Given("Set http request")
	public void set_http_request() {
	    RestAssured.baseURI="http://api.exchangeratesapi.io/v1/latest?access_key=4fb75ee62f86c0674b3199081e4ab3bd";
	}

	@Test
	@When("create negative scenario")
	public void create_negative_scenario() {
		RequestSpecification http_request = RestAssured.given();
		Response response = http_request.request(Method.GET,"4fb75ee62f86c0674b3199081e4ab3bd");
		response=http_request.get();		
		System.out.println(response);
		
		
	}

	@Test
	@Then("validate assertion")
	public void validate_assertion() {
		Response response = RestAssured.given().get("http://api.exchangeratesapi.io/v1/latest?access_key=4fb75ee62f86c0674b3199081e4ab3bd");
		
		int statuscode = response.getStatusCode();
		System.out.println("Statuscode is " +statuscode);
		String SLine=response.getStatusLine();
		System.out.println(SLine);
		Assert.assertEquals(statuscode, 200);
		Assert.assertEquals(SLine, "HTTP/1.1 200 OK");
		
	}
}
