package test;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Current;

@Stateless
public class EchoService implements Echo
{
	private static final Logger log = Logger.getLogger(EchoService.class.getName());
	
	@Current Deeper deep;

	public String echo(String stuff)
	{
		log.info("Echoing: " + stuff);
		
		return this.deep.echo(stuff);
	}
}
