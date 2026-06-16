# Technical Interview Q&A - API Testing

**1. What is REST Assured?**
- **Answer:** REST Assured is an open-source Java library used to automate the testing of RESTful APIs. It acts like a headless client to send HTTP requests and validate responses. It uses a BDD (Behavior-Driven Development) syntax pattern: `given()` for setup, `when()` for execution, and `then()` for assertions.

**2. What is the difference between REST and SOAP?**
- **Answer:** 
  - **REST** (Representational State Transfer) is an architectural style. It uses standard HTTP methods (GET, POST), is lightweight, and supports multiple data formats (JSON, XML, Plain Text).
  - **SOAP** (Simple Object Access Protocol) is a strict protocol. It only uses XML, requires more bandwidth, and relies on WSDL (Web Services Description Language) files for structure.

**3. What is an HTTP Status Code? Name the categories.**
- **Answer:** A status code is a 3-digit integer returned by the server to indicate the result of the client's request.
  - `1xx`: Informational
  - `2xx`: Success (e.g., 200 OK, 201 Created)
  - `3xx`: Redirection
  - `4xx`: Client Error (e.g., 400 Bad Request, 404 Not Found)
  - `5xx`: Server Error (e.g., 500 Internal Server Error)

**4. How do you handle Authentication in API testing?**
- **Answer:** APIs are secured using tokens (like Bearer Tokens or OAuth). In Postman, I inject the token into the "Authorization" tab. In REST Assured, I pass it in the setup phase using `.header("Authorization", "Bearer " + token)` or via the built-in method `given().auth().oauth2(token)`.