# Spring Boot Multithreading: Synchronous vs Asynchronous Service Calls

## Problem Statement

In microservice architectures, fetching data from multiple services can lead to performance bottlenecks if done sequentially. This project demonstrates the impact of synchronous vs asynchronous service calls within a single Spring Boot application.

We have three services:
- `ProductService` (backed by the `products` table)
- `PriceService` (backed by the `price` table)
- `InventoryService` (backed by the `inventory` table)

The goal is to fetch product details, price, and inventory information for a given product ID by calling all three services.

## Solution

Two approaches are implemented:
- **Synchronous:** `ProductSyncFacade` fetches data from all services one after another.
- **Asynchronous:** `ProductAsyncFacade` fetches data from all services in parallel using asynchronous programming.

The `ProductController` exposes two endpoints:
- `/api/product/{id}/sync` — Fetches product details synchronously
- `/api/product/{id}/async` — Fetches product details asynchronously

## Performance Comparison

By comparing the response times of these two endpoints, you can observe the performance benefits of asynchronous service calls when aggregating data from multiple sources.

## Technologies

- Java
- Spring Boot
- Maven

## Getting Started

1. Build the project:
    ```bash
    mvn clean install
    ```
2. Run the application:
    ```bash
    mvn spring-boot:run
    ```
3. Test the endpoints using your preferred API client.

## License

MIT