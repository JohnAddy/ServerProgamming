package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/greetme")
public class Greetings {
	@GET
	@Path("/sayhello")
	@Produces(MediaType.TEXT_HTML)
	public String sayHello(@QueryParam("name") String name,@QueryParam("city") String city) {
		return "<h2>Hello, "+name+" from  "+city+"!</h2>";

	}

}
