package resinscratchspace.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import com.caucho.config.Service;

@Service
public class EchoService {
//	@New
	private Logger log = Logger.getLogger(EchoService.class.getName());

	@PostConstruct
	public void start() {
		log.log(Level.FINER,"Starting EchoService Service!");
	}

	@PreDestroy
	public void stop() {
		log.log(Level.FINER,"Stopping EchoService Service!");
	}
	
	public String echo(String s){
		log.log(Level.FINER,"Echoing: " + s);	
		return s;
	}
}
