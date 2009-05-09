package test2.services;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Current;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import test2.entities.Category;

//@Service
public class InitDBService {
	private static final Logger log = Logger.getLogger(InitDBService.class.getName());
	
	@PersistenceContext(unitName="hbm")
	protected EntityManager em;
	
	@Current
	protected UserTransaction ut;
	
//	@PostConstruct
	public void start()
	{
		log.log(Level.INFO, "start() called!");
		try {
			initDB();
		} catch (Exception e){			
			log.log(Level.SEVERE,"bad", e);
		}
	}
	
	@SuppressWarnings("unchecked")
	protected void initDB(){
		log.log(Level.INFO, "starting initDB");
		try {
			Query q = em.createQuery("select c from Category c");
			log.log(Level.INFO, "Got Query for Category(c)");

			List<Category> cats = (List<Category>) q.getResultList();
			log.log(Level.SEVERE, "Category has size of " + cats.size());

			if (cats.size() == 0) {
				log.log(Level.INFO,
						"Empty Category table, filling with test records...");
				log.log(Level.INFO, "Transaction begun.");
				ut.begin();
				em.persist(new Category("House Items"));
				em.persist(new Category("Electronics"));
				em.persist(new Category("Toys"));
				em.persist(new Category("Crackers"));
				ut.commit();
				log.log(Level.INFO, "Commited!");
			}
		} catch (NotSupportedException e) {
			log.log(Level.SEVERE,  "db init", e);
		} catch (SystemException e) {
			log.log(Level.SEVERE,  "db init", e);
		} catch (IllegalStateException e) {
			log.log(Level.SEVERE, "db init", e);
		} catch (SecurityException e) {
			log.log(Level.SEVERE, "db init", e);
		} catch (RollbackException e) {
			log.log(Level.SEVERE,  "db init", e);
		} catch (HeuristicMixedException e) {
			log.log(Level.SEVERE,  "db init", e);
		} catch (HeuristicRollbackException e) {
			log.log(Level.SEVERE,  "db init", e);
		} catch (Exception e)
		{
			log.log(Level.SEVERE, "db init", e);
		}
	}
}