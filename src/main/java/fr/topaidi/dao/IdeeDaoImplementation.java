package fr.topaidi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import fr.topaidi.entite.Commentaires;
import fr.topaidi.entite.Idea;
import fr.topaidi.entite.Users;

public class IdeeDaoImplementation implements IdeeDao {
	
	private EntityManager em;
	private UserTransaction utx;
	
	public IdeeDaoImplementation (EntityManager em, UserTransaction utx) {
		this.em = em;
		this.utx = utx;
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
		// Ne fonctionne pas, la requete est bizzare !
		String sql = "SELECT i FROM Idea i group by i.id order by i.top DESC, SUM(i.top + i.flop) DESC, i.createdAt DESC";
		return em.createQuery(sql, Idea.class).getResultList();
	}
	
}