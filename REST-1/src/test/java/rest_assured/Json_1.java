package rest_assured;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;



import  static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

public class Json_1 {
	public String URL="http://localhost:3000";
	@Test(enabled = false)
	public void Test_1()
	{
		Response Res= get(URL);
		int Status = Res.statusCode();
		Assert.assertEquals(Status, 200);
	}
		
  @Test(enabled = false)
  public void Users() {
	
	// given().get("http://localhost:3000/users").then().statusCode(200).log().all();
	 given().get("http://localhost:3000/users").then().statusCode(200).body("ID[0]",equalTo(7)).log().all();
  }
  @Test
  public void JobROle() {
	
	 given().get("http://localhost:3000/Job_Role").then().statusCode(200).body("Role",hasItem("Automation Tester")).log().all();
  }
  @Test(enabled = false)
	public void Test_2()
	{
		JSONObject Js=new JSONObject();
		Js.put("ID","302");
		Js.put("Role", "Leader");
		given().body(Js.toJSONString()).when().post("http://localhost:3000/Job_Role").then().statusCode(200).log().all();
  
}
}
