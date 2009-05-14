package test;

import java.security.Principal;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class EchoService implements Echo
{
	private static final Logger log = Logger.getLogger(EchoService.class.getName());

	@Resource SessionContext context;
	
	@RolesAllowed("user")
	public String echo(String s)
	{
		log.info("Echoing: " + s);
		
		Principal p = context.getCallerPrincipal();
		log.info("Caller principal is: " + p.getName());
		
		return s;
	}
}
