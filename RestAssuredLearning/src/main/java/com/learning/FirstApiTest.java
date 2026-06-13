package com.learning;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;

public class FirstApiTest {
    
	public static void main(String[] args) {

		baseURI = "https://petstore.swagger.io/v2";
		
		System.out.println("Sending GET Request and Validating...");
		
		Response res = given()
				.when().get("/pet/88997766")
				.then()
				.statusCode(200)
				.body("name", equalTo("Unique_QA_Dog"))
				.body("status", equalTo("available"))
				.body("id", equalTo(88997766))
				.extract().response();
		
		System.out.println("All assertions passed! Response Body:");
		//System.out.println(res.asPrettyString());
		res.prettyPrint();
    
    }
}