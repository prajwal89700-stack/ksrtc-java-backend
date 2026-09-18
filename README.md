# KSRTC Bus Booking Backend Engine

A secure, thread-safe concurrent Java backend designed to handle bus ticket reservations and prevent race conditions. Built with Core Java and PostgreSQL.

## Core Architecture
* **DAO Pattern:** Strict separation of database transactions (`BusDAO.java`) from the application logic (`KSRTCApp.java`).
* **Concurrency Control:** Utilized Atomic SQL updates to ensure database integrity during simultaneous booking and cancellation requests. 
* **Environment Security:** Database credentials and admin access keys are injected via OS-level Environment Variables, ensuring zero hardcoded secrets.

## Tech Stack
* **Language:** Java (JDK 21)
* **Database:** PostgreSQL
* **Tools:** IntelliJ IDEA, JDBC
