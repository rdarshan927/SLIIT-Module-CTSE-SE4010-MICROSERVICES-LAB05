# CTSE Lab 05 — Microservices

Student: Darshan R 

## Description

Simple microservices demo (Item, Order, Payment) + API Gateway. Each service runs in its own Docker container and is reachable via gateway on port 8080.

## Prerequisites

- Docker & Docker Compose
- Java 17 & Maven (only if rebuilding jars)

## Build & Run

# Optional: build jars

mvn -f item-service/pom.xml clean package -DskipTests
mvn -f order-service/pom.xml clean package -DskipTests
mvn -f payment-service/pom.xml clean package -DskipTests
mvn -f api-gateway/pom.xml clean package -DskipTests

# Build and start containers (from repo root)

docker compose build
docker compose up -d

# Stop and remove

docker compose down

## Ports

- API Gateway: http://localhost:8080
- Item Service: http://localhost:8081
- Order Service: http://localhost:8082
- Payment Service: http://localhost:8083

## Endpoints (via gateway)

GET /items
POST /items Body: {"name":"Headphones"}
GET /items/{id}

GET /orders
POST /orders Body: {"item":"Laptop","quantity":2,"customerId":"C001"}
GET /orders/{id}

GET /payments
POST /payments/process Body: {"orderId":1,"amount":1299.99,"method":"CARD"}
GET /payments/{id}


## Notes

- If VS Code shows package path errors, run: "Java: Clean Java Language Server Workspace".
- Fixed method label in submission doc: use POST for creating items.
