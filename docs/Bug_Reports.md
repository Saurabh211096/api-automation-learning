# API Bug Reports

## Bug Report Template

**Bug ID:** BUG-001
**Title:** POST /pet - API returns 200 OK instead of standard 201 Created on resource creation
**Severity:** Low
**Environment:** QA Environment (Swagger v2)

**Steps to Reproduce:**
1. Send a POST request to `https://petstore.swagger.io/v2/pet`.
2. Include the valid JSON payload: `{"id": 77665544, "name": "RestAssured_Dog", "status": "available"}`
3. Observe the HTTP response status code.

**Expected Result:**
The API should return status code `201 Created` because a new resource was successfully added to the database.

**Actual Result:**
The API returned status code `200 OK`.

**Attached Logs/Screenshots:**
`Expected status code <201> but was <200>.`

---

**Bug ID:** BUG-002
**Title:** GET /pet/{petId} - Server crashes (500) when passing a negative integer as petId
**Severity:** High
**Environment:** QA Environment

**Steps to Reproduce:**
1. Send a GET request to `https://petstore.swagger.io/v2/pet/-1`.
2. Observe the response code.

**Expected Result:**
The API should gracefully handle the invalid input and return `400 Bad Request` or `404 Not Found`.

**Actual Result:**
The API throws an unhandled exception and returns `500 Internal Server Error`.

---

**Bug ID:** BUG-003
**Title:** POST /pet - API accepts empty string for pet "name" field
**Severity:** Medium
**Environment:** QA Environment

**Steps to Reproduce:**
1. Send a POST request to `https://petstore.swagger.io/v2/pet`.
2. Include payload: `{"id": 123, "name": "", "status": "available"}`

**Expected Result:**
The API should reject the payload and return `400 Bad Request` with a validation error stating "Name cannot be empty".

**Actual Result:**
The API returns `200 OK` and creates a database entry with a blank name.

---

**Bug ID:** BUG-004
**Title:** DELETE /pet/{petId} - Typo in success response message
**Severity:** Low
**Environment:** QA Environment

**Steps to Reproduce:**
1. Send a DELETE request to `https://petstore.swagger.io/v2/pet/77665544`.

**Expected Result:**
Response message should state: `"Pet successfully deleted"`.

**Actual Result:**
Response message states: `"Pet succesfuly delted"`.