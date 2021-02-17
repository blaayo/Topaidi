package fr.topaidi.dao;

import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.tools.javac.util.List;

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

	public boolean verifUser(String email, String pass) {
		// TODO Auto-generated method stub
		List<Users> user = (List<Users>) em.createQuery("select u from users u where u.email = :email ", Users.class).setParameter("email", email).getResultList();

        if ( user.isEmpty() ){
        	return true;
        } else {
        	return false;
        }
	}

	public Users getUser(int id) {
		return em.find(Users.class, id);
	}

}
