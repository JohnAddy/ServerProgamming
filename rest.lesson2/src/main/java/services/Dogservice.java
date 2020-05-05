package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@ Path("/dogservice")
public class Dogservice {
	@GET
	@Path("/adddata")
	 @Produces(MediaType.TEXT_PLAIN)
	public String addData(@QueryParam("breed") String breed,@QueryParam("weight") float weight) {
return "Breed: "+breed+" weight: "+weight;
}
}