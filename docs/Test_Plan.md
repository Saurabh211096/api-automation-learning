# Petstore API Test Plan (IEEE 829 Standard)

## 1. Introduction
*Objective:* To verify the stability, functional correctness, and reliability of the Swagger Petstore API (v2), specifically focusing on the lifecycle management of Pet resources.

## 2. Test Items
*What are we testing?*
- The Petstore API endpoints hosted at: `https://petstore.swagger.io/v2`
- JSON Request and Response body payloads.
- HTTP Status Codes (200, 404, etc.).

## 3. Features to Test
*Which specific functionalities are in scope?*
- **Create Pet (POST):** Verify a new pet can be added to the store database.
- **Read Pet (GET):** Verify an existing pet can be retrieved using its unique ID.
- **Update Pet (PUT):** Verify an existing pet's details (name, status) can be modified.
- **Delete Pet (DELETE):** Verify an existing pet can be permanently removed from the database.

## 4. Approach
*What tools and strategies will be used?*
- **Phase 1 (Manual):** Exploratory testing and endpoint validation using Postman.
- **Phase 2 (Automation):** Development of an End-to-End (E2E) automation framework using Java 17, REST Assured, and TestNG.
- **Phase 3 (CI/CD):** Integration into a continuous execution pipeline using GitHub Actions, triggered on every push to the `main` branch.

## 5. Item Pass/Fail Criteria
*What defines a successful release?*
- **Pass:** 100% of critical CRUD automated test cases pass in the CI/CD pipeline. API correctly handles JSON payloads and returns appropriate status codes.
- **Fail:** Any `500 Internal Server Error` is encountered, or the E2E CRUD cycle breaks, resulting in a failed GitHub Actions build.