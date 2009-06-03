package test;

import java.util.logging.Logger;

import javax.annotation.Named;
import javax.inject.Current;

@Named("echoer")
public class EchoService implements Echo
{
	private static final Logger log = Logger.getLogger(EchoService.class.getName());
	
	@Current Blah foo;

	public String echo(String s)
	{
		log.info("Echoing: " + s);

		return this.foo.blah(s);
	}
}
