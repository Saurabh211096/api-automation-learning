# Pull Request Review #42

**Reviewer:** QA Automation Engineer
**Status:** ❌ Changes Requested

## Review Comments:

**1. Missing Assertions (Critical):**
This test has no assertions for the status code or the response body. Currently, it will always pass even if the API is down. Please add `.then().statusCode(200)` at a minimum.

**2. Hardcoded Data (Major):**
The hardcoded URL `https://petstore.swagger.io/v2` should be extracted to a configuration file or a `baseURI` setup method so we can easily switch between QA and Staging environments.

**3. Test Coverage (Minor):**
Consider adding a negative test case (e.g., `testGetPet_InvalidId`) to verify the API correctly returns a `404 Not Found` when requesting a non-existent pet ID.