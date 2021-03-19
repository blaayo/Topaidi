package fr.topaidi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import fr.topaidi.entite.Commentaires;

public class CommentaireDaoImplementation implements CommentaireDao {
	
	private EntityManager em;
	private UserTransaction utx;
	
	public CommentaireDaoImplementation(EntityManager em, UserTransaction utx) {
		this.em = em;
		this.utx = utx;
	}

	public List<Commentaires> getCommentsByIdea(Long IdIdea) {
		/* Requete SQL */
		String sql   = "select c from Commentaires c where c.idea_id = :id ";
		Query  query = em.createQuery(sql, Commentaires.class);
		query.setParameter("id", IdIdea);
		
		List<Commentaires> commentaires = (List<Commentaires>) query.getResultList();
		return commentaires;
	}

}
