🚗 Car Booking System – Spring Boot

A simple Spring Boot application for managing car bookings.
This project demonstrates Java, Spring Boot, REST APIs, and a clean layered backend structure.

✨ Features

Add and manage car details

Book a car

View available cars

Cancel a booking

REST API architecture

Clean Controller → Service → Repository structure

🧱 Tech Stack
Component	Technology
Backend Framework	Spring Boot
Database	MySQL / H2 Database
ORM	Hibernate / JPA
Build Tool	Maven
IDE	Eclipse / IntelliJ
📁 Project Structure
src
 ┣ controller
 ┣ service
 ┣ repository
 ┣ model
 ┗ dto

🚀 How to Run the Project

Clone the repository

git clone https://github.com/codeganesh452/Car-Booking-System


Open the project in Eclipse or IntelliJ

Update DB configuration in
src/main/resources/application.properties

Run the app using
Run → Spring Boot App

Access APIs at:

http://localhost:8080

📌 Sample API Endpoints
Method	Endpoint	Description
GET	/cars	Get all cars
POST	/cars	Add a car
POST	/book	Book a car
DELETE	/cancel/{id}	Cancel booking
🎯 Purpose

Built to practice:

Spring Boot fundamentals

CRUD operations

REST API development

Basic backend design
