package rest_assured;




import org.testng.annotations.Test;

import  static io.restassured.RestAssured.*;
import  static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;


public class Rest_1 {
//	public String URL="https://reqres.in/api/users?page=2";
//	
//
//	@Test(enabled = false)
//	public void Test_1()
//	{
//		Response Res= get(URL);
//		int Status = Res.statusCode();
//		Assert.assertEquals(Status, 200);
//		System.out.println(Res.statusCode());
//		System.out.println(Res.asString());
//		System.out.println(Res.getBody());
//	}
	@Test(enabled = true)
	public void Test_2()
	{
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.id[0]",equalTo(7)).log().all();
		
	}
	@Test(enabled = false)
	public void Test_3()
	{
		JSONObject Js=new JSONObject();
		Js.put("name","Yogee");
		Js.put("job", "Team Leader");
		given().body(Js.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(200).log().all();
	}
	@Test(enabled = false)
	public void Test_4()
	{
		JSONObject Js=new JSONObject();
		Js.put("name","Yogee");
		Js.put("job", "Leader");
		given().body(Js.toJSONString()).when().put("https://reqres.in/api/users/2").then().statusCode(200).log().all();
		
	}
	@Test(enabled = false)
	public void Test_5()
	{
		JSONObject Js=new JSONObject();
		given().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();
		
	}
}

