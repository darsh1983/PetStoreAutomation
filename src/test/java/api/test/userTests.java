package api.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import api.endpoints.UserEndPoints;
import api.payload.Pet;
import io.restassured.response.Response;

public class userTests 

{

	Faker  faker;
	
    Pet p1;
	
    @BeforeClass
    
	void tc1()
	{
		    	
    	faker = new Faker();
        p1 = new Pet();
        p1.setId(faker.idNumber().hashCode());
        p1.setName(faker.name().name());
        p1.setStatus("available");
       	
    	
    	
	}
	
	@Test(priority=1)
	
	
	public void testPostUser()
	{
		Response res1=UserEndPoints.createUser(p1);
		res1.then().log().all();
	}
	
	
	
	@Test(priority=2)
	
	public void testGetUser()
	{
		Response res1=UserEndPoints.getUserEndPoints(this.p1.getId());
		res1.then().log().all();
		
		
		
	}
	
		
}
