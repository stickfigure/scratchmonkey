package test;

import java.util.logging.Level;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.caucho.config.Service;

@Service
public class EchoService
{
	private static final Logger log = LoggerFactory.getLogger(EchoService.class);
	private static final java.util.logging.Logger logJDK = java.util.logging.Logger.getLogger(EchoService.class.getName());

	@PostConstruct
	public void start()
	{
		log.trace("Starting @ trace with slf4j");
		log.debug("Starting @ debug with slf4j");
		log.info("Starting @ info with slf4j");
		log.warn("Starting @ warn with slf4j");
		log.error("Starting @ error with slf4j");

		logJDK.log(Level.FINEST, "Starting @ FINEST with jdk");
		logJDK.log(Level.FINER, "Starting @ FINER with jdk");
		logJDK.log(Level.FINE, "Starting @ FINE with jdk");
		logJDK.log(Level.CONFIG, "Starting @ CONFIG with jdk");
		logJDK.log(Level.INFO, "Starting @ INFO with jdk");
		logJDK.log(Level.WARNING, "Starting @ WARNING with jdk");
		logJDK.log(Level.SEVERE, "Starting @ SEVERE with jdk");
	}

	public String echo(String s)
	{
		log.debug("Echoing at level debug: " + s);	
		return s;
	}
}
