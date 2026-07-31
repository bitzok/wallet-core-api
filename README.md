# Basic Wallet API

## Description
This is a small REST API built with Java and Spring Boot. This repository was created as a practice environment to learn about backend development, unit testing, and automation.

**Note:** This project is a learning exercise and is not intended to be a fully-fledged banking system. It does not implement authentication, data encryption, or production-level security measures. Its focus is strictly on practicing the logic of money transfers and configuring development lifecycle tools.

## Tech Stack
* Java & Spring Boot
* PostgreSQL
* JUnit 5 & Mockito
* GitHub Actions

## Learning Objectives
This repository reflects the practice of the following concepts:
* Separation of concerns using layered architecture (Controllers, Services, Repositories).
* Exception handling for basic edge cases (e.g., attempting a transfer with insufficient funds).
* Writing unit tests with test doubles (Mocks) to isolate logic without relying on the database.
* Setting up a Continuous Integration (CI) pipeline using GitHub Actions to verify that tests pass on every code update.

## How to Run Locally
To set up this project in your local environment:

1. Configure your PostgreSQL database credentials in the `application.properties` file.
2. To execute the unit test suite:
```bash
   ./mvnw test
```
3. To start the server:
```bash
   ./mvnw spring-boot:run
```
