package in.reqes.qa.apitestcases;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;


 

//given()
//		content type,set cookies, add autho, add param, set headers info etc...
//		
//when()
//		get, post, put, delete,...
//		
//then()
//		validate status code, response body, hearder cookies...package in.reqes.qa.apitestcases;

public class HTTPRequestPostPut {
int id;
	
	@Test(priority=1)
void getUser()
	{
		given()
		
		.when()
			.get("https://reqres.in/api/users/2")
		
		.then()
			.statusCode(200)
			.log().all();
			
		
	}
	
	@Test
	void createUser()
	{
		
		HashMap data = new HashMap();
		data.put("name", "Sushant");
		data.put("job", "TEST AUTOMATION");
		
		id = given()
		 	.contentType("application/json")
		 	.body(data)
		 	
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
	}
		
	@Test(priority=3, dependsOnMethods= {"createUser"})
		void UpdateUser() 
	{
			
	HashMap data = new HashMap();
	data.put("name", "Sushant");
	data.put("job", "SENIOR TEST AUTOMATION");
	
	 given()
	 	.contentType("application/json")
	 	.body(data)
	 	
	.when()
	.put("https://reqres.in/api/users/"+id)
	
	
		.then()
		.statusCode(200)
		.log().all();
		 
	}


}
