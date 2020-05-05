package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/greetings")

public class Greetings {
	@Path("/Hello")
	@GET
	@Produces(MediaType.TEXT_HTML)
	
	public String sayHello1(){ 
	
	return "<h1>Hello My Rest Service!</h1>";
	

}
}