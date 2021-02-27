package fr.topaidi.service;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import fr.topaidi.dao.IdeeDao;
import fr.topaidi.dao.IdeeDaoImplementation;
import fr.topaidi.entite.Commentaires;
import fr.topaidi.entite.Idea;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class IdeeServiceImplementation implements IdeeService {

	@PersistenceContext
	private EntityManager em;
	
	@Resource
	private UserTransaction utx;

	public Idea getIdee(Long id) {
		IdeeDao ideeDao = new IdeeDaoImplementation(em, utx);
		return  ideeDao.getIdee(id);
	}
/*
	public List<Commentaires> getIdeaComments(Long id) {
		IdeeDao ideeDao = new IdeeDaoImplementation(em, utx);
		return  ideeDao.getIdeaComments(id);
	}
*/
	public List<Idea> getListIdee() {
		IdeeDao ideeDao = new IdeeDaoImplementation(em, utx);
		return  ideeDao.getListIdee();
		
	}

	public List<Idea> getIdeeClassement() {
		IdeeDao ideeDao = new IdeeDaoImplementation(em, utx);
		return  ideeDao.getIdeeClassement();
	}
	
}