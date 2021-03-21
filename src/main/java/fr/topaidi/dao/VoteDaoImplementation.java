package fr.topaidi.dao;

import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import fr.topaidi.entite.Vote;

public class VoteDaoImplementation implements VoteDao {
	
	private EntityManager em;
	private UserTransaction utx;
	
	public VoteDaoImplementation(EntityManager em, UserTransaction utx) {
		this.em = em;
		this.utx = utx;
	}

	public void addVote(Vote vote) {
		
		try {
			utx.begin();
			em.persist(vote);
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

}
