package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/greetings")
public class Greetings {


	@Path("/hello")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String say(){
		return "<h2>Hi There!</h2>";
	}	
		
		@Path("/hello")
		@GET
		@Produces(MediaType.TEXT_PLAIN)
		public String say1(){
			return "Hi There!";
}
}