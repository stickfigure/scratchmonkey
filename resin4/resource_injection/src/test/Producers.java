package test;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Current;
import javax.enterprise.inject.Produces;
import javax.mail.Session;
import javax.persistence.EntityManager;

import com.caucho.config.Name;

/**
 * Producers used for creating things with context. Yeah!
 * 
 * @author Scott Hernandez
 * @author Jeff Schnitzer
 */
@ApplicationScoped
public class Producers
{
	/** The JavaMail session that connects to the outbound mta */
	@Name("outbound")
	private Session mailSession;
	
	@Produces @Ours
	public Session getMailSession()
	{
		return this.mailSession;
	}

	@Produces @Ours 
	public static OurEntityManager getEntityManager(@Current EntityManager base)
	{
		return new OurEntityManager(base);
	}
}