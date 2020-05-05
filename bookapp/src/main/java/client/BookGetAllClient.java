package client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;

import data.*;
import java.util.*;


public class BookGetAllClient {
	public static void main(String[] args) {
		String uri = "http://localhost:8080/rest/bookservice/getallbooks";
		Client client = ClientBuilder.newClient();
		//Create a new GenericType object
		GenericType<List<Book>> genericList = new GenericType<List<Book>>() {};
		
		//Read a list of DogBreed objects - here a short version 
		List<Book> list = client.target(uri).request().get(genericList);
		
		//Print the contents of the list
		System.out.println("All the Books");
		for (Book x:list){
			System.out.println(x);
		}
	}
}