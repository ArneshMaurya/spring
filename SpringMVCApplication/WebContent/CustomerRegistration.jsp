<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register here</title>
</head>
<body>
<sf:form action="Authenticate.obj" method="post" modelAttribute="customer">
<h2>Customer Registration Form</h2>
<table>

<tr><td>Enter first name:<sf:input type="text" path="firstName"></sf:input><sf:errors path="firstName"></sf:errors></td></tr>
<tr><td>Enter last name:<sf:input type="text" path="lastName"></sf:input><sf:errors path="lastName"></sf:errors></td></tr>
<tr><td>Enter age:<sf:input type="text" path="age"></sf:input><sf:errors path="age"></sf:errors></td></tr>
<tr><td>Enter last mobile number:<sf:input type="text" path="mobno"></sf:input><sf:errors path="mobno"></sf:errors></td></tr>
<tr><td>select city::<sf:select path="city">
<sf:option value="Pune">PUNE</sf:option>
<sf:option value="Mumbai">MUMBAI</sf:option>
<sf:option value="Delhi">DELHI</sf:option>
<sf:option value="Agra">AGRA</sf:option>

</sf:select><sf:errors path="city"></sf:errors></td></tr>
<tr><td><input type="submit" name="submit" value="go"></input>
</table>
</sf:form>
</body>
</html>