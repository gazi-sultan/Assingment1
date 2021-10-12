package Assignment;
import org.testng.annotations.Test;


import static org.hamcrest.Matchers.equalTo;
import io.restassured.RestAssured;

import io.restassured.response.Response;

public class Assignment5 {
	@Test
	public void ValidateNegativeResponseCode()
	{
	
	Response r =  RestAssured.given().
				when().
					get("https://api.exchangeratesapi.io/v1/lat").
				then().
					assertThat().
					log().
					all().
					and().
					body("error.code", equalTo("missing_access_key")).
					extract().
					response();
		
		System.out.println("Response is :"+r);
		System.out.println("Negative response received");
		
			
	}
}


