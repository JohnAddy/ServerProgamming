package client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import data.Laptop;

/**
 * @author BALLY
 *
 */
public class Laptopclient {

	public static void main(String[] args) { // TODO Auto-generated method stub
		String uri = "http://127.0.0.1:8080/rest/laptopservice/getlaptop/1";

		Client c=ClientBuilder.newClient(); 
		WebTarget wt=c.target(uri); Builder
		b=wt.request(); 
		Laptop db=b.get(Laptop.class); 
		String s=b.get(String.class);
		System.out.println("Object: "+db); 
		System.out.println("JSON: "+s); }


	/*
	 * public static void main(String[] args) { // TODO Auto-generated method stub
	 * String uri = "http://127.0.0.1:8080/rest/laptopservice/all"; Client
	 * c=ClientBuilder.newClient(); //Create a new GenericType object
	 * GenericType<List<Laptop>> genericList = new GenericType<List<Laptop>>() {};
	 * 
	 * WebTarget wt=c.target(uri); Builder b=wt.request();
	 * 
	 * // Read a list of Laptop Objects - here a short version List<Laptop> list =
	 * b.get(genericList);
	 * 
	 * //List<Laptop> list = client.target(uri).request().get(genericList);
	 * 
	 * // Print the contents of the list System.out.println("All the Laptops"); for
	 * (Laptop x:list) { System.out.println(x); }
	 * 
	 * }
	 */
}
