package fr.topaidi.service;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import fr.topaidi.dao.CommentaireDao;
import fr.topaidi.dao.CommentaireDaoImplementation;
import fr.topaidi.dao.IdeeDao;
import fr.topaidi.dao.IdeeDaoImplementation;
import fr.topaidi.entite.Commentaires;
import fr.topaidi.entite.Idea;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class CommentaireServiceImplementation implements CommentaireService {
	
	@PersistenceContext
	private EntityManager em;
	
	@Resource
	private UserTransaction utx;

	public void addCommentaire(Commentaires comments) {
		CommentaireDao commentaireDao = new CommentaireDaoImplementation(em, utx);
		commentaireDao.addCommentaire(comments);
	}

	public List<Commentaires> getCommentsByIdea(Long IdIdea) {
		CommentaireDao commentaireDao = new CommentaireDaoImplementation(em, utx);
		IdeeDao ideaDao = new IdeeDaoImplementation(em, utx);
		Idea idea = ideaDao.getIdee(IdIdea);
		return commentaireDao.getCommentsByIdea(idea);
	}

}
