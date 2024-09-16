Here's an example of how you can document your project in a `README.md` file, including methodology, test cases, test results, and build/run instructions.

---

# Spring Boot Order Management System

This project is a simple Order Management System implemented using **Spring Boot**. It includes basic CRUD operations for managing orders and products, and exposes RESTful APIs for interaction.

## Chosen Methodology: TDD (Test-Driven Development)

In this project, I applied **Test-Driven Development (TDD)**. TDD is a software development approach where tests are written before writing the actual code. The process involves:
1. Writing a failing test for a new feature or functionality.
2. Writing the minimal code to make the test pass.
3. Refactoring the code to meet standards while ensuring tests pass.

TDD encourages building robust and bug-free software, as tests drive the development of features.

## Features
- **Order Management**: Create, update, delete, and retrieve customer orders.
- **Product Management**: Manage products with basic CRUD operations.

## Test Cases Written
### **Order Tests**
- **testCreateOrder**: Verifies the creation of an order.
- **testGetOrderById**: Verifies retrieval of an order by its ID.
- **testUpdateOrder**: Verifies updating an existing order.
- **testDeleteOrder**: Verifies the deletion of an order by ID.
- **testGetAllOrders**: Verifies retrieval of all orders.

### **Product Tests**
- **testCreateProduct**: Verifies the creation of a product.
- **testGetProductById**: Verifies retrieval of a product by its ID.
- **testUpdateProduct**: Verifies updating an existing product.
- **testDeleteProduct**: Verifies the deletion of a product by ID.
- **testGetAllProducts**: Verifies retrieval of all products.

## Test Results
All tests were executed successfully. Here's an overview of the results:

| Test Name            | Status   | Result    |
|----------------------|----------|-----------|
| testCreateOrder       | Passed   | Success   |
| testGetOrderById      | Passed   | Success   |
| testUpdateOrder       | Passed   | Success   |
| testDeleteOrder       | Passed   | Success   |
| testGetAllOrders      | Passed   | Success   |
| testCreateProduct     | Passed   | Success   |
| testGetProductById    | Passed   | Success   |
| testUpdateProduct     | Passed   | Success   |
| testDeleteProduct     | Passed   | Success   |
| testGetAllProducts    | Passed   | Success   |

## Build and Run Instructions

### Prerequisites
- **Java 11** or higher
- **Maven** 3.x+
- **Postman** (for testing APIs)
- **IDE** (like IntelliJ IDEA or Eclipse)

### Build the Project
1. Clone the repository:
   ```bash
   git clone <repository_url>
   ```
2. Navigate to the project directory:
   ```bash
   cd SpringBootOrderManage
   ```
3. Build the project using Maven:
   ```bash
   mvn clean install
   ```

### Run the Application
1. After building the project, run the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```
2. The application will be running at `http://localhost:8080`.

### Running Tests
To run the tests:
1. Use the following Maven command to run the tests:
   ```bash
   mvn test
   ```
2. Check the results in the terminal or view the detailed test results in `target/surefire-reports`.

### Interact with the API
You can use **Postman** or **curl** to interact with the exposed endpoints.

#### Endpoints for Orders
- **Create Order (POST)**: `http://localhost:8080/orders`
  ```json
  {
    "customerName": "John Doe"
  }
  ```
- **Get Order by ID (GET)**: `http://localhost:8080/orders/{id}`
- **Update Order (PUT)**: `http://localhost:8080/orders/{id}`
  ```json
  {
    "customerName": "Jane Doe"
  }
  ```
- **Delete Order (DELETE)**: `http://localhost:8080/orders/{id}`
- **Get All Orders (GET)**: `http://localhost:8080/orders`

#### Endpoints for Products
- **Create Product (POST)**: `http://localhost:8080/products`
  ```json
  {
    "name": "Phone",
    "price": 800.00
  }
  ```
- **Get Product by ID (GET)**: `http://localhost:8080/products/{id}`
- **Update Product (PUT)**: `http://localhost:8080/products/{id}`
  ```json
  {
    "name": "Tablet",
    "price": 500.00
  }
  ```
- **Delete Product (DELETE)**: `http://localhost:8080/products/{id}`
- **Get All Products (GET)**: `http://localhost:8080/products`

### Additional Information
- This project uses an in-memory **H2** database for demonstration purposes. You can change the database configurations in the `application.properties` file if you wish to use another database like MySQL or PostgreSQL.
- If the database console is enabled, you can access the H2 database console at `http://localhost:8080/h2-console`.

---
