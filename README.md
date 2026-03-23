# SmartOrder — Event-Driven Microservices Platform

A production-style backend platform built with Java + Spring Boot, demonstrating microservices architecture, event-driven communication, and distributed systems design.

---

## Architecture Overview

Each service is independently deployable with its own database (database-per-service pattern).

```
SmartOrder-Event-Driven-Platform/
├── order-service/        (Port 8080)
├── payment-service/      (Port 8081)
├── inventory-service/    (Port 8082) [coming soon]
├── delivery-service/     (Port 8083) [coming soon]
└── notification-service/ (Port 8084) [coming soon]
```

---

## Services

### Order Service (Port 8080)
Handles order creation and order lifecycle management.

**Endpoints:**
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/orders` | Place a new order |
| GET | `/orders/{id}` | Get order by ID |

**Order Status Flow:**
`PENDING` → `PROCESSING` → `COMPLETED` / `FAILED` / `CANCELLED` / `REFUNDED`

---

### Payment Service (Port 8081)
Handles payment processing and payment status tracking.

**Endpoints:**
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/payments` | Process a payment |
| GET | `/payments/{id}` | Get payment by ID |

**Payment Status Flow:**
`PENDING` → `SUCCESS` / `FAILED` / `REFUNDED`

---

## Tech Stack

| Layer | Technology |
|-------|------------|
| Language | Java 17 |
| Framework | Spring Boot |
| Database | MySQL (per service) |
| Security | Spring Security, JWT, BCrypt |
| ORM | Spring Data JPA, Hibernate |
| Messaging | Kafka, RabbitMQ (Phase 2) |
| Caching | Redis (Phase 3) |
| DevOps | Docker, Kubernetes (Phase 4) |

---

## Design Patterns Used

- **Service Layer Pattern** — Interface + Implementation separation for loose coupling
- **Database per Service** — Each microservice owns its database, no shared DB
- **Repository Pattern** — JpaRepository for clean data access layer

---

## Phases

- [x] **Phase 1** — Core services with REST APIs and MySQL (Order + Payment)
- [ ] **Phase 2** — Kafka event-driven communication between services
- [ ] **Phase 3** — RabbitMQ for notification background jobs
- [ ] **Phase 4** — Redis caching for order status and delivery ETA
- [ ] **Phase 5** — Docker + Kubernetes deployment

---

## Running Locally

### Prerequisites
- Java 17+
- MySQL 8+
- Maven

### Setup

1. Clone the repo
```bash
git clone https://github.com/yourusername/SmartOrder-Event-Driven-Platform.git
```

2. Create databases in MySQL
```sql
CREATE DATABASE Orderservice;
CREATE DATABASE PaymentService;
```

3. Update `application.properties` in each service with your MySQL credentials

4. Run each service
```bash
cd order-service
mvn spring-boot:run

cd payment-service
mvn spring-boot:run
```

---

## Sample Requests

### Place an Order
```json
POST http://localhost:8080/orders
{
    "itemName": "Pizza",
    "itemPrice": 289.0,
    "itemQuantity": 2,
    "itemDescription": "Cheese Pizza",
    "userName": "Aditya",
    "userAddress": "Karjat, Maharashtra",
    "paymentMethod": "UPI"
}
```

### Process a Payment
```json
POST http://localhost:8081/payments
{
    "orderId": 1,
    "userId": 1,
    "amount": 289.0,
    "currency": "INR",
    "description": "Payment for Pizza order",
    "paymentMethod": "UPI"
}
```

---

## Author

**Aditya Yadav**  
[LinkedIn](https://linkedin.com/in/yourprofile) | [GitHub](https://github.com/yourusername)
