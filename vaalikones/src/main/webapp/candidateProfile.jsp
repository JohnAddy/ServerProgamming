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
 <img id="headerimg" src="Logo.png" width="720" /><br>
	<br><h1>Welcome <%=user.getEtunimi() + "!"%></h1><br><br><br>

	<div id=editButton>
		<h2> <%=user.getEtunimi() + "! you may view and edit your choice of answers below."%></h2><br><br>
		<button id=buttonn><a href="Questions.jsp">Edit</a></button>
					
	</div>

</body>
</html>