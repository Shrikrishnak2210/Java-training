<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setAttribute("message", "Great day");
	%>
	<c:set var="message" value="Great day" scope="request"></c:set>
	${message }
	<c:out value="${ message}"></c:out>
	<c:remove var="message"/>
	Hello ${message }
	<% ArrayList<String> courses = new ArrayList<>();
		courses.add("Java");
		courses.add("Spring");
		request.setAttribute("mycourses", courses);
	%>
	Using EL: ${ mycourses} <br>
	<c:forEach items="${mycourses}" var="course" step="2">
	${course } <br>
	</c:forEach>
</body>
</html>