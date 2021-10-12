package Assignment;
import org.testng.annotations.Test;

import org.json.simple.JSONObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
public class Assignment6 {
	JSONObject j1 = new JSONObject();
	@Test
	@Given("API for getting response code")
	public void api_for_getting_response_code() {
		
		RestAssured.baseURI="http://api.exchangeratesapi.io/v1/latest?access_key=4fb75ee62f86c0674b3199081e4ab3bd";
	}

	@Test
	@When("posted with future date info")
	public void posted_with_future_date_info() {

		j1.put("total","12");
		j1.put("total_pages", "2");
		j1.put("date", "2021-10-15");
		
		System.out.println(j1);
		
		Response res =RestAssured.post("https://reqres.in/api/users");
		
		System.out.println(res.getBody());
	}
	@Test
	@Then("validate the positive response code")
	public void validate_the_positive_response_code() {
		given().
		 body(j1.toJSONString()).
		when().
		 post("https://reqres.in/api/users").
		then().
		log().all().
		  statusCode(201)
		  ;
		
	}
	
}

