package rest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import data.Prey;

@Path("/hunterservice")
public class Hunterservice {
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Prey> readAllPrey() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("hunterapp");
		EntityManager em=emf.createEntityManager();
		
		List<Prey> list=em.createQuery("select a from Prey a").getResultList();
		return list;
	}
	
	@POST
	@Path("/addprey")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Prey postPrey(Prey prey) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("hunterapp");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(prey);
		em.getTransaction().commit();
		return prey;
	}
	@POST
	@Path("/addprey")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Prey postRiista(@FormParam("breed") String breed, @FormParam("weight") int wait) {
		Prey prey=new Prey(breed, wait);
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("hunterapp");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(prey);
		em.getTransaction().commit();
		return prey;
	}
}
