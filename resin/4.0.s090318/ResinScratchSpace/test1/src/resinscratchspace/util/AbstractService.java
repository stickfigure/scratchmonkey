package resinscratchspace.util;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import com.caucho.config.Service;

@Service
abstract public class AbstractService {
	
	@PostConstruct
	private void postConstruct(){start();}
	@PreDestroy
	private void preDestroy(){stop();}
	
	abstract public void start();
	abstract public void stop();
}
