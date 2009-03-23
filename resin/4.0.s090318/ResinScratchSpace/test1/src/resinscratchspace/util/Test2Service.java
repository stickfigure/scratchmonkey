package resinscratchspace.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import com.caucho.config.Service;

@Service
public class Test2Service {
	private static final Logger log = Logger.getLogger(Test2Service.class.getName());

	@SuppressWarnings("unused")
	@PostConstruct
	private void postConstruct()
	{
		System.out.println("test2 construction starting");
		log.log(Level.WARNING,"test2 construction starting");
	}
	@SuppressWarnings("unused")
	@PreDestroy
	private void preDestroy()
	{
		log.log(Level.WARNING,"test2 destruction starting");
		System.out.println("test2 destruction starting");
	}
}
