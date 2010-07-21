package test;

import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

@Named("echoer")
@ApplicationScoped
public class EchoBean implements Echo
{
	private static final Logger log = Logger.getLogger(EchoBean.class.getName());
	
	/** */
	@Inject EntityManager em;
	
	/** */
	public EchoBean()
	{
		log.info("Constructor");
	}

	/** */
	public String echo(String s)
	{
		log.info("Echoing: " + s);
		log.info("em is " + em);
		
		return s.toUpperCase();
	}
}
