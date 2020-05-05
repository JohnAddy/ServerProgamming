package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import persist.Ehdokkaat;
import persist.Kysymykset;

@Path("/Questionservices")
public class Questionservices {

	@Path("/getCandidate")
	@POST	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/x-www-form-urlencoded")
	public Ehdokkaat postCandidate(@FormParam ("User") int user) {
		System.out.println("user=" + user);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vaalikones");
		EntityManager em = emf.createEntityManager();
		Ehdokkaat e = em.find(Ehdokkaat.class, user);
		em.close();
		return e;
	}
	
	
	@Path("/getAll")
	@GET	
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<Kysymykset> getAll () {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vaalikones");
		EntityManager em = emf.createEntityManager();
		Query qE = em.createQuery("SELECT k FROM Kysymykset k");
		List<Kysymykset> kysymyksetList = qE.getResultList();
		em.close();
		return kysymyksetList;
	}
	
	
	
}
