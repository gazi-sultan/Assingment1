package Practice;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class Test2_get {
	@Test
	public void test1() {
		given().get("https://reqres.in/api/users?page=2").then().
		statusCode(200).body("data.first_name[1]",equalTo("Lindsay"))
		.body("data.first_name",hasItems("Michael","Lindsay"))
		.log().all();
		
	}

}
