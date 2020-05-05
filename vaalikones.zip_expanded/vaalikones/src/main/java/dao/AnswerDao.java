package dao;

 

import java.util.List;

 

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

 

import data.Answer;

 

public class AnswerDao {
    private static EntityManagerFactory emf;
    private static EntityManager getEntityManager() {
        if (emf==null) {
            emf=Persistence.createEntityManagerFactory("vaalikones");
        }
        return emf.createEntityManager();
    }
   
    public static void addAnswer(Answer answer) {
        EntityManager em=getEntityManager();
        em.getTransaction().begin();
        em.persist(answer);
        em.getTransaction().commit();
        em.close();
    }
   
    public static List<Answer> getAnswers(){
        EntityManager em=getEntityManager();
        List<Answer> list=em.createQuery("select a from Answer a").getResultList();
        em.close();
        return list;
    }

 

    public static boolean deleteAnswer(int id) {
        EntityManager em=getEntityManager();
        Answer b=em.find(Answer.class, id);
        if (b!=null) {
            em.getTransaction().begin();
            em.remove(b);
            em.getTransaction().commit();
            em.close();
            return true;
        }
        return false;
    }
    

 

    public static boolean updateAnswer(int id) {
        EntityManager em=getEntityManager();
        Answer b=em.find(Answer.class, id);
        if (b!=null) {
            em.getTransaction().begin();
            em.remove(b);
            em.getTransaction().commit();
            em.close();
            return true;
        }
        return false;
    }
}