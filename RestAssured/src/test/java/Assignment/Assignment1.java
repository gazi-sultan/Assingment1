package Assignment;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
public class Assignment1 {
	
	
	@Test
	public void post() {
		JSONObject response=new JSONObject();
		response.put("success","true");
		response.put("timestamp","1633990300");
		response.put("base","EUR");
		response.put("date","2021-10-11");
		given().when().body(response.toJSONString())
		.post("http://api.exchangeratesapi.io/v1/latest?access_key=d4a60807af1ed1bfabe4670f7ddce6c5&symbols=USD,AUD,CAD,PLN,MXN&format=1")
.then().statusCode(200);
	}

}
