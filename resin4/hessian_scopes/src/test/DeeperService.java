package test;

import java.util.logging.Logger;

import javax.context.ApplicationScoped;

@ApplicationScoped
public class DeeperService implements Deeper
{
	private static final Logger log = Logger.getLogger(DeeperService.class.getName());

	public String echo(String stuff)
	{
		String myId = super.toString().substring(super.toString().indexOf('@')+1);
		
		String result = stuff + myId;
		
		log.info("Deeper of " + stuff + " is " + result);
		
		return result;
	}
}
