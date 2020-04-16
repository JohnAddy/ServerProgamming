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

String candidateID = request.getParameter("user");
Integer candidatee = Integer.parseInt(candidateID);

EntityManagerFactory emf = Persistence.createEntityManagerFactory("vaalikones");
EntityManager em = emf.createEntityManager();



Query qE = em.createQuery("SELECT e FROM Ehdokkaat e WHERE e.ehdokasId = :Ehdos").setParameter("Ehdos", candidatee);
List<Ehdokkaat> kaikkiEhdokkaat = qE.getResultList();
Ehdokkaat one = kaikkiEhdokkaat.get(0);

%>

<!DOCTYPE html>
<html>
<head>
        <title>Adding Candidate</title>
        <link href="style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <form method="POST">
                <Strong>Update:</Strong><br>
                Äänestysnumero:<br><input type="number" size ="3" name="user" value = "<%= one.getEhdokasId()%>"readonly/><br>
                Etunimi:<br><input type="text" maxlength="200" size="70" name="etunimi" value = "<%= one.getEtunimi()%>"/><br>
                Sukunimi:<br><input type="text" maxlength="200" size="70" name="sukunimi" value ="<%= one.getSukunimi()%>"/><br>
                Puolue:<br><input type="text" maxlength="200" size="70" name="puolue" value = "<%= one.getPuolue()%>"/><br>
                Kotipaikkakunta:<br><input type="text" maxlength="200" size="70" name="paikkakunta" value ="<%= one.getKotipaikkakunta()%>"/><br>
                Ikä:<br><input type="text" maxlength="200" size="70" name="ika" value ="<%= one.getIka()%>"/><br>
                Miksi eduskuntaan:<br><textarea rows="5" cols="60" name = "miksi"><%= one.getMiksiEduskuntaan()%></textarea><br>
                Mitä asioita haluat edistää?:<br><textarea rows="5" cols="60" name = "mita"><%= one.getMitaAsioitaHaluatEdistaa()%></textarea><br>
                Ammatti:<br><input type="text" maxlength="200" size="70" name="ammatti" value = "<%= one.getAmmatti()%>"/><br>
                <input type="submit" name="update" value="update" /><button><a href="Admin.jsp">Cancel</a></button><br>
                
            </form><br>
        <%
        if (request.getParameter("Update") != null) {
        	
            
        	try{
        		String id = request.getParameter("user");
        		
        		int i = Integer.parseInt(id);
        		
        		String lastName = request.getParameter("etunimi");
        		String firstName = request.getParameter("sukunimi");
        		String party = request.getParameter("puolue");
        		String from = request.getParameter("paikkakunta");
        		String age = request.getParameter("ika");
        		String why = request.getParameter("miksi");
        		String what = request.getParameter("mita");
        		String job = request.getParameter("ammatti");
        		int a = Integer.parseInt(age);
        		
        		Ehdokkaat eh= em.find(Ehdokkaat.class, i);	
        		if (one != null){
        		em.getTransaction().begin();
        		eh.setEtunimi(lastName);
        		eh.setSukunimi(firstName);
        		eh.setPuolue(party);
        		eh.setKotipaikkakunta(from);
        		eh.setIka(a);
        		eh.setMiksiEduskuntaan(why);
        		eh.setMitaAsioitaHaluatEdistaa(what);
        		eh.setAmmatti(job);
        		em.persist(one);
        		em.flush();
        		em.getTransaction().commit();
        		em.close();
                response.getWriter().print("Record Updated");
        		}
        		
        		
        		
        	
        	} catch(Exception er) {
        	  	  	
        	  	er.printStackTrace(response.getWriter());
        	  	
        	  	return;
        	}
        }
        %>
       
</body>
</html>