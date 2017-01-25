<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="quote" class="edu.ap.student.Quote" scope="session"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Zoek Quote</title>
</head>
<body>

All Quotes:<br>
<%= Quote.getAllQuotes() %>

<form method="POST" action="Result.jsp">

Woord: <input type ="TEXT" name = "text"><br>
<input type = SUBMIT value = "Zoek Quote">

</form>

</body>
</html>