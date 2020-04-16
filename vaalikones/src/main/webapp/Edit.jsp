<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import ="javax.persistence.PersistenceContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="persist.Ehdokkaat" %>
<%@page import="javax.persistence.EntityTransaction" %>
<%@page session="true"%>
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
        <title>Adding Candidate</title>
        <link href="style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <form>
                <Strong>Update:</Strong><br>
                Äänestysnumero:<br><input type="number" size ="3" name="id"/><br>
                Etunimi:<br><input type="text" maxlength="200" size="70" name="etunimi" value ="<%= one.getEtunimi()%>"/><br>
                Sukunimi:<br><input type="text" maxlength="200" size="70" name="sukunimi" value ="<%= one.getSukunimi()%>"/><br>
                Puolue:<br><input type="text" maxlength="200" size="70" name="puolue" value ="<%= one.getPuolue()%>"/><br>
                Kotipaikkakunta:<br><input type="text" maxlength="200" size="70" name="paikkakunta" value ="<%= one.getKotipaikkakunta()%>"/><br>
                Ikä:<br><input type="text" maxlength="200" size="70" name="ika" value ="<%= one.getIka()%>"/><br>
                Miksi eduskuntaan:<br><textarea rows="5" cols="60"> <%= one.getMiksiEduskuntaan()%></textarea><br>
                Mitä asioita haluat edistää?:<br><textarea rows="5" cols="60"><%= one.getMitaAsioitaHaluatEdistaa()%></textarea><br>
                Ammatti:<br><input type="text" maxlength="200" size="70" name="ammatti" value ="<%= one.getAmmatti()%>"/><br>
                <input type="submit" name="update" value="update" /><button><a href="CheckAdmin">Cancel</a></button><br>
                
            </form><br>
        
       
</body>
</html>