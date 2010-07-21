package test;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("startup")
@ApplicationScoped
@Startup
public class StartupBean
{
	private static final Logger log = Logger.getLogger(StartupBean.class.getName());
	
	/** */
	@Inject Echo echo;
	
	/** */
	public StartupBean()
	{
		log.info("Constructor");
	}

	/** */
	@PostConstruct
	public void start()
	{
		String echoThis = this.echo.echo("echoThis");
		log.info("Result: " + echoThis);
	}
}
