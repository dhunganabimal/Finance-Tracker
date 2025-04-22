# Personal Finance Tracker Web Application

## Overview
A web-based personal finance management system that helps users track their income and expenditures. The application provides secure user authentication and separate dashboards for managing income and expenses.

## Features

### Current Features
- **User Authentication**
    - User Registration with email verification
    - Secure Login/Logout functionality
    - Password security measures

- **User Dashboard**
    - Welcome page after successful login
    - Navigation to Income and Expenditure sections
    - User session management

### Upcoming Features (In Development)
- **Income Management**
    - Add income entries
    - Categorize income sources
    - View income history
    - Generate income reports

- **Expenditure Tracking**
    - Record daily expenses
    - Categorize expenses
    - Set budget limits
    - Expense analytics

- **Reports and Analytics**
    - Monthly summary
    - Category-wise analysis
    - Visual representations (charts/graphs)
    - Downloadable reports

## Technology Stack

### Backend
- Java Servlets
- MySQL Database
- Apache Tomcat Server

### Frontend
- JSP (JavaServer Pages)
- HTML/CSS
- JavaScript
- Bootstrap (planned)

### Dependencies
- MySQL Connector
- Servlet API


## Database Structure

### Current Tables
- `loginData`
    - User authentication information
    - Personal details

### Planned Tables
- `income_transactions`
- `expenditure_transactions`
- `categories`

## Setup Instructions

### Prerequisites
- JDK 11 or higher
- Apache Tomcat 9
- MySQL 8.0
- Maven

### Installation Steps
1. Clone the repository
   ```bash
   git clone https://github.com/dhunganabimal/Finance-Tracker
   ```

2. Configure MySQL Database
   ```sql
   CREATE DATABASE login_db;
   USE login_db;
   
   CREATE TABLE loginData (
   id INT NOT NULL,
       name VARCHAR(255) NOT NULL,
       email VARCHAR(255) NOT NULL UNIQUE,
       pass VARCHAR(255) NOT NULL,
       contact VARCHAR(20)
   );
   ```

3. Update Database Configuration
    - Open `LoginServlet.java` and `RegistrationServlet.java`
    - Update database credentials if necessary:
      ```java
      String url = "jdbc:mysql://localhost/login_db?useSSL=false";
      String user = "your_username";
      String pass = "your_password";
      ```

4. Build the Project
   ```bash
   mvn clean install
   ```

5. Deploy to Tomcat
    - Copy the generated WAR file to Tomcat's webapps directory
    - Start Tomcat server



## Current Status
- ✅ User Authentication System
- ⏳ Income Dashboard (In Progress)
- ⏳ Expenditure Dashboard (In Progress)
- 📋 Reports and Analytics (Planned)

## Future Enhancements
1. Mobile-responsive design
2. Email notifications for budget alerts
3. PDF report generation
4. Data export functionality
5. Multi-currency support

## Contributing
This project is currently in development. Contributions, suggestions, and feedback are welcome.




**Note**: This project is under active development. The UI work is not even started yet !!! So, feel free to Contribute.
