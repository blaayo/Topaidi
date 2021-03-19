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

import fr.topaidi.entite.Commentaires;
import fr.topaidi.entite.Idea;

public class CommentaireDaoImplementation implements CommentaireDao {
	
	private EntityManager em;
	private UserTransaction utx;
	
	public CommentaireDaoImplementation(EntityManager em, UserTransaction utx) {
		this.em = em;
		this.utx = utx;
	}

	public void addCommentaire(Commentaires comments) {
		try {
			utx.begin();
			em.persist(comments);
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

	public List<Commentaires> getCommentsByIdea(Idea IdIdea) {
		/* Requete SQL */
		String sql   = "select c from Commentaires c where c.idea = :id ";
		Query  query = em.createQuery(sql, Commentaires.class);
		query.setParameter("id", IdIdea);
		
		List<Commentaires> commentaires = (List<Commentaires>) query.getResultList();
		return commentaires;
	}

}
