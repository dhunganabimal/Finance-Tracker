<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
    <%
        String name = (String) session.getAttribute("name");
        if (name != null) {
    %>
        <h2>Welcome, <%= name %>!</h2>
        <p>You have successfully logged in.</p>
    <p>Add Income Details
        <br><br>
        <a href="income.jsp"><button>Income</button></a></p>
    <p>Add Expenditure Details
        <br><br>
        <a href="exp.jsp"><button>Expenditure</button></a></p>

    <p> Check Report
        <br><br>
        <a  href="report.jsp"><button>Check Report</button></a></p>


        <a href="logout">Logout</a>
    <%
        } else {
            response.sendRedirect("login.jsp");
        }
    %>
</body>
</html>