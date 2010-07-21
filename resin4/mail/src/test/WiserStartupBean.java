package test;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import org.subethamail.wiser.Wiser;

@Named("wiser")
@ApplicationScoped
@Startup
public class WiserStartupBean
{
	private static final Logger log = Logger.getLogger(WiserStartupBean.class.getName());

	Wiser wiser;
	
	/** */
	public WiserStartupBean()
	{
		this.wiser = new Wiser(2525);
	}

	/** */
	@PostConstruct
	public void start()
	{
		log.info("Starting Wiser");
		this.wiser.start();
	}
}
