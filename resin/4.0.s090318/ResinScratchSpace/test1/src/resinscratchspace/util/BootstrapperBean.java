package resinscratchspace.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateful;
import javax.inject.Current;

import com.caucho.config.Service;

@Stateful
@Service
public class BootstrapperBean implements Bootstrapper {
	@Current
	private Logger log;	

	@PostConstruct
	public void init(){
		log.log(Level.INFO,"Starting Bootstrapper Service!");
	}
	
	@PreDestroy
	public void destroy(){
		log.log(Level.INFO,"Stopping Bootstrapper Service!");
	}
}
