CREATE DATABASE atm_db;
USE atm_db;

CREATE TABLE account (
    acc_no INT PRIMARY KEY,
    name VARCHAR(100),
    pin INT,
    balance DOUBLE
);

CREATE TABLE transaction (
    txn_id INT AUTO_INCREMENT PRIMARY KEY,
    acc_no INT,
    type VARCHAR(20),
    amount DOUBLE,
    txn_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO account VALUES (123456, 'Rahul', 1234, 25000);
CREATE TABLE IF NOT EXISTS transaction (
    txn_id INT AUTO_INCREMENT PRIMARY KEY,
    acc_no INT,
    type VARCHAR(20),
    amount DOUBLE,
    txn_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
SHOW TABLES;

