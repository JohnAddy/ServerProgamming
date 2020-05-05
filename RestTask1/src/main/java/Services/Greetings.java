package Services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/greetings")
public class Greetings {
	
	  @Path("/hello")
	  
	  @GET
	  
	  @Produces(MediaType.TEXT_HTML) 
	  public String sayHello() { 
		  return "<h1>hello my rest services</h1>"; 
		  
	  }
	  
	  @Path("greetme")
		  public class Greetme{
			 
	 
	  @GET
		@Path("/sayhello")
		@Produces(MediaType.TEXT_HTML)
		public String sayHello(@QueryParam("name") String name,@QueryParam("city") String city) {
			return "<h2>Hello, "+name+" from  "+city+"!</h2>";

		}

	
		  }
}

