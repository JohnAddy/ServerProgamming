

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
<link href="style.css" rel="stylesheet" type="text/css">

</head>
<body>
<div class="formdiv">
<img id="headerimg" src="Logo.png" width="720" />

 
	 <!-- This is the form for Candidate to log in -->
	

		<form class="fomii" id="" action="#" method="POST" onsubmit='return false;'>

		 <br><h2>Sign-In</h2>
		<input id="Etunimi" type="text" name="Etunimi" placeholder="Etunimi"><br> 
		<input id="Sukunimi" type="Sukunimi" name="Sukunimi" placeholder="Sukunimi"> <br> 
		
		<input class="formbu" type="button" name="ok" value="Send" onclick="sendData();"><br>
	</form>
	
	</div>

</body>
</html>