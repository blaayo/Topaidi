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

import fr.topaidi.entite.Category;
import fr.topaidi.entite.Idea;
import fr.topaidi.entite.Users;

public class CategoriesDaoImplementation implements CategoriesDao {
	
	private EntityManager em;
	private UserTransaction utx;
	
	public CategoriesDaoImplementation(EntityManager em, UserTransaction utx) {
		this.em = em;
		this.utx = utx;
	}

	public void addCategories(Category categories) {
		
		try {
			utx.begin();
			em.persist(categories);
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

	
	public List<Category> getCategories() {
		return em.createQuery("SELECT c FROM Category c", Category.class).getResultList();
	}

}
