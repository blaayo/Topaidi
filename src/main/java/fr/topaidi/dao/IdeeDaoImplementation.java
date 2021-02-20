package fr.topaidi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import fr.topaidi.entite.Idea;

public class IdeeDaoImplementation implements IdeeDao {
	
	private EntityManager em;
	private UserTransaction utx;
	
	public IdeeDaoImplementation (EntityManager em, UserTransaction utx) {
		this.em = em;
		this.utx = utx;
	}

	public List<Idea> getListIdee() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT i FROM Idea i", Idea.class).getResultList();
	}

	public List<Idea> getIdeeClassement() {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT i FROM Idea i", Idea.class).getResultList();
	}
	
	
}
