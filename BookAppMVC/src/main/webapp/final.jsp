<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.bookapp.model.Book"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String msg = (String)request.getAttribute("message");
	
	/* Book book = (Book) request.getAttribute("book");

	String title = book.getTitle();
	out.print("Titiel:" + title + "<br>");

	String author = book.getAuthor();
	out.print("Author:" + author + "<br>");

	String category = book.getCategory();
	out.print("Category:" + category + "<br>");

	Integer bookId = book.getBookId();
	out.print("BookId " + bookId + "<br>");

	Double price = book.getPrice();
	out.print("Price " + price + "<br>"); */
	%>
	<%=msg %>
	<br>
	<h2>Expression language</h2>
	${message} <br>
	Title: ${book.title} <br>
	Price: ${book.price} <br>
	Author: ${book.author} <br>
	Category: ${book.category} <br>
</body>
</html>