# API Performance Testing Basics

Functional testing ensures the API works. Performance testing ensures it survives real-world traffic.

**1. Core Metrics**
- **Response Time:** The total time taken from the moment the client sends the request to the moment the last byte of the response is received. (Standard expectation: < 500ms).
- **Latency:** The time the data takes to physically travel across the network. (A subset of Response Time).
- **Throughput:** The number of requests the server can successfully handle per second (RPS) without crashing.

**2. Types of Performance Testing**
- **Load Testing:** Testing the API under *expected* normal traffic. (e.g., Can our E-commerce API handle 1,000 users checking out simultaneously on a normal Tuesday?)
- **Stress Testing:** Testing the API under *extreme* traffic until it breaks. (e.g., Black Friday traffic hits 50,000 users. At what exact number does the server throw a 503 Service Unavailable error?)
- **Spike Testing:** Sending a massive, sudden wave of traffic instantly to see if the server's auto-scaling can react fast enough.

**3. Tools Used in the Industry**
- **JMeter:** The traditional, Java-based industry standard. Uses a heavy UI.
- **k6:** The modern, developer-friendly standard. Written in Go, tests are scripted in JavaScript, and it runs natively in the terminal for CI/CD.
- **Postman:** Good for checking single response times, but terrible for Load Testing (it cannot simulate thousands of concurrent users effectively).