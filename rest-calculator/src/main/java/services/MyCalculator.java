  package services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/mycalculator")
public class MyCalculator {
	@Path("/sum/{a1}/{a2}")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String calcSum(@PathParam("a1")int opera1,@PathParam("a2")int opera2) {
		return "<h1>Sum:"+(opera1+opera2)+"</h1>";
		
	}
	
	@Path("/sub/{a1}/{a2}")
	@GET
	@Produces(MediaType.TEXT_HTML)
	
	public String calcSub(@PathParam("a1")int opera1,@PathParam("a2")int opera2) {
		return "<h1>Sub:"+(opera1-opera2)+"</h1>";
		
	}
	@Path("/mul/{a1}/{a2}")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String calcMul(@PathParam("a1")int opera1,@PathParam("a2")int opera2) {
		return "<h1>Mul:"+(opera1*opera2)+"</h1>";
		
	}
	@Path("/div/{a1}%2F{a2}")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String calcDiv(@PathParam("a1")int opera1,@PathParam("a2")int opera2) {
		return "<h1>Div:"+(opera1/opera2)+"</h1>";
		
	}
	
	@Path("/calc/{a1}/{a}/{a2}")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String myCalc(@PathParam("a1")int opera1,@PathParam("a")int opera,@PathParam("a2")int opera2) {
		return "<h1>Calc:"+(opera1+opera-opera2)+"</h1>";
}
}
