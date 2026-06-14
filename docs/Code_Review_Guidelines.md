# QA Code Review Checklist

When reviewing a Pull Request (PR), QA Engineers must look for the following flaws:

**1. Missing Validations (Negative Paths)**
- Did the developer only write code for the "Happy Path" (perfect inputs)?
- What happens if an API payload sends `null`, an empty string `""`, or a negative number? The code should explicitly handle these.

**2. Poor Error Handling**
- If a user requests a pet ID that doesn't exist, does the code crash and return a `500 Internal Server Error`? It should be caught and return a `404 Not Found`.
- Are the error messages readable, or do they expose internal database logic (Security vulnerability)?

**3. Hardcoded Data**
- Are URLs, passwords, or authentication tokens hardcoded directly in the Java/JavaScript files? These must be extracted to a configuration file or Environment Variables.

**4. Testability (For UI/API)**
- For APIs: Is there a way to easily generate test data?
- For UI: Did the front-end developer add unique `data-testid` attributes to HTML buttons so the automation scripts can easily find them?

**5. Missing Assertions (Automation PRs)**
- If reviewing another QA's automation code, did they just write `given().get()` but forget the `.then().statusCode(200)`? A test without an assertion is useless; it will always pass even if the app is broken.