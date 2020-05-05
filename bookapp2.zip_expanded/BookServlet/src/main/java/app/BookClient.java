package app;

import java.io.*;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import data.*;


/**
 * Servlet implementation class BookClient
 */
@WebServlet("/bookclient")
public class BookClient extends HttpServlet {
    private static final long serialVersionUID = 1L;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookClient() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
       
        String deleteId=request.getParameter("deleteId");
       
        //Including an HTML form + start of the html page
        RequestDispatcher rd=request.getRequestDispatcher("./bookform.html");
        rd.include(request,  response);
       
       
        // TODO Auto-generated method stub
        String uri = "http://127.0.0.1:8080/rest/bookservice/getall";

        Client asiakas=ClientBuilder.newClient();
        WebTarget wt=asiakas.target(uri);
        Builder b=wt.request();
       
        //Create a GenericType to be able to get List of objects
        //This will be the second parameter of post method
        GenericType<List<Book>> genericList = new GenericType<List<Book>>() {};
       
        //Posting data (Entity<ArrayList<DogBreed>> e) to the given address
        List<Book> returnedList=b.get(genericList);
       
        //And print the objects
        for (int i=0;i<returnedList.size();i++) {
            Book book=returnedList.get(i);
            book.setId(i);
            out.println(book+"<br>");
        }
       
        //Printing the end of an html document
        out.println("</body></html>");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String uri = "http://127.0.0.1:8080/rest/bookservice/addonebook";

        //A Book object to send to our web-service
        String name=request.getParameter("name");
        String pages=request.getParameter("pages");
        Book book=new Book(name, pages);
       
        Client c=ClientBuilder.newClient();
        WebTarget wt=c.target(uri);
        Builder b=wt.request();
        Entity<Book> e=Entity.entity(book,MediaType.APPLICATION_JSON);
       
        b.post(e);

       
        doGet(request, response);
    }

}