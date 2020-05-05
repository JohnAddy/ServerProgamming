package client;

import java.util.Scanner;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;

import data.Book;

public class BookClient {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String uri = "http://127.0.0.1:8080/rest/bookservice/getonebook/1";
	    
		Client c=ClientBuilder.newClient();
		WebTarget wt=c.target(uri);
		Builder b=wt.request();
		Book book=b.get(Book.class);
		String s=b.get(String.class);
		System.out.println("Object: "+book);
		System.out.println("JSON: "+s);
	}
	public static void main1(String[] args) {
		String uri = "http://127.0.0.1:8080/rest/bookservice/getonebook/1";
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
                System.out.println("Pages must be an integer!");
            }
        }
	}
	}


