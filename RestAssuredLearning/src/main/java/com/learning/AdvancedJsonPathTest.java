package com.learning;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

public class AdvancedJsonPathTest {

	@Test(priority = 1)
	public void testJsonPathExtraction() {
		
		baseURI = "https://petstore.swagger.io/v2";
		
		String reqBody = "{\n" +
	            "  \"id\": 11223344,\n" +
	            "  \"category\": {\"id\": 5, \"name\": \"Dogs\"},\n" +
	            "  \"name\": \"JsonPath_Dog\",\n" +
	            "  \"photoUrls\": [\"url_one\", \"url_two\"],\n" +
	            "  \"tags\": [{\"id\": 1, \"name\": \"testing\"}],\n" +
	            "  \"status\": \"available\"\n" +
	            "}";
		
		given()
			.header("Content-Type", "application/json")
			.body(reqBody)
			.post("/pet");
		
		System.out.println("--- Fetching Pet via GET ---");
		
		Response res = 
				given()
				.when().get("/pet/11223344");
		
		String extractedName = res.jsonPath().getString("name");
		int categoryId = res.jsonPath().getInt("category.id");
		String firstPhotoUrl = res.jsonPath().getString("photoUrls[0]");
		
		System.out.println("Extracted Name: " + extractedName);
		System.out.println("Extracted ID: " + categoryId);
		System.out.println("Extracted First Photo URL: " + firstPhotoUrl);
		res.prettyPrint();
	}
	
	@Test(priority = 2)
	public void testApiChaining() {
		
		baseURI = "https://petstore.swagger.io/v2";
		System.out.println("\n--- Starting API Chaining Test ---");
		
		String reqBody = "{\n" +
	            "  \"id\": 0,\n" + 
	            "  \"name\": \"Chained_Dog\",\n" +
	            "  \"status\": \"available\"\n" +
	            "}";
		
		Response postRes = 
				given()
					.header("Content-Type", "application/json")
					.body(reqBody)
				.when()
					.post("/pet");
		
		long dynamicPetId = postRes.jsonPath().getLong("id");
		System.out.println("Extracted Dynamic ID: " + dynamicPetId);
		postRes.prettyPrint();
		
		given()
		.when()
			.get("/pet/" + dynamicPetId)
		.then()
			.statusCode(200)
			.body("name", equalTo("Chained_Dog"));
		
		System.out.println("API Chaining successful! GET"
				+ " request verified the dynamic ID.");		
	}
	
}









