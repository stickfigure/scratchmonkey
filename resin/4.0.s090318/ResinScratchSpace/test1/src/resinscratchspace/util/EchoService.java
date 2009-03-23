package resinscratchspace.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import com.caucho.config.Service;

@Service
public class EchoService {
	private static final Logger log = Logger.getLogger(EchoService.class.getName());

	@PostConstruct
	public void start() {
		log.log(Level.WARNING,"Starting EchoService Service!");
	}

	@PreDestroy
	public void stop() {
		log.log(Level.WARNING,"Starting EchoService Service!");
	}
	
	public String echo(String s){
		log.log(Level.INFO,"Echoing: " + s);	
		return s;
	}
}
