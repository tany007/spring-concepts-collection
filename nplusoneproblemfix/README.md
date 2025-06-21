# N+1 Problem Demo Application

This demo application showcases the N+1 select problem in JPA/Hibernate and demonstrates two effective solutions using Spring Data JPA: the `@EntityGraph` annotation and a custom JPQL query with `JOIN FETCH`.

## What is the N+1 Problem?

The N+1 problem occurs when fetching a list of entities with a lazily loaded collection (e.g., `Customer` with `addresses`). JPA first executes one query to fetch all customers (1 query), then for each customer, it executes an additional query to fetch their addresses (N queries). This results in N+1 queries, which can severely impact performance.

## How to Fix the N+1 Problem

### 1. Using `@EntityGraph`
The `@EntityGraph` annotation tells JPA to fetch the specified associations eagerly in a single query.

**Example:**

```java
@EntityGraph(attributePaths = "addresses")
List<Customer> findAll();
```
This fetches all customers and their addresses in one query, avoiding the N+1 problem.

### 2. Using a Custom JPQL Query with JOIN FETCH
A custom query with LEFT JOIN FETCH explicitly fetches the related entities in a single query.

**Example:**

```java
@Query("SELECT c FROM Customer c LEFT JOIN FETCH c.addresses")
List<Customer> fetchCustomersWithAddress();
```
This also retrieves all customers and their addresses in one query.

## Summary
Both `@EntityGraph` and custom JPQL with JOIN FETCH are effective solutions to the N+1 problem in Spring Data JPA. 
Use them to optimize your data access and improve application performance.