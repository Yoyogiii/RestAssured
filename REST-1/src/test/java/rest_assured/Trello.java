package rest_assured;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import  static io.restassured.RestAssured.*;
import  static org.hamcrest.Matchers.*;
import java.net.http.*;

public class Trello {
	public String URL="https://trello.com";
	public String id;
  //@Test
  public void GetBoards() {
	  Response res = given().queryParam("key","95df5e2656af1326d8a196c2ddf2eefa").
			  queryParam("Token","ATTA6af2c2d8ba05ab84eecd7d31a3e11d21452c8464bdbb85716effb48b3ccccd9b3E9D1FF5 ").
			  header("Content-Type","application/json").get("https://trello.com/b/JlbdAj8h/nobita").then().extract().response();
  }
 @Test
  public void CreateBoards() {
	  
	  Response response = given()
			  .queryParam("name", "Hari")
			  .queryParam("key", "95df5e2656af1326d8a196c2ddf2eefa")
			  .queryParam("token", "ATTA6af2c2d8ba05ab84eecd7d31a3e11d21452c8464bdbb85716effb48b3ccccd9b3E9D1FF5").
			  header("Content-Type","application/json").
			  post("https://api.trello.com/1/boards/").then().extract().response();
			  //asString();
	     JsonPath jp = new JsonPath(response.asString());
		 id = jp.get("id");
		 System.out.println(id);
		
  }
 // @Test
  public void DeleteBoards() {
	  String Old="/b/EVX48S4x/hari";
	  Response response = given()
			  .queryParam("key", "95df5e2656af1326d8a196c2ddf2eefa")
			  .queryParam("token", "ATTA6af2c2d8ba05ab84eecd7d31a3e11d21452c8464bdbb85716effb48b3ccccd9b3E9D1FF5").
			  header("Content-Type","application/json").
			  delete("https://api.trello.com"+Old).then().extract().response();
	  
  }
@Test
  public void UpadateBoards() {
	  Response response = given()
			  .queryParam("name", "Sivakasi")
			  .queryParam("key", "95df5e2656af1326d8a196c2ddf2eefa")
			  .queryParam("token", "ATTA6af2c2d8ba05ab84eecd7d31a3e11d21452c8464bdbb85716effb48b3ccccd9b3E9D1FF5").
			  header("Content-Type","application/json").
			  put("https://api.trello.com/1/boards/"+id).then().extract().response();
	  
  }
	  
  
}
