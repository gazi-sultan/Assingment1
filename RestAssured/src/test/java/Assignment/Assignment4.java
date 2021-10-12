package Assignment;

import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Assignment4 {
	@Test
	@Given("Setting HTTP request")
	public void setting_http_request() {
		RestAssured.baseURI="http://api.exchangeratesapi.io";
	}

	@Test
	@When("creating negative scenario")
	public void creating_negative_scenario() {
		RequestSpecification http_request = RestAssured.given();
		Response response = http_request.request(Method.GET,"d4a60807af1ed1bfabe4670f7ddce6c5");
		response=http_request.get();
		System.out.println(response);
	}

	@Test
	@Then("Print response into the console")
	public void print_response_into_the_console() {
		ValidatableResponse res=given().
		get("http://api.exchangeratesapi.io/v1/latest?access_key=d4a60807af1ed1bfabe4670f7ddce6c5&symbols=USD,AUD,CAD,PLN,MXN&format=1").
	then().
		log().
		all().
		body("base", equalTo("EUR"));
		
		System.out.println("Response body is:" +res);
		System.out.println("Negative response received");

	}
}
