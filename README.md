# Stock Portfolio Management Application

This is a Stock Portfolio Management Application implemented in Java using the Spring Boot framework. The application provides a set of REST API endpoints for managing stock portfolios, user accounts, stock data, and transactions. It is designed to help users track and manage their stock portfolios efficiently.

## Features

- **Portfolio Management**: Users can create, update, and view their stock portfolios. Each portfolio includes information such as the number of shares, stock symbol, current price, cost basis, and yield.

- **User Account Management**: Users can create accounts and associate them with their portfolios. User accounts include information such as username, email, and password.

- **Stock Data Management**: The application stores information about different stocks, including stock symbols, names, day-before prices, and market capitalization.

- **Transaction Recording**: Users can record buy or sell transactions for stocks, including the stock symbol, transaction type, quantity, price, and timestamp.

## Project Structure

The application is structured into several packages:

- `com.sprindock.demo`: Contains the main class for running the Spring Boot application and defining REST API endpoints.

- `com.sprindock.demo.Tables`: Contains entity classes that represent the database tables, including `Portfolio`, `User`, `Stocks`, and `Transaction`. These classes define the structure of the database.

- `com.sprindock.demo.Tables.repositories`: Contains repository interfaces that provide database operations for the corresponding entities.

## Getting Started

To run the Stock Portfolio Management Application, you'll need to set up a PostgreSQL database and configure the application. The following configuration settings can be found in the `application.properties` file:

- Database URL, username, and password.
- Spring Data JPA settings.
- Hibernate settings.

You can use the provided Docker Compose file to set up a PostgreSQL database with the required credentials and volumes.

## Usage

The application exposes REST API endpoints for performing various operations. You can use tools like Postman or `curl` to interact with these endpoints. Here are some sample endpoints:

- Create a new user account: `POST /api/v1/customers/users`
- Create a new portfolio: `POST /api/v1/customers/portfolios`
- Record a transaction: `POST /api/v1/customers/transactions`
- Retrieve user information: `GET /api/v1/customers/users/{user_id}`
- Retrieve portfolio information: `GET /api/v1/customers/portfolios/{portfolio_id}`

## Deployment

You can deploy this application to your preferred cloud platform or run it locally. To run the application locally, use the following command:

```bash
./mvnw spring-boot:run
```

Make sure to configure the database settings in `application.properties` accordingly.

## Contributions

Contributions to this project are welcome! If you have any ideas, improvements, or bug fixes, feel free to submit a pull request.
