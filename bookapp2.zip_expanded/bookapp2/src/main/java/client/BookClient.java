package client;

import java.util.List;
import java.util.Scanner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import data.Book;

public class BookClient {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String uri = "http://127.0.0.1:8080/rest/bookservice/addonebook";

        //A Book object to send to our web-service
        Book book=readBook();
        Client c=ClientBuilder.newClient();
        WebTarget wt=c.target(uri);
        Builder b=wt.request();
        //Here we create an Entity of a Book object as JSON string format
        Entity<Book> e=Entity.entity(book,MediaType.APPLICATION_JSON);
       
        //Create a GenericType to be able to get List of objects
        //This will be the second parameter of post method
        GenericType<List<Book>> genericList = new GenericType<List<Book>>() {};
        List<Book> list=b.post(e, genericList);
        for (Book bk:list) {
            System.out.println(bk);
        }   
    }

    private static Book readBook() {
        // TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
        String name=null;
        int pages=-1;
        while (true) {
            System.out.print("Name: ");
            name=sc.nextLine();
            if (name.length()>0) {
                break;
            }
        }
        while (true) {
            System.out.print("Pages: ");
            String s=sc.nextLine();
            try {
                pages=Integer.parseInt(s);
                break;
            }
            catch(NumberFormatException e) {
                System.out.println("Pages must be an numbers!");
            }
        }
        Book book=new Book(name, pages);
        return book;
    }
}