<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<body>
<%
    String status = (String) request.getAttribute("status");
%>

<input type="hidden" id="status" value="<%= status %>">

<h2>Login</h2>
<form action="runservlet2" method="post">
    Enter Email:
    <input type="text" name="email" required>
    <br>
   Enter  Password:
    <input type="password" name="pass" required>
    <br>
    <input type="submit" value="Login">
    <br><br>
    <p>Create an account. <a href="signup.jsp">Sign Up</a></p>
</form>

<script>
    var status = document.getElementById("status").value;
    if(status === "failed"){
        alert("Login Failed. Check credentials or register first.");
    }
</script>
</body>
</html>
