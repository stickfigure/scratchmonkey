package test;

import java.util.logging.Logger;

import javax.ejb.Stateless;

@Stateless
public class EchoService implements Echo
{
	private static final Logger log = Logger.getLogger(EchoService.class.getName());

	public String echo(String stuff)
	{
		log.info("Echoing: " + stuff);
		
		return stuff;
	}
}
