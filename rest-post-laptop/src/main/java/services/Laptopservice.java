package services;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import app.Laptop;

@ Path("/laptopservice")
public class Laptopservice {
	
	@POST
	@Path("/showdata")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes("application/x-www-form-urlencoded")
	public String addData(@FormParam("brand") String brand,@FormParam("weight") float weight,@FormParam("price")float price) {
    return  "Brand: "+brand+" weight: "+weight+" price:"+price;
	}


//This method returns the DogBreed object as a JSON string
	//Conversion from DogBreed object is automatic, thanks to Jersey
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getlaptopbrand/{p1}") 
	public Laptop getlaptopbrand(@PathParam("p1") int number) {
		ArrayList<Laptop> list=getbrand();
		try {
			return list.get(number);
		}
		catch(IndexOutOfBoundsException e) {
			return null;
		}
	}

	//This method just creates a list, but in real application it were 
	//a method, which reads from a database
	private ArrayList<Laptop> getbrand() {
		// TODO Auto-generated method stub
		ArrayList<Laptop> list=new ArrayList<>();
		Laptop db=new Laptop(1, "toshiba",234,16);
		list.add(db);
		db=new Laptop(2, "Asus", 250,12);
		list.add(db);
		db=new Laptop(3, "Compaq", 100, 13);
		list.add(db);
		db=new Laptop(4, "HP", 500, 15);
		list.add(db);
		db=new Laptop(5, "Lenovo", 100, 23);
		list.add(db);
		db=new Laptop(6, "Dell", 350,17);
		list.add(db);
		db=new Laptop(7, "IBM", 200,19);
		list.add(db);
		return list;
	}
}