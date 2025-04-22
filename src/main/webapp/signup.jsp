<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<input type="hidden" id="status" value="
<%
request.getAttribute("status");
%>
">
<form action="runservlet1" method="post">
    <h2>Registration Page</h2>
    Enter Id:
    <input type="text" name="uid">
    <br><br>
    Enter Name:
    <input type="text" name="name" required>
    <br><br>
    Enter Email:
    <input type="text" name="email" required>
    <br><br>
    Enter Password:
    <input type="password" name="pass" required>
    <br><br>
    Enter Contact:
    <input type="text" name="contact">
    <br><br>
    <input type="submit" value="Register">
    <br><br>
    <p>I am already a member. <a href="login.jsp">Sign In</a></p>
</form>
<script>
    var status = "${status}";
    if(status === "success"){
        alert("Account Created Successfully!");

    }
    else if(status === "failed"){
        alert("Account Creation Failed!");

    }
</script>
</body>
</html>