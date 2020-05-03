

<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@ page import="java.io.IOException"%>
<%@page session="true"%>

<%@page import="persist.Ehdokkaat"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<%
	Ehdokkaat user = (Ehdokkaat) session.getAttribute("user");

if (user != null) {
	response.sendRedirect("candidateProfile.jsp");

}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Candidate Sign-In</title>
<script type="text/javascript" src ="candidatescript.js"></script>
</head>
<body>

	<p>Candidate Sign-In
	<p>

		<form id="" action="#" method="POST" onsubmit='return false;'>

		<input id="Etunimi" type="text" name="Etunimi" placeholder="Etunimi"><br> 
		<input id="Sukunimi" type="Sukunimi" name="Sukunimi" placeholder="Sukunimi"> <br> 
		
		<input type="button" name="ok" value="Send" onclick="sendData();"><br>
	</form>
	
	<!-- <form action="./rest/candidateService/login" method='post'>
		<input id="Etunimi" type="text" name="Etunimi" placeholder="Etunimi"><br>
		<input id="Sukunimi" type="Sukunimi" name="Sukunimi"
			placeholder="Sukunimi"> <br> <input id="Ika" type="Ika"
			name="Ika" placeholder="Ika"><br> <input type='submit'
			name='ok' value='Send'><br>
	</form> -->

</body>
</html>