package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.Pet;
import io.restassured.response.Response;


public class UserEndPoints {
	
	
	static ResourceBundle getURL()
	{
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		
		return routes;
	}
	
	public static Response createUser(Pet payload)
	{
	    String post_url = getURL().getString("post_url");
	 	Response res = given().contentType("application/json")
		.body(payload)
		.when()
		.post(post_url);
	
		return res;
		
		
	}	
	
	public static Response getUserEndPoints(int petId){
		
		 String get_url = getURL().getString("get_url");
		
		Response res = given().contentType("application/json")
			
			.pathParam("petId",petId)	
			
			.when()
			
			.get(get_url);
				
		return res;	
		
	}
	
}
