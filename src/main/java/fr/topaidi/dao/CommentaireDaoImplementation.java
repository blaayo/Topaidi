package fr.topaidi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import fr.topaidi.entite.Commentaires;
import fr.topaidi.entite.Idea;

public class CommentaireDaoImplementation implements CommentaireDao {
	
	private EntityManager em;
	private UserTransaction utx;
	
	public CommentaireDaoImplementation(EntityManager em, UserTransaction utx) {
		this.em = em;
		this.utx = utx;
	}

	public List<Commentaires> getCommentsByIdea(Idea IdIdea) {
		/* Requete SQL */
		String sql   = "select c from Commentaires c where c.idea = :id ";
		Query  query = em.createQuery(sql, Commentaires.class);
		query.setParameter("id", IdIdea);
		
		List<Commentaires> commentaires = (List<Commentaires>) query.getResultList();
		return commentaires;
	}

}
