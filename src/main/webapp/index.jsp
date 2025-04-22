<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
            background-color: #f0f2f5;
            min-height: 100vh;
            padding: 2rem;
        }

        .dashboard-container {
            max-width: 800px;
            margin: 0 auto;
        }

        .welcome-section {
            background-color: white;
            padding: 2rem;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            margin-bottom: 2rem;
            text-align: center;
        }

        h2 {
            color: #1a73e8;
            margin-bottom: 1rem;
            font-size: 1.8rem;
        }

        .card-container {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 1.5rem;
            margin-top: 2rem;
        }

        .card {
            background-color: white;
            padding: 1.5rem;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            text-align: center;
            transition: transform 0.3s ease;
        }

        .card:hover {
            transform: translateY(-5px);
        }

        .card p {
            color: #333;
            margin-bottom: 1rem;
            font-size: 1.1rem;
            font-weight: 500;
        }

        .btn {
            display: inline-block;
            padding: 0.75rem 1.5rem;
            background-color: #1a73e8;
            color: white;
            border: none;
            border-radius: 4px;
            font-size: 1rem;
            cursor: pointer;
            text-decoration: none;
            transition: background-color 0.3s;
            width: 100%;
        }

        .btn:hover {
            background-color: #1557b0;
        }

        .logout-section {
            text-align: center;
            margin-top: 2rem;
        }

        .logout-btn {
            display: inline-block;
            padding: 0.75rem 1.5rem;
            background-color: #dc3545;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            transition: background-color 0.3s;
        }

        .logout-btn:hover {
            background-color: #c82333;
        }

        @media (max-width: 768px) {
            body {
                padding: 1rem;
            }
            
            .card-container {
                grid-template-columns: 1fr;
            }
        }
    </style>
</head>
<body>
    <%
        String name = (String) session.getAttribute("name");
        if (name != null) {
    %>
    <div class="dashboard-container">
        <div class="welcome-section">
            <h2>Welcome, <%= name %>!</h2>
            <p>Manage your income and expenses efficiently</p>
        </div>

        <div class="card-container">
            <div class="card">
                <p>Add Income Details</p>
                <a href="income.jsp" class="btn">Income</a>
            </div>

            <div class="card">
                <p>Add Expenditure Details</p>
                <a href="exp.jsp" class="btn">Expenditure</a>
            </div>

            <div class="card">
                <p>View Financial Report</p>
                <a href="report.jsp" class="btn">Check Report</a>
            </div>
        </div>

        <div class="logout-section">
            <a href="logout" class="logout-btn">Logout</a>
        </div>
    </div>
    <%
        } else {
            response.sendRedirect("login.jsp");
        }
    %>
</body>
</html>