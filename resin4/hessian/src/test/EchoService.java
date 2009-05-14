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

	public String echo(byte[] stuff)
	{
		log.info("Echoing: " + stuff);
		
		return stuff.toString();
	}

	public String echo(String[] stuff)
	{
		log.info("Echoing: " + stuff);
		
		String result = "";
		for (String add: stuff)
			result = result + add;
		
		return result;
	}
	
	public String echo(Payload[] stuff)
	{
		log.info("Echoing: " + stuff);
		
		String result = "";
		for (Payload add: stuff)
			result = result + add;
		
		return result;
	}
}
