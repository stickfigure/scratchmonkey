package test;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.caucho.config.Service;

@Service
public class EchoService
{
	private static final Logger log = LoggerFactory.getLogger(EchoService.class);

	@PostConstruct
	public void start()
	{
		log.trace("Starting @ level trace");
		log.debug("Starting @ level debug");
		log.info("Starting @ level info");
		log.warn("Starting @ level warn");
		log.error("Starting @ level error");
	}

	@PreDestroy
	public void stop()
	{
		log.debug("Stopping @ level debug");
	}
	
	public String echo(String s)
	{
		log.debug("Echoing at level debug: " + s);	
		return s;
	}
}
