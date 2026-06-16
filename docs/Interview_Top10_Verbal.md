# Top 10 API Automation Interview Questions (Self-Correction Key)

**1. What is an API?**
Application Programming Interface. A bridge that allows two distinct software systems to communicate.

**2. What is the difference between GET and POST?**
GET retrieves data and has no request body. POST creates new data and strictly requires a request body.

**3. What is the difference between PUT and POST?**
POST creates a brand new record. PUT updates an existing record completely.

**4. What is a Path Parameter vs. a Query Parameter?**
A Path Parameter (`/pet/1`) identifies one specific resource. A Query Parameter (`/pet/findByStatus?status=sold`) filters a list of resources.

**5. How do you validate a response body in REST Assured?**
By using Hamcrest matchers within the `then()` block, such as `.body("name", equalTo("Dog"))`.

**6. What is JSON Path?**
A query language used to navigate and extract specific values from a JSON document.

**7. How do you handle dynamic data between two API requests?**
By performing API Chaining: Extracting the value from Response A using JSON Path, storing it in a Java variable, and passing it into Request B.

**8. What is the difference between 401 and 403 status codes?**
401 Unauthorized means "You didn't provide a valid token/login". 403 Forbidden means "You are logged in, but you don't have admin rights to do this".

**9. Why do we use POJOs?**
Plain Old Java Objects allow us to avoid typing raw, unmaintainable JSON strings. We use the Jackson library to automatically serialize Java objects into JSON payloads.

**10. What is the difference between System.out.println and logging in CI/CD?**
`System.out.println` only prints to the local IDE console. In the industry, we strictly use assertions and logging frameworks (like TestNG reports) so the results are permanently captured by the CI/CD pipeline.