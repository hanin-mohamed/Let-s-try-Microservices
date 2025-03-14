# Microservices Project: Simple Library Management System 

## Project Description
In this project, I aimed to apply the basics of Microservices in a simplified way to understand how independent services work together. The result is a simple **Library Management System** built using a **Microservices Architecture**, consisting of three independent services: **Book Service**, **User Service**, and **Borrowing Service**. Each service runs in its own container and connects to a dedicated database, demonstrating the core principles of Microservices design.
I built this project to learn Microservices, gaining experience with Docker and REST APIs despite connectivity challenges.

## Technologies Used
- **Spring Boot**: For developing the microservices.
- **Docker**: For containerization and deployment.
- **PostgreSQL & MySQL**: As databases for the services.
- **Docker Compose**: For orchestrating the containers.

## Achievements
- Implemented three microservices:
  - **Book Service**: Manages books (PostgreSQL on port 5433).
  - **User Service**: Manages users (PostgreSQL on port 1234).
  - **Borrowing Service**: Handles borrowing (MySQL on port 3307), communicating via REST APIs.
- Containerized services with Docker and used a custom network (`microservices-network`).
- Tested APIs (ex: `POST http://localhost:8080/books`, `POST http://localhost:8082/borrow`).

## Microservices Concepts Applied
- **Independent Services**: Each service is isolated.
- **Database per Service**: Separate databases for each service.
- **Synchronous Communication**: REST-based communication.
- **Containerization**: Docker .