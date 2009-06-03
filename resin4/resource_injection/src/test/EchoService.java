package test;

import java.util.logging.Logger;

import javax.annotation.Named;
import javax.context.ApplicationScoped;
import javax.mail.Session;

@Named("echoer")
@ApplicationScoped
public class EchoService implements Echo
{
	private static final Logger log = Logger.getLogger(EchoService.class.getName());
	
	/** */
	//@Name("outbound")
	@OutboundMTA
	Session mail;

	/** */
	public String echo(String s)
	{
		log.info("Echoing: " + s);
		
		log.info("Mail session is " + mail + ", " + mail.getProperties());

		return s;
	}
}
