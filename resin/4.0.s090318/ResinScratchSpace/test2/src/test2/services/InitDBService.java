package test2.services;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Current;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import test2.entities.Category;

import com.caucho.config.Service;

@Service
public class InitDBService {
	private static final Logger log = Logger.getLogger(InitDBService.class
			.getName());

	@Current
	private EntityManager em;
//
//	@Current
//	private UserTransaction ut;

	@SuppressWarnings("unchecked")
	@PostConstruct
	protected void postConstruct() {
		log.log(Level.INFO, "Starting InitDBService");
		try {
			//ut.begin();
//			em.getTransaction().begin();
			if(em == null) throw new RuntimeException("No EntityManager Injected");
			Query q = em.createQuery("select c from Category c");
			log.log(Level.INFO, "Got Query for Category(c)");

			List<Category> cats = (List<Category>) q.getResultList();

			if (cats.size() == 0) {
				log.log(Level.INFO,
						"Empty Category table, filling with test records...");
				log.log(Level.INFO, "Transaction begun.");
				em.persist(new Category("House Items"));
				em.persist(new Category("Electronics"));
				em.persist(new Category("Toys"));
				em.persist(new Category("Crackers"));
//				em.getTransaction().commit();
//				ut.commit();
				log.log(Level.INFO, "Commited!");
			}
//		} catch (NotSupportedException e) {
//			log.log(Level.SEVERE,  "db init", e);
//		} catch (SystemException e) {
//			log.log(Level.SEVERE,  "db init", e);
//		} catch (IllegalStateException e) {
//			log.log(Level.SEVERE, "db init", e);
//		} catch (SecurityException e) {
//			log.log(Level.SEVERE, "db init", e);
//		} catch (RollbackException e) {
//			log.log(Level.SEVERE,  "db init", e);
//		} catch (HeuristicMixedException e) {
//			log.log(Level.SEVERE,  "db init", e);
//		} catch (HeuristicRollbackException e) {
//			log.log(Level.SEVERE,  "db init", e);
//		}
		}catch (Exception e){log.log(Level.SEVERE, "db init", e);}
	}
}
