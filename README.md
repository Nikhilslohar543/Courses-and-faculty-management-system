#Full Stack Project 

# Courses and faculty management system

## Overview

Effortlessly manage courses and faculty profiles with this intuitive web application. Assign faculty to courses, ensure secure access with role-based permissions, and seamlessly track daily attendance—all in one place!

## Features

- Course Management: Add, edit, delete, and view courses easily.
- Faculty Profiles: Manage faculty details, including personal information and assigned courses.
- Role-Based Access Control (RBAC): Secure access for admins and faculty with tailored permissions.
- Attendance Tracking: Record and monitor daily attendance.

## Technologies Used

- **Backend:**
  - Java
  - Spring Boot: 3.2.4
  - MySQL Database: Version 18 or compatible

- **Frontend:**
  - Angular : version 16

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


### Important tips

  - Create one user manually in database (this becomes an administrator that can handle all users such as admins/faculties).
  
  - Once an admin elevates a faculty member to an admin role, they cannot revoke or revert their access back to a faculty role. 

  - Therefore, the first user, who is created manually with admin rights, is essential for ensuring proper role management and system integrity.

  - The first user, created manually with administrative privileges, should be used only when absolutely necessary, such as reverting an admin role back to a faculty role.

  - If you want to assign courses to faculties then you need to add the courses first then assign faculties to it.

  - Remeber the courses will assign only to the faculty members not to admins.

### Contribution

  - Contributions are welcome! Feel free to fork the repository and create a pull request.
