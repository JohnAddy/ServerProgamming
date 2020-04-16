<%@page import="persist.Ehdokkaat"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.PersistenceContext"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="javax.persistence.EntityTransaction" %>
<%@page import="vaalikone.ViewPage"%>
<%@page session="true"%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	//ViewPage view = new ViewPage();
String candidateID = request.getParameter("user");
Integer candidatee = Integer.parseInt(candidateID);

EntityManagerFactory emf = null;
EntityManager em = null;
EntityTransaction transaction = null;
try {
	emf = Persistence.createEntityManagerFactory("vaalikones");
	em = emf.createEntityManager();
	transaction = em.getTransaction();
	transaction.begin();
} catch (Exception e) {
	response.getWriter().println("EMF+EM EI Onnistu");

	e.printStackTrace(response.getWriter());

	return;
}

Query qE = em.createQuery(
		
		"SELECT e FROM Ehdokkaat e WHERE e.ehdokasId = :Ehdos").setParameter("Ehdos", candidatee);
List<Ehdokkaat> kaikkiEhdokkaat = qE.getResultList();
Ehdokkaat one = kaikkiEhdokkaat.get(0);
// System.out.println(one.getEtunimi());
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href = "CheckAdmin">Back to list</a>
<form>
                <Strong>Update:</Strong><br>
                Äänestysnumero:<br><input type="number" size ="3" name="id"/><br>
                Etunimi:<br><input readonly type="text" maxlength="200" size="70" name="etunimi" value ="<%= one.getEtunimi()%>"/><br>
                Sukunimi:<br><input readonly type="text" maxlength="200" size="70" name="sukunimi" value ="<%= one.getSukunimi()%>"/><br>
                Puolue:<br><input readonly type="text" maxlength="200" size="70" name="puolue" value ="<%= one.getPuolue()%>"/><br>
                Kotipaikkakunta:<br><input readonly type="text" maxlength="200" size="70" name="paikkakunta" value ="<%= one.getKotipaikkakunta()%>"/><br>
                Ikä:<br><input readonly type="text" maxlength="200" size="70" name="ika" value ="<%= one.getIka()%>"/><br>
                Miksi eduskuntaan:<br><textarea readonly rows="5" cols="60"> <%= one.getMiksiEduskuntaan()%></textarea><br>
                Mitä asioita haluat edistää?:<br><textarea readonly rows="5" cols="60"><%= one.getMitaAsioitaHaluatEdistaa()%></textarea><br>
                Ammatti:<br><input readonly type="text" maxlength="200" size="70" name="ammatti" value ="<%= one.getAmmatti()%>"/><br>
               
            </form><br>




</body>
</html>