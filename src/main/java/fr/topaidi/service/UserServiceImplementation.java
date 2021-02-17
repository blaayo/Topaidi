package fr.topaidi.service;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import com.sun.org.apache.xpath.internal.operations.Bool;

import fr.topaidi.dao.UserDao;
import fr.topaidi.dao.UserDaoImplementation;
import fr.topaidi.entite.Users;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class UserServiceImplementation implements UserService {
	
	@PersistenceContext
	private EntityManager em;
	
	@Resource
	private UserTransaction utx;

	public void addUser(Users user) {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDaoImplementation(em, utx);
		userDao.addUser(user);
	}

	public boolean verifUser(String email, String pass) {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDaoImplementation(em, utx);
		return userDao.verifUser(email, pass);
	}

	public Users getUser(int id) {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDaoImplementation(em, utx);
		return userDao.getUser(id);
	}

}