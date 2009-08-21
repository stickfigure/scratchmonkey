package test;

import java.util.logging.Logger;

import javax.enterprise.inject.Named;

@Named("echoer")
public class EchoService implements Echo
{
	private static final Logger log = Logger.getLogger(EchoService.class.getName());

	public String echo(String s)
	{
		log.info("Echoing: " + s);

		return s;
	}
}
