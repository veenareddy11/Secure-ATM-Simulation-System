# 🏦 Secure ATM Simulation System (Java)

## 📌 Project Description
The Secure ATM Simulation System is a Java-based desktop application that simulates the working of a real ATM.  
It provides secure user authentication and allows users to perform basic banking operations through a graphical interface.

The project is developed using **Java Swing for GUI**, **JDBC for database connectivity**, and **MySQL for data storage**.

---

## 🎯 Objectives
- To simulate real ATM operations using Java
- To implement secure user authentication
- To perform banking transactions such as withdrawal and deposit
- To store transaction data persistently in a database
- To design a user-friendly graphical interface

---

## ✨ Features
- Secure login using Account Number and PIN
- Balance enquiry
- Cash withdrawal with balance validation
- Cash deposit
- Mini statement (transaction history)
- GUI-based interaction using Java Swing
- Database-backed transaction management

---

## 🛠️ Technologies Used
- **Programming Language:** Java  
- **GUI Framework:** Java Swing  
- **Database Connectivity:** JDBC  
- **Database:** MySQL  
- **IDE:** Eclipse  

---

## 🧱 System Architecture
The project follows a layered architecture:
- **UI Layer:** Handles user interaction using Swing
- **Service Layer:** Contains business logic
- **DAO Layer:** Handles database operations
- **Database Layer:** Stores account and transaction data

---

## 📂 Project Structure


## 📂 Project Structure
```
SecureATM/
├── src/
│   ├── dao/
│   ├── model/
│   ├── service/
│   ├── util/
│   └── ui/
├── database.sql
└── README.md
```


---

## ⚙️ Setup Instructions
1. Install Java (JDK 11 or higher)
2. Install MySQL Server
3. Create the required database and tables
4. Open the project in Eclipse IDE
5. Add MySQL Connector/J to the project build path
6. Update database credentials in the DB connection file
7. Run the application from the Login screen

---

## ▶️ How to Run
- Launch the application by running the Login GUI class
- Enter a valid account number and PIN
- Perform ATM operations using the menu options

---

## 🧪 Testing
The application was tested for:
- Invalid login attempts
- Insufficient balance during withdrawal
- Successful deposit and withdrawal
- Correct display of mini statement
- Database updates after each transaction

---

## 🎯 Outcomes
- Automated ATM operations
- Reduced manual errors in transactions
- Secure and consistent transaction handling
- Improved understanding of Java GUI and database integration

---

## 🚀 Future Enhancements
- PIN encryption using hashing
- Account lock after multiple failed attempts
- Daily withdrawal limit
- PDF generation of transaction receipts
- Improved GUI design

---


---
