-- Only runs if database doesn't exist
CREATE DATABASE IF NOT EXISTS customer_test;

-- Connect to the database
use customer_test;

-- Create tables if they don't exist
CREATE TABLE IF NOT EXISTS users (
    user_id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

CREATE TABLE IF NOT EXISTS stocks (
                                      stock_id SERIAL PRIMARY KEY,
                                      name VARCHAR(100) NOT NULL,
    symbol VARCHAR(10) NOT NULL UNIQUE,
    price DECIMAL(10, 2) NOT NULL,
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

CREATE TABLE IF NOT EXISTS portfolios (
                                          portfolio_id SERIAL PRIMARY KEY,
                                          user_id INT NOT NULL,
                                          name VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
    );

CREATE TABLE IF NOT EXISTS transactions (
                                            transaction_id SERIAL PRIMARY KEY,
                                            portfolio_id INT NOT NULL,
                                            stock_id INT NOT NULL,
                                            quantity INT NOT NULL,
                                            price DECIMAL(10, 2) NOT NULL,
    transaction_type VARCHAR(10) NOT NULL,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (portfolio_id) REFERENCES portfolios(portfolio_id),
    FOREIGN KEY (stock_id) REFERENCES stocks(stock_id)
    );

-- Insert stocks data only if table is empty
INSERT INTO stocks (name, symbol, price)
SELECT * FROM (
                  VALUES
                      ('Apple Inc.', 'AAPL', 180.95),
                      ('Microsoft Corporation', 'MSFT', 338.72),
                      ('Amazon.com Inc.', 'AMZN', 142.83),
                      ('Alphabet Inc.', 'GOOGL', 131.86),
                      ('Tesla Inc.', 'TSLA', 177.86),
                      ('Meta Platforms Inc.', 'META', 450.38),
                      ('NVIDIA Corporation', 'NVDA', 950.02),
                      ('JPMorgan Chase & Co.', 'JPM', 198.95),
                      ('Johnson & Johnson', 'JNJ', 147.87)
              ) AS v(name, symbol, price)
WHERE NOT EXISTS (SELECT 1 FROM stocks LIMIT 1);

-- Insert sample users if table is empty
INSERT INTO users (username, email, password)
SELECT * FROM (
                  VALUES
                      ('demo_user', 'demo@example.com', '$2a$10$demopasswordhash'),
                      ('test_user', 'test@example.com', '$2a$10$testpasswordhash')
              ) AS v(username, email, password)
WHERE NOT EXISTS (SELECT 1 FROM users LIMIT 1);