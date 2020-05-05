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

		while (true) {
			System.out.println("name: ");
			Scanner sc = new Scanner(System.in);
			String id = sc.nextLine();
			System.out.println("pages: ");
			Scanner sd = new Scanner(System.in);
			String page = sc.nextLine();

			if (id.length()==0) {
				break;
			} if (page.length()==0) {
				break;
			}else {
				System.out.println("name: " +id+ "  page: " + page);
			}

			Book book=new Book();
			book.setName(id);
			book.setPages(page);

			String uri = "http://127.0.0.1:8080/rest/bookservice/addonebook/1";

			Client c=ClientBuilder.newClient();
			WebTarget wt=c.target(uri);
			Builder b=wt.request();
			Book db=b.get(Book.class);
			String s=b.get(String.class);
			System.out.println("Object: "+db);
			System.out.println("JSON: "+s);
		}
	}
}