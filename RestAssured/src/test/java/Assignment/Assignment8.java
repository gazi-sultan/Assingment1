package Assignment;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class Assignment8 {

	@Test(dataProvider="dataPro")
	  public void PostData(String fname, String Lname, int id, String email) {
		  
		  JSONObject jsonobj=new JSONObject();
		  
		  jsonobj.put("first_name", fname);
		  jsonobj.put("last_name", Lname);
		  jsonobj.put("S_id", id);
		  jsonobj.put("Email", email);
		  
		  System.out.println(jsonobj);
		  
		  given().
		  contentType(ContentType.JSON).
		  accept(ContentType.JSON).
		  header("Content-Type","application/json").
		  body(jsonobj.toString()).
		  when(). 
		  post("https://reqres.in/api/users"). 
		  then(). 
		  statusCode(201).
		  log().
		  all();
		  
		  
	  }
	  
	  @DataProvider(name="dataPro")
	  public Object[][] dataPro()
	  {
		  Object[][] data1=new Object[2][4];
		  data1[0][0]="Gazi";
		  data1[0][1]="Ahmed";
		  data1[0][2]=26;
		  data1[0][3]="g_ahmed@gmail.com";
		  data1[1][0]="Arjun";
		  data1[1][1]="Chakraborty";
		  data1[1][2]=26;
		  data1[1][3]="chakac001@gmail.com";
		  
		  
		return data1;
		  
	  }

}
