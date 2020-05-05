package app;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;

public class Laptopclient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String uri = "http://localhost:8080/rest/laptopservice/getbrand/1";
	    
		Client c=ClientBuilder.newClient();
		WebTarget wt=c.target(uri);
		Builder b=wt.request();
		Laptop db=b.get(Laptop.class);
		String s=b.get(String.class);
		System.out.println("Object: "+db);
		System.out.println("JSON: "+s);
	}
}
	
