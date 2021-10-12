package Practice;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test1_Post {
	@Test
	public void test01_post() {
//		Map<String,Object> map=new HashMap<String,Object>();
//		map.put("Gazi", "7979893089");
//		map.put("Reshma", "6291172991");
		JSONObject obj=new JSONObject();
		obj.put("Gazi1", "7979893089");
		obj.put("Reshma", "6291172991");
		
		
		//System.out.println(obj.toJSONString());
		given().header("Content-Type","Application/JSON")
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(obj.toJSONString()).when().post("https://reqres.in/api/users").then()
		.statusCode(201);
		
	}

}
