# API Automation Framework (Java + REST Assured)

[![REST Assured API Tests CI](https://github.com/Saurabh211096/api-automation-learning/actions/workflows/api-tests.yml/badge.svg)](https://github.com/Saurabh211096/api-automation-learning/actions/workflows/api-tests.yml)

## 📌 Project Overview
This repository contains a fully automated API testing framework built from scratch. It executes End-to-End (E2E) CRUD operations, validates JSON schema architectures, and performs negative testing against the Swagger Petstore API. 

## 🛠️ Tech Stack
- **Language:** Java 17
- **API Automation:** REST Assured
- **Test Runner:** TestNG
- **Build Tool:** Maven
- **CI/CD:** GitHub Actions
- **Performance Testing:** k6 & Postman
- **Documentation:** IEEE 829 Standard & Markdown

## 🚀 How to Run Locally

**Prerequisites:** Ensure you have Java 17 and Maven installed on your machine.

1. Clone the repository:
```bash
git clone https://github.com/Saurabh211096/api-automation-learning.git
```
2. Navigate to the project directory:
```bash
cd api-automation-learning/RestAssuredLearning
```
3. Execute the TestNG Suite via Maven:
```bash
mvn clean test
```

## 📂 Project Structure
- `RestAssuredLearning/src/main/java/`: Core REST Assured Java test scripts (CRUD, POJO, JSON Path).
- `RestAssuredLearning/testng.xml`: TestNG suite configuration for batch execution.
- `docs/`: QA documentation including IEEE 829 Test Plans, Bug Reports, and Jira workflow notes.
- `performance/`: k6 JavaScript load testing scripts.
- `.github/workflows/`: CI/CD YAML configuration for automated GitHub Actions execution.

## 🧪 Key Testing Scenarios Covered
1. **Happy Path:** Full E2E CRUD cycle (POST ➔ GET ➔ PUT ➔ DELETE) with dynamic data chaining.
2. **Negative Testing:** Validating server responses for `404 Not Found`, `400 Bad Request`, and `405 Invalid Input`.
3. **Data Serialization:** Utilizing Jackson Databind to map Java POJOs to JSON request payloads.
4. **Boundary Value Analysis:** Stress-testing database limits with oversized string payloads.