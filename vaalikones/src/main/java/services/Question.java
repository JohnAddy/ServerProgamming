package services;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import persist.Ehdokkaat;
import persist.Kysymykset;
import persist.Vastaukset;



@Path("/questions")
public class Question {
	
	private Ehdokkaat user;
	
	public Question(Ehdokkaat u) {
		user = u; 
	 }
	
	@SuppressWarnings("unchecked")
	public List<Kysymykset> All(){
		List<Kysymykset> all= new ArrayList<Kysymykset>();
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction transaction = null;
		try {
			emf = Persistence.createEntityManagerFactory("vaalikones");
			em = emf.createEntityManager();
			transaction = em.getTransaction();
			transaction.begin();

			Query qE = em.createNamedQuery("Kysymykset.findAll");
			all= (List<Kysymykset>) qE.getResultList();
			//System.out.println("here!");System.out.println(all);
			em.close();

		} catch (Exception e) {
			all= new ArrayList<Kysymykset>();
		}
		return all;
	}
	
	

	public Vastaukset Answer(Kysymykset quest) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction transaction = null;
		Vastaukset ans = null;
		try {
			emf = Persistence.createEntityManagerFactory("vaalikones");
			em = emf.createEntityManager();
			transaction = em.getTransaction();
			transaction.begin();

			Query qE = em.createNamedQuery("Vastaukset.findByUniqueID");
			qE.setParameter("ehdokasId", user.getEhdokasId());
			qE.setParameter("kysymysId", quest.getKysymysId());
			ans = (Vastaukset) qE.getSingleResult();
			//System.out.println("here!");System.out.println(all);
			em.close();

		} catch (Exception e) {
		
		}
		if(ans == null) {
			ans = new Vastaukset(user.getEhdokasId(), quest.getKysymysId());	
			
		}
		
		return ans;
		
	}

 

}

