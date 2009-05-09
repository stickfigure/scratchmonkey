package test;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.security.RolesAllowed;

public class EchoService implements Echo
{
	private static final Logger log = Logger.getLogger(EchoService.class.getName());

	@RolesAllowed("user")
	public String echo(String s)
	{
		log.log(Level.INFO,"Echoing: " + s);	
		return s;
	}
}
