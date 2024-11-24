# TASKMANAGERAPP: ORGANIZE YOUR TASKS WITH EASE

TaskManagerApp is a web application designed to help users efficiently manage and organize their tasks. It allows you to create, track, and update tasks with options for filtering by priority, due date, and status. Whether you're managing personal projects or working as part of a team, TaskManagerApp simplifies task management.

---

## FEATURES

- CREATE, EDIT, AND DELETE TASKS.  
- VISUALIZE TASKS BY STATUS, PRIORITY, OR DUE DATE.  
- DYNAMIC AND RESPONSIVE DESIGN USING MODERN WEB TECHNOLOGIES.  
- BACKEND INTEGRATION FOR ROBUST DATA MANAGEMENT.

---

## TECHNOLOGIES USED

**BACKEND:**  
- JAVA: Main programming language for application logic.  
- SPRING BOOT: Framework for building the backend and connecting with the database.  
- MYSQL: Relational database to store tasks, users, and statuses.  

**FRONTEND:**  
- THYMELEAF: Template engine for generating dynamic HTML pages.  
- HTML5 & CSS3: Structuring and styling the interface.  
- BOOTSTRAP 5: For responsive and user-friendly design.  
- JAVASCRIPT: Enables interactive features and dynamic content.  

**OTHERS:**  
- GIT: Version control for collaborative development.

---

## REQUIREMENTS

BEFORE YOU START, MAKE SURE YOU HAVE:  
1. JAVA JDK (VERSION 11 OR HIGHER).  
2. MYSQL SERVER.  
3. AN IDE (E.G., INTELLIJ IDEA, ECLIPSE, OR VISUAL STUDIO CODE).  
4. GIT (TO CLONE THE REPOSITORY).

---

## SETUP INSTRUCTIONS

### STEP 1: CLONE THE REPOSITORY
Run the following commands in your terminal:
git clone https://github.com/your-username/TaskManagerApp.git
cd TaskManagerApp

### STEP 2: IMPORT THE DATABASE
1. OPEN PHPMYADMIN (OR ANY MYSQL CLIENT).  
2. CREATE A NEW DATABASE (E.G., `taskmanager`).  
3. IMPORT THE PROVIDED `taskmanager.sql` FILE LOCATED IN THE `/DATABASE` FOLDER.  

### STEP 3: CONFIGURE `APPLICATION.PROPERTIES`
1. NAVIGATE TO THE `SRC/MAIN/RESOURCES/` FOLDER.  
2. LOCATE THE FILE `APPLICATION.PROPERTIES`.  
3. UPDATE THE DATABASE CREDENTIALS AS FOLLOWS:
spring.datasource.url=jdbc:mysql://localhost:3306/taskmanager
spring.datasource.username=YOUR_MYSQL_USERNAME (root as usual)
spring.datasource.password=YOUR_MYSQL_PASSWORD (empty or whatever you want to)


### STEP 4: RUN THE APPLICATION
1. OPEN THE PROJECT IN YOUR PREFERRED IDE.  
2. INSTALL THE REQUIRED DEPENDENCIES (MAVEN WILL HANDLE THIS AUTOMATICALLY).  
3. RUN THE APPLICATION AS SPRINBOOT APP BY EXECUTING THE MAIN METHOD IN `TaskManagerAppApplication.java`.  

### STEP 5: ACCESS THE APPLICATION
Once the application starts, open your browser and go to:http://localhost:8091(that's the one I have put in application.properties, you can change it)  

---

HAPPY TASK MANAGEMENT! 😊

