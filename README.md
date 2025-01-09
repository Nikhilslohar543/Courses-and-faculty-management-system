#Full Stack Project 

# Courses and faculty management system

## Overview

Effortlessly manage courses and faculty profiles with this intuitive web application. Assign faculty to courses, ensure secure access with role-based permissions, and seamlessly track daily attendance—all in one place!

## Features

- Course Management: Add, edit, delete, and view courses easily.
- Faculty Profiles: Manage faculty details, including personal information and assigned courses.
- Role-Based Access Control (RBAC): Secure access for admins and faculty with tailored permissions.
- Attendance Tracking: Record and monitor daily attendance for courses.

## Technologies Used

- **Backend:**
  - Java: JDK 17 or higher
  - Spring Boot: 3.2.4
  - MySQL Database: Version 18 or compatible

- **Frontend:**
  - Angular CLI: 16.x or higher

- **General Tools**
  - IDE for Backend: IntelliJ IDEA, Eclipse, or any preferred Java IDE.
  - IDE for Frontend: Visual Studio Code or similar.
  - Git: For cloning the repository.
  - MySQL Workbench: For database management (optional).


## Installation

- **Step 1: Clone the Repository**
  ```
  git clone https://github.com/<your-username>/courses-and-faculty-management-system.git
  cd courses-and-faculty-management-system  
  ```

- **Step 2: Backend Setup**
  - 1. Navigate to the backend folder:
       ```
       cd SpringBootProj
       ```
  - 2. Open the project in your preferred IDE.
  - 3. Configure the application.properties file:
       ```
        spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name  
        spring.datasource.username=your_username  
        spring.datasource.password=your_password  
        spring.jpa.hibernate.ddl-auto=update  
       ```
  - 4. Run the backend using your IDE or with the following command:
       ```
       ./mvnw spring-boot:run  
       ```

- **Step 3: Frontend Setup**
  - 1. Navigate to the frontend folder:
       ```
       cd SpringBootProj-frontend
       ```
  - 2. Install dependencies:
       ```
       npm install  
       ```
  - 3. Run the Angular application:
       ```
       ng serve  
       ```
  - 4. Open the application in your browser at http://localhost:4200.

### Contribution

  - Contributions are welcome! Feel free to fork the repository and create a pull request.
