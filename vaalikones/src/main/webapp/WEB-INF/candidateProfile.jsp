<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="persist.Ehdokkaat"%>

<%
	Ehdokkaat user = (Ehdokkaat) session.getAttribute("user");

if (user == null) {
	response.sendRedirect("candidate.jsp");

}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Candidate Information</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>


</body>
</html>