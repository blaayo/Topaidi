package fr.topaidi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import fr.topaidi.entite.Idea;

public class IdeeDaoImplementation implements IdeeDao {
	
	private EntityManager em;
	private UserTransaction utx;
	
	public IdeeDaoImplementation (EntityManager em, UserTransaction utx) {
		this.em = em;
		this.utx = utx;
	}
	
    public void AddIdee(Idea idee) {
		
		try {
			utx.begin();
			em.persist(idee);
			utx.commit();
		} catch (NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	public void addTop(Long id) {

		try {
			utx.begin();
		    Query query = em.createQuery("UPDATE Idea i SET i.top = i.top + 1 WHERE i.id = :id");
		    query.setParameter("id", id);
		    query.executeUpdate();
			utx.commit();
		} catch (NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void addFlop(Long id) {

		try {
			utx.begin();
		    Query query = em.createQuery("UPDATE Idea i SET i.flop = i.flop + 1 WHERE i.id = :id ");
		    query.setParameter("id", id);
		    query.executeUpdate();
			utx.commit();
		} catch (NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Idea getIdee(Long id) {
		return em.find(Idea.class, id);
	}
/*
	public List<Commentaires> getIdeaComments(Long id) {

		String sql = "select c from Commentaires c join users u on c.user_id join idea i on c.idea_id = :id";
		return em.createQuery(sql, Commentaires.class).setParameter("id", id).getResultList();
	}
*/
	public List<Idea> getListIdee() {
		return em.createQuery("SELECT i FROM Idea i", Idea.class).getResultList();
	}

	public List<Idea> getIdeeClassement() {
		String sql = "SELECT i FROM Idea i group by i.id order by i.top DESC, SUM(i.top + i.flop) DESC, i.createdAt DESC";
		return em.createQuery(sql, Idea.class).getResultList();
	}
	
}