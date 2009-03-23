package resinscratchspace.util;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import com.caucho.config.Service;

@Service
abstract public class AbstractService {
	@PostConstruct abstract protected void start();
	@PreDestroy	abstract protected void stop();
}
