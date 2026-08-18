# Fee Management System

## 📌 Project Overview

The "Fee Management System" is a web-based application developed to simplify and manage student fee records digitally.

The system allows an administrator to securely log in, manage student information, record fee payments, and monitor paid and pending fees. Student and payment information is stored in **MongoDB** and accessed through REST APIs developed using **Spring Boot**.

---

## 🛠️ Technologies Used

| Technology          | Purpose                                 |
| ------------------- | --------------------------------------- |
| Java 21             | Backend programming                     |
| Spring Boot         | Backend application framework           |
| Spring Web          | REST API development                    |
| Spring Data MongoDB | Database integration                    |
| Spring Security     | API and authentication security         |
| BCrypt              | Password encryption                     |
| MongoDB             | Database                                |
| HTML                | Frontend structure                      |
| CSS                 | Frontend styling                        |
| JavaScript          | Frontend functionality                  |
| Maven               | Project build and dependency management |

---



## 📁 Project Structure

smart-fee-management/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/smart_fee_management/
│       │       │
│       │       ├── config/
│       │       │   ├── PasswordConfig.java
│       │       │   └── SecurityConfig.java
│       │       │
│       │       ├── controller/
│       │       │   ├── PaymentController.java
│       │       │   ├── StudentController.java
│       │       │   └── UserController.java
│       │       │
│       │       ├── model/
│       │       │   ├── Payment.java
│       │       │   ├── Student.java
│       │       │   └── User.java
│       │       │
│       │       ├── repository/
│       │       │   ├── PaymentRepository.java
│       │       │   ├── StudentRepository.java
│       │       │   └── UserRepository.java
│       │       │
│       │       ├── service/
│       │       │   ├── PaymentService.java
│       │       │   ├── StudentService.java
│       │       │   └── UserService.java
│       │       │
│       │       └── SmartFeeManagementApplication.java
│       │
│       └── resources/
│           ├── static/
│           │   ├── index.html
│           │   └── login.html
│           │
│           └── application.properties
│
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md

---

## 💻 Running the Application

### Prerequisites

Install the following:

* Java 21
* MongoDB
* Maven (optional because Maven Wrapper is included)

### 1. Start MongoDB

Make sure MongoDB is running locally on:

mongodb://localhost:27017

### 2. Configure MongoDB

The application configuration is stored in:
src/main/resources/application.properties

The application uses port:

8080

### 3. Run the application

Using Maven Wrapper:

./mvnw spring-boot:run

Or:

./mvnw clean package
java -jar target/smart-fee-management-0.0.1-SNAPSHOT.jar


### 4. Open the application

Open:

http://localhost:8080

---

## 📄 License

This project is developed for educational and academic purposes.
