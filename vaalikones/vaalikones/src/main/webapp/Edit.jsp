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
    Ã„Ã¤nestysnumero:<br><input type="number" size ="3" name="id"/><br>
    Etunimi:<br><input type="text" maxlength="200" size="70" name="etunimi" value ="<%= one.getEtunimi()%>"/><br>
    Sukunimi:<br><input type="text" maxlength="200" size="70" name="sukunimi" value ="<%= one.getSukunimi()%>"/><br>
    Puolue:<br><input type="text" maxlength="200" size="70" name="puolue" value ="<%= one.getPuolue()%>"/><br>
    Kotipaikkakunta:<br><input type="text" maxlength="200" size="70" name="paikkakunta" value ="<%= one.getKotipaikkakunta()%>"/><br>
    IkÃ¤:<br><input type="text" maxlength="200" size="70" name="ika" value ="<%= one.getIka()%>"/><br>
    Miksi eduskuntaan:<br><textarea rows="5" cols="60"> <%= one.getMiksiEduskuntaan()%></textarea><br>
    MitÃ¤ asioita haluat edistÃ¤Ã¤?:<br><textarea rows="5" cols="60"><%= one.getMitaAsioitaHaluatEdistaa()%></textarea><br>
    Ammatti:<br><input type="text" maxlength="200" size="70" name="ammatti" value ="<%= one.getAmmatti()%>"/><br>
    <input type="submit" name="update" value="update" /><button><a href="CheckAdmin">Cancel</a></button><br>

</form><br>

<%
    if (request.getParameter("update") != null) {
        try {
            //Retrieve the values set for the candidate from the text fields
            String id = request.getParameter("updateid");

            int i = Integer.parseInt(id);
            String etunimi = request.getParameter("etunimi");
            String sukunimi = request.getParameter("sukunimi");
            String puolue = request.getParameter("puolue");
            String paikka = request.getParameter("paikkakunta");
            String ika = request.getParameter("ika");
            int ik = Integer.parseInt(ika);
            String miksi = request.getParameter("miksi");
            String mita = request.getParameter("mita");
            String ammatti = request.getParameter("ammatti");

            one.setEtunimi(etunimi);
            one.setSukunimi(sukunimi);
            one.setPuolue(puolue);
            one.setKotipaikkakunta(paikka);
            one.setIka(ik);
            one.setMiksiEduskuntaan(miksi);
            one.setMitaAsioitaHaluatEdistaa(mita);
            one.setAmmatti(ammatti);

            Ehdokkaat e = em.find(Ehdokkaat.class, i);

            em.getTransaction().begin();
            e.setEhdokasId(candidatee);
            em.merge(e);
            em.getTransaction().commit();
            em.close();
            response.setHeader("Refresh", "0; http://localhost:8080/vaalikone/Edit.jsp");
            response.getWriter().print("Record Updated");
            //response.sendRedirect("Admin.jsp");
        } catch (Exception e) {
%> Something went wrong, check id.<%          }
}
%>



</body>
</html>