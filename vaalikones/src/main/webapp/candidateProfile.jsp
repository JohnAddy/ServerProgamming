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
	<h1>Candidate Information</h1>
	
	<table>
		<thead>
			<tr>

				<th>Nimi</th>
				<th>Puolue</th>
				<th>Kotipaikkakunta</th>
				<th>Ika</th>
				<th>Ammatti</th>

			</tr>
		</thead>

		<tbody>

			<tr>
				<td><%=user.getEtunimi() + " " + user.getSukunimi()%></td>
				<td><%=user.getPuolue()%></td>
				<td><%=user.getKotipaikkakunta()%></td>
				<td><%=user.getIka()%></td>
				<td><%=user.getAmmatti()%></td>
			
			</tr>


		</tbody>
	</table>
	<div>
		<button><a href="Questions.jsp">Edit Questions</a></button>
					
	</div>

</body>
</html>