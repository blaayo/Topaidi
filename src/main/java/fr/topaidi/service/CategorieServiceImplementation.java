package fr.topaidi.service;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import com.sun.org.apache.xpath.internal.operations.Bool;

import fr.topaidi.dao.CategoriesDao;
import fr.topaidi.dao.CategoriesDaoImplementation;
import fr.topaidi.dao.UserDao;
import fr.topaidi.dao.UserDaoImplementation;
import fr.topaidi.entite.Category;
import fr.topaidi.entite.Users;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class CategorieServiceImplementation implements CategorieService {
	
	@PersistenceContext
	private EntityManager em;
	
	@Resource
	private UserTransaction utx;

	public void addCategories(Category categories) {
		// TODO Auto-generated method stub
		CategoriesDao cat = new CategoriesDaoImplementation(em, utx);
		cat.addCategories(categories);
	}

	public List<Category> getCategories(){
		// TODO Auto-generated method stub
		CategoriesDao cat = new CategoriesDaoImplementation(em, utx);
		return cat.getCategories();
	}



}