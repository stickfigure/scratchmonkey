package test;

import java.util.logging.Logger;

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
	
	@GET
	public void yeah()
	{
		log.info("yeah()");
	}
}
