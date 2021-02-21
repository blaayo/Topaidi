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
		return em.createQuery("SELECT i FROM Idea i", Idea.class).getResultList();
	}

	public List<Idea> getIdeeClassement() {
		// Ne fonctionne pas, la requete est bizzare !
		return em.createQuery("SELECT i FROM Idea i group by i.id order by i.top DESC, SUM(i.top + i.flop) DESC, i.createdAt DESC", Idea.class).getResultList();
	}
	
}