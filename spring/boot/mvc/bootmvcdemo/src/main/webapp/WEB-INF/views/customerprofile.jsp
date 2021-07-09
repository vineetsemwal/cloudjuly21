<%@ page language="java" contentType="text/html" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<body>

<h1> Profile information</h1>


Id is <c:out value= "${customer.id}" />

Name is <c:out value= "${customer.name}" />


</body>


</html>


