<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	</head>
	<body>
	<h1>Capgemini,Talwade,Pune</h1>
	
	${message}<!-- expression language -->
	<form action="http://localhost:8086/ServletJSP070_MVC/Authenticate.hr" method="post">
	User Name:<input type="text" name="userName"><br>
	Password:<input type="password" name="password"><br>
	<input type="submit" name="GO" value="submit">
	</form>
	</body>
</html>