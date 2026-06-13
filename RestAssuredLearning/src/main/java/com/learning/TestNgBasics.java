package com.learning;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class TestNgBasics {

	@Test
	public void verifyGetPet() {
		
		baseURI = "https://petstore.swagger.io/v2";
		
		System.out.println("Executing TestNG GET Test...");
		
		given()
		.when()
			.get("/pet/88997766")
		.then()
			.statusCode(200)
			.body("name", equalTo("Unique_QA_Dog"));
	}
	
}
