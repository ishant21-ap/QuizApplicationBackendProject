Quiz Application
This backend quiz application, built using Spring Boot, Spring JPA, and MySQL, allows users to create, manage, and participate in quizzes. The application includes features for selecting random questions, creating quizzes based on user-defined criteria, submitting quiz responses, and calculating results.

Features
Add Questions: You can add multiple-choice questions with options and specify the correct answer. Questions are categorized and stored in the database.

Random Question Selection: The application allows the creation of quizzes with a specified number of questions, randomly selected based on a category provided by the user.

Quiz Creation: Users can create a quiz with:

A custom title.
A specified number of questions.
Questions filtered by category.
Quiz Participation:

Fetch the quiz by its unique ID, which presents the quiz questions to the user without revealing the correct answers.
Submit the quiz with user responses and receive the calculated result showing the number of correct answers.
Endpoints
1. Add a Question
URL: /question/add
Method: POST
Description: Adds a new question to the database.
Request Body: Requires the question title, multiple options, correct answer, and category.
2. Get All Questions
URL: /question/allQuestions
Method: GET
Description: Retrieves all questions stored in the database.
3. Get Questions by Category
URL: /question/category/{category}
Method: GET
Description: Fetches all questions under a specific category.
4. Delete a Question
URL: /question/delete/{id}
Method: DELETE
Description: Deletes a question from the database by its unique ID.
5. Update a Question
URL: /question/update/{id}
Method: PUT
Description: Updates an existing question with new details.
6. Create a Quiz
URL: /quiz/create
Method: POST
Description: Creates a new quiz with random questions based on the category and number of questions specified by the user.
Query Parameters:
Category (e.g., Java)
Number of questions
Quiz title
7. Get Quiz Questions
URL: /quiz/get/{id}
Method: GET
Description: Fetches the quiz questions for a specific quiz by its ID. The response includes the questions without the correct answers.
8. Submit Quiz
URL: /quiz/submit/{id}
Method: POST
Description: Submits the quiz responses and returns the number of correct answers.
Request Body: Requires the user's responses to each question.
Setup Instructions
Prerequisites
Java 11+
Maven
MySQL
Postman (optional, for testing)
Steps
Clone the repository from GitHub.
Set up a MySQL database.
Configure the application with the database credentials.
Use Maven to build and run the project.
Use Postman or any API testing tool to test the endpoints.
