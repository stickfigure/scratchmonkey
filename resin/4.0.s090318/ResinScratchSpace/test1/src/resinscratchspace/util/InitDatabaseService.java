package resinscratchspace.util;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Current;
import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.transaction.*;

import resinscratchspace.entities.User;

import com.caucho.config.Service;

@NamedQueries({
	@NamedQuery(name="AllUsers", query="select u from User u"),
	@NamedQuery(name="AllLogEntries", query="select ule from UserLogEntry ule")
})

@Service
public class InitDatabaseService {
	private static final Logger log = Logger.getLogger(InitDatabaseService.class.getName());


	@Current private EntityManager em;
	@Current private UserTransaction ut;
	
	@SuppressWarnings({ "unused", "unchecked" })
	@PostConstruct
	private void postConstruct()
	{
		log.log(Level.INFO,"Checking and adding test data.");
		Query q = em.createQuery("select u from User u");
//		log.log(Level.INFO,"Got NamedQuery:AllUsers");
		log.log(Level.INFO,"Got Query for User(s)");
		
		List<User> users = (List<User>)q.getResultList();
		
		if(users.size()==0){
			log.log(Level.INFO,"Empty User table, filling with test records...");
			try {
				ut.begin();
				log.log(Level.INFO,"Transaction begun.");
				em.persist(new User("scotthernandez@hotmail.com","test", "Scott Hernandez", "Scott"));
				em.persist(new User("jeff@infohazard.org","test", "Jeff Schnitzer", "Jeff"));
				ut.commit();
				log.log(Level.INFO,"Commited!");
			} catch (NotSupportedException e) {
				log.log(Level.SEVERE,e.getStackTrace().toString());
			} catch (SystemException e) {
				log.log(Level.SEVERE,e.getStackTrace().toString());
			} catch (IllegalStateException e) {
				log.log(Level.SEVERE,e.getStackTrace().toString());
			} catch (SecurityException e) {
				log.log(Level.SEVERE,e.getStackTrace().toString());
			} catch (RollbackException e) {
				log.log(Level.SEVERE,e.getStackTrace().toString());
			} catch (HeuristicMixedException e) {
				log.log(Level.SEVERE,e.getStackTrace().toString());
			} catch (HeuristicRollbackException e) {
				log.log(Level.SEVERE,e.getStackTrace().toString());
			}
		}
	}
	@SuppressWarnings("unused")
	@PreDestroy
	private void preDestroy()
	{
	}
}
