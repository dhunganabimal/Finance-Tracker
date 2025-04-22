
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Expenditure</title>
</head>
<body>
<h3>EXPENDITURE DASHBOARD</h3>
<input type="hidden" id="status" value="
<%
request.getAttribute("status");
%>
">
<form action="runservlet4" method="post">
    Enter id :
    <input type="text" name="eid">
    <br><br>
    Enter Date :
    <input type="date" name="edate">
    <br><br>
    Enter Time:
    <input type="time" name="etime">
    <br><br>
    Enter Expenditure Source:
    <select name="esource" id="">
        <option value="Rent">Rent</option>
        <option value="Electricity" >Electricity</option>
        <option value="Wifi">Wifi</option>
        <option value="Food">Food</option>
        <option value="Clothing">Clothing</option>
    </select>
    <br><br>
    Enter Amount:
    <input type="text" id="amt" name="eamount">
    <br><br>
    <input type="submit" value="Submit">

    <p><a href="index.jsp">Home Page</a></p>
</form>
<script>
    var status = "${status}";
    if(status === "success"){
        alert("Expenditure Data Updated Sucessfully");

    }
    else if(status === "failed"){
        alert("Enter valid values only!!!");

    }
</script>
</body>
</html>
