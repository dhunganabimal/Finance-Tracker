
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Report Dashboard</h3>
<input type="hidden" id="status" value="
<%
request.getAttribute("status");
%>
">
<form action="runservlet5" method="post">
    Check Income Report:
    <input type="submit" value="Income Report">

</form>
<br>
<form action="runservlet6">
    Check Expenditure Report:
    <input type="submit" value="Expenditure Report">
</form>
<br>
<form action="runservlet7">
    Check Saving Report:
    <input type="submit" value="Check Profit">
</form>
<script>
    var status = "${status}";
     if(status === "failed"){
        alert("Error Occured!");

    }
</script>
</body>
</html>
