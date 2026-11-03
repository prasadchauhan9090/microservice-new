Here is a clean, professional, and well-structured `README.md` template tailored for your `microservice-new` project repository. It accurately reflects the three microservices (`product-service`, `order-service`, and `inventory-service`) we worked on, along with their architecture and technology stack.

You can copy and paste this directly into your GitHub README editor!

---

```markdown
# E-Commerce Microservices Application (`microservice-new`)

A modular, multi-service e-commerce application built using **Spring Boot** and modern backend architecture standards. This project demonstrates synchronous inter-service communication, reactive web clients, database persistence, and a decoupled microservices design.

---

## 🏗️ Microservices Architecture

The system is divided into independent, loosely-coupled microservices:


```

[ Client / Postman ]
│
├─────────────────────────┐
▼                         ▼
┌──────────────┐          ┌──────────────┐
│product-service│          │ order-service│ ──(WebClient GET)──> ┌──────────────────┐
└──────────────┘          └──────────────┘                      │ inventory-service│
└──────────────────┘

```

### 1. Product Service (`product-service`)
* **Role:** Manages product catalog creation, retrieval, and metadata.
* **Tech Stack:** Spring Boot, Spring Data MongoDB / JPA, Lombok.

### 2. Order Service (`order-service`)
* **Role:** Handles customer order placement, mapping of order line items, and validating stock levels before saving transactions.
* **Communication:** Uses Spring WebFlux's **`WebClient`** to synchronously call the Inventory Service to verify product availability (`/api/inventory`) before confirming orders.
* **Tech Stack:** Spring Boot, Spring WebFlux (WebClient), Spring Data JPA, MySQL / H2, Lombok.

### 3. Inventory Service (`inventory-service`)
* **Role:** Manages warehouse stock levels, tracks quantities, and exposes endpoints to check product availability for incoming orders.
* **Tech Stack:** Spring Boot, Spring Data JPA, MySQL / H2, Lombok.

---

## 🛠️ Tech Stack & Libraries

* **Java:** 21
* **Framework:** Spring Boot
* **Reactive Programming:** Spring WebFlux (`WebClient`)
* **Database Access:** Spring Data JPA, Hibernate, MongoDB
* **Build Tool:** Maven (Multi-module / Parent POM structure)
* **Utilities:** Project Lombok

---

## 🚀 Getting Started & Running Locally

### Prerequisites
* JDK 21 installed on your machine.
* Maven installed.
* Running database instances (MySQL / MongoDB depending on your service configurations).

### Step 1: Clone the Repository
```bash
git clone [https://github.com/prasadchauhan9090/microservice-new.git](https://github.com/prasadchauhan9090/microservice-new.git)
cd microservice-new

```

### Step 2: Build the Project

Run a clean install from the root folder to compile the parent POM and all child services:

```bash
mvn clean install

```

### Step 3: Run the Individual Services

Start each microservice in its respective terminal window:

* **Product Service:**
```bash
cd product-service
mvn spring-boot:run

```


* **Inventory Service (Port 8082):**
```bash
cd inventory-service
mvn spring-boot:run

```


* **Order Service (Port 8081):**
```bash
cd order-service
mvn spring-boot:run

```



---

## 🔌 API Endpoints Reference

### Order Service (`http://localhost:8081`)

* **POST `/api/order**`
* *Payload Example:*
```json
{
  "orderLineItemsDtoList": [
    {
      "skuCode": "iphone_18",
      "price": 180000,
      "quantity": 1
    }
  ]
}

```





### Inventory Service (`http://localhost:8082`)

* **GET `/api/inventory?skuCode=iphone_18**`
* *Response:* Returns stock status array (`isInStock: true/false`).



---

## 👨‍💻 Author

**Prasad Chauhan**

```

```
