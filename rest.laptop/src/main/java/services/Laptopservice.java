package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@ Path("/laptopservice")
public class Laptopservice {
	@GET
	@Path("/showdata")
	@Produces(MediaType.TEXT_PLAIN)
	public String addData(@QueryParam("brand") String brand,@QueryParam("weight") float weight,@QueryParam("price")float price) {
    return  "Brand: "+brand+" weight: "+weight+" price:"+price;
	}
}
