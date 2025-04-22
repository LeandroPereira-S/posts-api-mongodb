A REST API built with Spring Boot and MongoDB for managing users and their posts. It supports full CRUD operations on users. This project was developed for learning and practicing backend development using modern technologies.

Tech Stack:

Java 17+
Spring Boot
Spring Data MongoDB
MongoDB
Maven

Features:

Create user
List all users
Get user by ID
Update user
Delete user
Link posts to users

Running the Project:
Clone the repository
Make sure MongoDB is running locally or configure it via MongoDB Atlas.
Edit the application.properties or application.yml with your MongoDB URI.

Run the project:
API will be available at: http://localhost:8080

Method	Endpoint	Action:

GET	/users	List all users
GET	/users/{id}	Get user by ID
POST /users	Create a new user
PUT	/users/{id}	Update a user
DELETE /users/{id}	Delete a user
