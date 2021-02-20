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
import fr.topaidi.entite.Idea;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class IdeeServiceImplementation implements IdeeService {

	@PersistenceContext
	private EntityManager em;
	
	@Resource
	private UserTransaction utx;

	public List<Idea> getListIdee() {
		IdeeDao ideeDao = new IdeeDaoImplementation(em, utx);
		return  ideeDao.getListIdee();
		
	}
	
	
}
