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
	
	<table>
		<thead>
			<tr>

				<th>Nimi</th>
				<th>Puolue</th>
				<th>Kotipaikkakunta</th>
				<th>Ika</th>
				<th>Ammatti</th>
				<th>Miksi eduskuntaan</th>
				<th>Mitä asioita haluat edistää?</th>

			</tr>
		</thead>

		<tbody>

			<tr>
				<td><%=user.getEtunimi() + " " + user.getSukunimi()%></td>
				<td><%=user.getPuolue()%></td>
				<td><%=user.getKotipaikkakunta()%></td>
				<td><%=user.getIka()%></td>
				<td><%=user.getAmmatti()%></td>
				<td><%=user.getMiksiEduskuntaan()%></td>
				<td><%=user.getMitaAsioitaHaluatEdistaa()%></td>
				
			
			</tr>


		</tbody>
	</table><br><br>
	<div id=editButton>
		<h2> <%=user.getEtunimi() + "! you may view and edit your choice of answers below."%></h2><br><br>
		<button id=buttonn><a href="Questions.jsp">Edit</a></button>
					
	</div>

</body>
</html>