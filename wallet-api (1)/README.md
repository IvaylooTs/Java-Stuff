# Wallet API

## Overview
The Wallet API is a Spring Boot application that allows users to create and manage virtual wallets. Each wallet can store a balance and supports operations like deposits, withdrawals, checking balance. The application uses MySQL as the database, which is dockerized with Docker.

## Features
- Create a new wallet with personal name and initial balance.
- View the balance of an existing wallet.
- Deposit funds into a wallet.
- Withdraw funds from a wallet.
- Delete a wallet.

## Technologies Used
- **Java**: Programming language.
- **Spring Boot**: Framework for building the application.
- **Hibernate**:  Object-Relational Mapping framework for database interaction.
- **MySQL**: Database for storing wallet information.
- **Docker**: Containerization for database setup.
- **Maven**: Build and dependency management (automates tasks like downloading libraries and packaging the application).

## Setup and Run Instructions

### Prerequisites
- JDK 
- Maven
- MySQL (Dockerized)
- Docker and Docker Compose

### Step 1: Clone the Repository
```bash
git clone <repository-url>
cd wallet-api
```

### Step 2: Database Setup

#### Dockerized MySQL Setup
1. Use the provided `docker-compose.yml` file to create a MySQL container:
   ```bash
   docker-compose up 
   ```
2. The database will be available at `localhost:8090`. Ensure the `application.properties` file reflects this:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:8090/wallet?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
   ```

### Step 3: Run the Application

The API will start on `http://localhost:8080`.

## API Documentation

### Base URL
`http://localhost:8080/api/wallets`

### Endpoints

| HTTP Method | Endpoint                 | Description              | Example Body/Params |
|-------------|--------------------------|--------------------------|---------------------|
| POST        | `/api/wallets`           | Create a new wallet      | `{ "name": "MyWallet"}` |
| GET         | `/api/wallets/{id}/balance` | View wallet balance     | `id: 1`             |
| PUT         | `/api/wallets/{id}/deposit` | Deposit money           | `amount=50.0`       |
| PUT         | `/api/wallets/{id}/withdraw` | Withdraw money         | `amount=20.0`       |
| DELETE      | `/api/wallets/{id}`      | Delete wallet            | `id: 1`             |

### Example Requests

#### 1. Create a Wallet
**POST** `/api/wallets`
- **Body:**
  ```json
  {
    "name": "Stefan's wallet"
  }
  ```

#### 2. View Wallet Balance
**GET** `/api/wallets/1/balance`

#### 3. Deposit Money
**PUT** `/api/wallets/1/deposit?amount=50.0`

#### 4. Withdraw Money
**PUT** `/api/wallets/1/withdraw?amount=20.0`

#### 5. Delete a Wallet
**DELETE** `/api/wallets/1`

## Testing the API

### Using Postman
1. Download and install Postman.
2. Import the base URL `http://localhost:8080/api/wallets`.
3. Test each endpoint with the example requests provided above.

## Additional comments

1. Future development on the app would be dockerisation for the whole app
