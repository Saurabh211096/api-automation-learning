package com.learning;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class NegativeApiTests {

	@Test
	public void testGetNonExistentPet() {
		
		baseURI = "https://petstore.swagger.io/v2";
		System.out.println("--- Executing Negative GET Test ---");
		
		given()
		.when()
			.get("/pet/999999999999")
		.then()
			.statusCode(404)
			.body("type", equalTo("error"))
			.body("message", equalTo("Pet not found"));
		
	}
	@Test
	public void testPostWithEmptyBody() {
		
		baseURI = "https://petstore.swagger.io/v2";
		System.out.println("--- Executing Negative POST Test ---");
		
		given()
			.header("Content-Type", "application/json")
			.body("")
		.when()
			.post("/pet")
		.then()
			.statusCode(405);
		
	}
	@Test
	public void testPostWithBoundaryValueName() {
		
		System.out.println("--- Executing Negative POST Test (Boundary Value) ---");
		
		String massiveName = "A".repeat(1000);
		
		String requestBody = "{\n" +
	            "  \"id\": 888,\n" + 
	            "  \"name\": \"" + massiveName + "\",\n" +
	            "  \"status\": \"available\"\n" +
	            "}";
		
		given()
			.header("Content-Type", "application/json")
			.body(requestBody)
		.when()
			.post("/pet")
		.then()
			.statusCode(200);
	}
	@Test
	public void testPostWithInvalidDataType() {
		
		System.out.println("--- Executing Negative POST Test (Data Type Mismatch) ---");
		
		String reqBody = "{\n" +
	            "  \"id\": \"invalid_id_string\",\n" + 
	            "  \"name\": \"Dog\",\n" +
	            "  \"status\": \"available\"\n" +
	            "}";
		
		given()
			.header("Content-Type", "application/json")
			.body(reqBody)
		.when()
			.post("/pet")
		.then()
			.statusCode(500)
			.body("message", containsString("something bad happened"));
		
	}
	
}













