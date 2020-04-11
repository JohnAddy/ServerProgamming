<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import ="javax.persistence.PersistenceContext"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="persist.Ehdokkaat" %>
<%@page session="true"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Adding Candidate</title>
        <link href="style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <%
       
        %>
        <div id="container">
            <img id="headerimg" src="Logo.png" width="720" />
            <h1>Add Candidate</h1>
            <%

                EntityManagerFactory emf=null;
                EntityManager em = null;
                try {

                }
                catch(Exception e) {


                  	return;
                }

            %>


            <form>
                <Strong>Add New:</Strong><br>
                Äänestysnumero:<br><input type="number" size ="3" name="id"/><br>
                Etunimi:<br><input type="text" maxlength="200" size="70" name="etunimi"/><br>
                Sukunimi:<br><input type="text" maxlength="200" size="70" name="sukunimi"/><br>
                Puolue:<br><input type="text" maxlength="200" size="70" name="puolue"/><br>
                Kotipaikkakunta:<br><input type="text" maxlength="200" size="70" name="paikkakunta"/><br>
                Ikä:<br><input type="text" maxlength="200" size="70" name="ika"/><br>
                Miksi eduskuntaan:<br><input type="text" maxlength="200" size="70" name="miksi"/><br>
                Mitä asioita haluat edistää?:<br><input type="text" maxlength="200" size="70" name="mita"/><br>
                Ammatti:<br><input type="text" maxlength="200" size="70" name="ammatti"/><br>
                <input type="submit" name="Add" value="Add" /><br>
            </form><br>

    </div>
</body>
</html>