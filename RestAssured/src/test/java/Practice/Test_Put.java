package Practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Test_Put {
	@Test
	public void test1_put() {
		JSONObject response=new JSONObject();
		response.put("Name","Gazi");
		response.put("job","SDET");
		given().header("content-Type","Application/JSON").contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(response.toJSONString()).when().put("http://api.exchangeratesapi.io/v1/latest?access_key=d4a60807af1ed1bfabe4670f7ddce6c5&symbols=USD,AUD,CAD,PLN,MXN&format=1").
		then().statusCode(200).log().all();
		
		
		
	}
	@Test
	public void test_patch() {
		JSONObject response=new JSONObject();
		response.put("name","Gazi");
		response.put("job", "SDET");
		given().header("Content_Type","Application/JSON").contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(response.toJSONString()).when().patch("https://reqres.in/api/users/2")
		.then().statusCode(200).log().all();
		
		
	}
	@Test
	public void test_delete() {
		given().delete("https://reqres.in/api/users/2").then().statusCode(204)
		.log().all();
	}

}
