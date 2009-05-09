package test2.ejbs;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Named;
import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
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


@Stateless
@Local
@Named("dbinit")
public class DBInitBean implements DBInit {
	private static final Logger log = Logger.getLogger(DBInitBean.class.getName());

	@PersistenceContext
	protected EntityManager em;

	@Current
	protected UserTransaction ut;

	public DBInitBean (){};
	
	@Override
	public void initDB() {
		this.checkDBandInit();

	}
	
	@PostConstruct
	protected void postConstruct(){
		//nothing good
		@SuppressWarnings("unused")
		int f = 1+1;
	}
	
	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	protected void checkDBandInit()
	{
		log.log(Level.INFO, "starting checkDBandInit");
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
		} catch (Exception e){log.log(Level.SEVERE, "db init", e);}		
	}
}
