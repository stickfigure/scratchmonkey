package test;

import java.util.logging.Logger;

import javax.inject.Current;
import javax.inject.manager.Manager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * 
 * @author Jeff Schnitzer <jeff@infohazard.org>
 */
@Path("/hello")
public class Hello
{
	private static final Logger log = Logger.getLogger(Hello.class.getName());
	
	@Current Manager man;
	
	@GET
	public int yeah()
	{
		log.info("yeah()");
		log.info("The manager is: " + man);
		
		return 1;
	}
}
