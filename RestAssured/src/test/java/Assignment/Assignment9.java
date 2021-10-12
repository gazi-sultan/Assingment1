package Assignment;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;
public class Assignment9 {

	@Test
	@Given("api for website")
	public void api_for_website() {
		RestAssured.baseURI="http://api.exchangeratesapi.io";
	}

	@Test
	@When("created scenario")
	public void performed_some_operation() {
	
		RestAssured.
		given().
			get("/v1/latest?access_key=7169dac9c0fa2d550590cf3a5ea5cfac").
		then().
			assertThat().
			statusCode(200).
			log().
			all().
			body("base", equalTo("EUR"));
		
		
	}
	@Test
	@Then("validate status code")
	public void validate_status_code() {
		Response res=RestAssured.get("/v1/latest?access_key=7169dac9c0fa2d550590cf3a5ea5cfac");
		System.out.println("Status Line " +res.getStatusLine());
	}
	  

}