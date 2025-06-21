# Spring Boot Resilience4j RateLimiter Demo

## Overview

This demo application showcases the use of [Resilience4j](https://resilience4j.readme.io/) RateLimiter in a Spring Boot environment. 
Rate limiting is a critical technique for protecting backend services from being overwhelmed by too many requests, ensuring system stability and graceful degradation under load.

## What is Resilience4j RateLimiter?

Resilience4j is a lightweight, easy-to-use fault tolerance library designed for Java 8 and functional programming. 
The RateLimiter module allows you to restrict the number of calls to a particular service within a specified time window. If the limit is exceeded, further calls are rejected with a `429 Too Many Requests` response.

**Key Features:**
- Configurable number of permitted calls per period
- Configurable refresh period
- Flexible integration with Spring Boot via annotations

## How This Demo Works

This application exposes three REST endpoints, each protected by a different Resilience4j RateLimiter configuration:

- `/message/a` — Uses the `backendA` RateLimiter
- `/message/b` — Uses the `backendB` RateLimiter
- `/message/c` — Uses the `backendC` RateLimiter (default configuration)

Each endpoint is annotated with `@RateLimiter`, which automatically applies the rate limiting logic. 
When the number of allowed requests is exceeded within the configured time window, the endpoint returns a `429 Too Many Requests` error.

## Project Structure

- `src/main/java/com/example/resilience4j_ratelimiter/controller/SampleController.java`  
  Contains the REST endpoints with `@RateLimiter` annotations.
- `src/test/java/com/example/resilience4j_ratelimiter/SampleControllerTest.java`  
  Contains integration tests that verify the rate limiting behavior.

## How to Run

1. **Build the project:**

```cmd
mvn clean install
```
2. **Run the application:**

```cmd
mvn spring-boot:run
```
3. **Test the endpoints:**
   Use `curl` or Postman to send requests to:
    - `http://localhost:8080/message/a`
    - `http://localhost:8080/message/b`
    - `http://localhost:8080/message/c`

   After exceeding the configured rate limit, you will receive a `429` response.

## Example RateLimiter Configuration

You can configure the rate limiters in your `application.yml` or `application.properties`:

```yaml
resilience4j.ratelimiter:
  instances:
    backendA:
      limitForPeriod: 1
      limitRefreshPeriod: 1s
    backendB:
      limitForPeriod: 2
      limitRefreshPeriod: 1s
    backendC:
      limitForPeriod: 3
      limitRefreshPeriod: 
```
### RateLimiter Configuration Explained
The configuration has two sections: `configs` and `instances`.
- `configs` : Define reusable configurations (e.g., default, backendA). These can be referenced by instances using the baseConfig parameter.
- `instances` : Each instance (e.g., backendA, backendB) matches the name parameter in the @RateLimiter annotation. 
                If no matching instance is found, the default config is used (e.g., backendC uses default if not defined).

### Key Configuration Parameters
- `timeoutDuration`  : How long a thread waits for permission.
- `limitRefreshPeriod` : How often the rate limit resets.
- `limitForPeriod` : Number of allowed requests per refresh period.

This structure allows flexible and reusable rate limiter settings across different endpoints.

## Testing
The included test class `SampleControllerTest` uses Spring's `MockMvc` to simulate repeated requests and asserts that the correct HTTP status codes (200 OK and 429 Too Many Requests) 
are returned according to the rate limiter configuration.

## Conclusion
This demo application illustrates how to implement rate limiting in a Spring Boot application using Resilience4j. 