package rest;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import data.Laptop;

@Path("/laptopservice")
public class Laptopservice {
	@Path("/showlaptop")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/x-www-form-urlencoded")
	 public Laptop showLaptop(@FormParam("brand")String brand,@FormParam("price") String price,@FormParam("weight") String weight) {
		
		Laptop laptop=new Laptop();
		laptop.setBrand(brand);
		laptop.setPrice(price);
		laptop.setWeight(weight);
		return laptop;
	}
	//This method returns the Laptop object as a JSON string
		//Conversion from DogBreed object is automatic, thanks to Jersey
		@POST
		@Produces(MediaType.APPLICATION_JSON)
		@Path("/getlaptop/{p1}") 
		public Laptop getlaptop(@PathParam("p1") int number) {
			ArrayList<Laptop> list=getLaptops();
			try {
				return list.get(number);
			}
			catch(IndexOutOfBoundsException e) {
				return null;
			}
		}

		//This method just creates a list, but in real application it were 
		//a method, which reads from a database
		private ArrayList<Laptop> getLaptops() {
			// TODO Auto-generated method stub
			ArrayList<Laptop> list=new ArrayList<>();
			Laptop db=new Laptop("APPLE",200,40);

			list.add(db);
			 db=new Laptop("olivert",200,40);
			list.add(db);
			 db=new Laptop("IBM",200,40);
			list.add(db);
			 db=new Laptop("TOSHIBA",200,40);
			list.add(db);
			 db=new Laptop("HP",200,40);
			list.add(db);
			 db=new Laptop("COMPAQ",200,40);
			list.add(db);
			 db=new Laptop("ASUS",200,40);
			list.add(db);
			return list;
		}

}
