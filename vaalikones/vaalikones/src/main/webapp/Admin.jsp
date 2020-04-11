
<!DOCTYPE html>
<html>
<head>
  <link href="style.css" rel="stylesheet" type="text/css">
</head>
<script type="text/javascript">
    <% if (error != null){    %>
    var msg = "<%=error%>";
        alert(msg);
        <% }%>
    </script>
<body>
	
		<h3><a href="Create.jsp">Add & Delete Candidate</a></h3>
		 
		<p>List of Existing Candidate:</p>
		<table>
		
			<thead>
				<tr>
				
					<th>View</th>
					<th>Id</th>
					<th>Nimi</th>
					<th>Puolue</th>
					<th>Kotipaikkakunta</th>
					<th>Ika</th>
<!-- 				<th>Miksi</th> -->
<!-- 				<th>Mita</th> -->
					<th>Ammatti</th>
					
				</tr>
			</thead>
			<tbody>
				<%
				
					// List all candidate on the machine
					for (int i = 1; i <= ehdokasList.size(); i++) {
						Ehdokkaat one = ehdokasList.get(i-1);
                    %>
                    
				<tr>
				
				<td><a href = "View.jsp?user=<%=one.getEhdokasId()%>">View</a> <a href = "Edit.jsp?user=<%=one.getEhdokasId()%>">Edit</a></td>
					<td><%=one.getEhdokasId()%></td>
					<td><%=one.getEtunimi() + " " +one.getSukunimi()%></td>
					<td><%=one.getPuolue()%></td>
					<td><%=one.getKotipaikkakunta()%></td>
					<td><%=one.getIka()%></td>
<%-- 					<td><%=ehdokasList.get(i - 1).getMiksiEduskuntaan()%></td> --%>
<%-- 					<td><%=ehdokasList.get(i - 1).getMitaAsioitaHaluatEdistaa()%></td> --%>
					<td><%=one.getAmmatti()%></td>
					
				</tr>
				<%}%> 
			</tbody>
			</table>
			
		
		
		
		
		<h3><a href="View.jsp">ViewList</a></h3>

	</div>
</body>
</html>