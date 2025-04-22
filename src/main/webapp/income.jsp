

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Income</title>
</head>
<body>
<h3>INCOME DASHBOARD</h3>
<input type="hidden" id="status" value="
<%
request.getAttribute("status");
%>
">
<form action="runservlet3" method="post">
Enter Date :
    <input type="date" name="idate">
    <br><br>
    Enter Time:
    <input type="time" name="itime">
    <br><br>
    Enter Income Source:
    <select name="isource" id="">
        <option value="Pocket Money"> Pocket Money</option>
        <option value="Other methods" >Other methods</option>
    </select>
    <br><br>
    Enter Amount:
    <input type="text" id="amt" name="iamount">
    <br><br>
    <input type="submit" value="Submit">
</form>
<script>
    var status = "${status}";
    if(status === "success"){
        alert("Income Data Updated Sucessfully");

    }
    else if(status === "failed"){
        alert("Enter valid values only!!!");

    }
</script>
</body>
</html>

