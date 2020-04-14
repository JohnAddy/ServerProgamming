<%@ page import="java.util.*" %>
<%@page import="persist.Ehdokkaat"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.PersistenceContext"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>

<%
	Object error = request.getAttribute("viesti");
%>

<%

/* EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
 EntityManager em = emf.createEntityManager();*/
EntityManagerFactory emf = null;
EntityManager em = null;
String name = request.getParameter("pid");

try {
	emf = Persistence.createEntityManagerFactory("vaalikones");
	em = emf.createEntityManager();
} catch (Exception e) {
	response.getWriter().println("EMF+EM EI Onnistu");

	e.printStackTrace(response.getWriter());

	return;
}
Query qE = em.createQuery("SELECT e FROM Ehdokkaat AS e WHERE e.etunimi='"+name+"' OR e.sukunimi='"+name+"'");
List<Ehdokkaat> ehdokasList = qE.getResultList();
%>

<!DOCTYPE html>
<html>
<head>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<script type="text/javascript">
    <%if (error != null) {%>
    var msg = "<%=error%>";
	alert(msg);
<%}%>
	
</script>
<body>

	<h3>
		<a href="Create.jsp">Add & Delete Candidate</a>
	</h3>

	

	<p>List of Searched Candidate:</p>

	<form method="post" name="frm" action="searchview.jsp">
      <table border="0" width="300" align="center">
        <tr><td colspan=2 style="font-size:12pt;" align="center">
        <h3>Search Candidate</h3></td></tr>
        
          <td><input  type="text" name="pid" id="pid" placeholder="Name">
        </td></tr>        
        <tr><td colspan=2 align="center">
        <input  type="submit" name="submit" value="Search"></td></tr>
      </table>
    </form>
		
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
				Ehdokkaat one = ehdokasList.get(i - 1);
			%>

			<tr>

				<td><a href="View.jsp?user=<%=one.getEhdokasId()%>">View</a> <a
					href="Edit.jsp?user=<%=one.getEhdokasId()%>">Edit</a></td>
				<td><%=one.getEhdokasId()%></td>
				<td><%=one.getEtunimi() + " " + one.getSukunimi()%></td>
				<td><%=one.getPuolue()%></td>
				<td><%=one.getKotipaikkakunta()%></td>
				<td><%=one.getIka()%></td>
				<%-- 					<td><%=ehdokasList.get(i - 1).getMiksiEduskuntaan()%></td> --%>
				<%-- 					<td><%=ehdokasList.get(i - 1).getMitaAsioitaHaluatEdistaa()%></td> --%>
				<td><%=one.getAmmatti()%></td>

			</tr>
			<%
				}
			%>
		</tbody>
	</table>

    </body>
</html>