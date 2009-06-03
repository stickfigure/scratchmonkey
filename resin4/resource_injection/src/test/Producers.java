package test;

import javax.context.ApplicationScoped;
import javax.inject.Produces;
import javax.mail.Session;

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
	
	@Produces @OutboundMTA
	public Session getMailSession()
	{
		return this.mailSession;
	}
}