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

import fr.topaidi.entite.Users;

public class UserDaoImplementation implements UserDao {
	
	private EntityManager em;
	private UserTransaction utx;
	
	public UserDaoImplementation(EntityManager em, UserTransaction utx) {
		this.em = em;
		this.utx = utx;
	}

	public void addUser(Users user) {
		
		try {
			utx.begin();
			em.persist(user);
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

	public List<Users> getUserByEmailPass(String email, String pass) {
		// TODO Auto-generated method stub
		String sql   = "select u from Users u where u.email = :email And u.password = :pass ";		
		Query  query = em.createQuery(sql, Users.class);
		query.setParameter("email", email);
		query.setParameter("pass", pass);
		
		List<Users> user = (List<Users>) query.getResultList();
		return user;
	}

	public List<Users> getUserByEmail(String email) {
		// TODO Auto-generated method stub
		Query  query = em.createQuery("select u from Users u where u.email = :email", Users.class).setParameter("email", email);
		List<Users> user = (List<Users>) query.getResultList();		
		return user;
	}
	
	public Users getUser(int id) {
		return em.find(Users.class, id);
	}

}
