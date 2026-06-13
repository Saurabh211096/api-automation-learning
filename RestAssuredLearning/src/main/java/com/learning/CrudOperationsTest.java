package com.learning;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;

public class CrudOperationsTest {

	public static void main(String[] args) {

		baseURI = "https://petstore.swagger.io/v2";
		
		String reqBody = "{\n" +
	            "  \"id\": 77665544,\n" +
	            "  \"category\": {\"id\": 1, \"name\": \"Dogs\"},\n" +
	            "  \"name\": \"RestAssured_Dog\",\n" +
	            "  \"photoUrls\": [\"string\"],\n" +
	            "  \"tags\": [{\"id\": 1, \"name\": \"testing\"}],\n" +
	            "  \"status\": \"available\"\n" +
	            "}";
		
		System.out.println("--- Executing POST Request ---");
		
		given()
			.header("Content-Type", "application/json")
			.body(reqBody)
		.when()
			.post("/pet")
		.then()
			.statusCode(200);
		
		System.out.println("--- Executing PUT Request ---");
		
		String updateBody = reqBody.replace("RestAssured_Dog", "Updated_RestAssured_Dog");
		
		given()
			.header("Content-Type", "application/json")
			.body(updateBody)
		.when()
			.put("/pet")
		.then().statusCode(200);
		
		System.out.println("--- Executing DELETE Request");
		
		given()
		.when()
			.delete("/pet/77665544")
		.then()
			.statusCode(200)
			.body("message", equalTo("77665544"));
		
		System.out.println("--- Verifying Deletion (GET expects 404) ---");
		
		given()
		.when()
			.get("/pet/77665544")
		.then()
			.statusCode(404)
			.body("message", equalTo("Pet not found"));
		
		System.out.println("SUCCESS: Full CRUD cycle executed perfectly");
		
	}

}

















