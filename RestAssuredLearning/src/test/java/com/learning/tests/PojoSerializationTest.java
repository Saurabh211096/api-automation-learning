package com.learning.tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.learning.pojo.PetPojo;

public class PojoSerializationTest {

	@Test
	public void testPostWithPojo() {
		
		baseURI = "https://petstore.swagger.io/v2";
		System.out.println("--- Starting POJO Serialization Test ---");
		
		PetPojo myPet = new PetPojo(55443322, "Pojo_Dog", "available");
		
		given()
			.header("Content-Type", "application/json")
			.body(myPet)
		.when()
			.post("/pet")
		.then()
			.statusCode(200)
			.body("name", equalTo("Pojo_Dog"))
			.body("status", equalTo("available"));
		
		System.out.println("POJO Serialization successful!"
				+ " Pet created without typing raw JSON.");
		
	}
	
}
