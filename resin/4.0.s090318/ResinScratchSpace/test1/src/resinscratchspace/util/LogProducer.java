package resinscratchspace.util;

import java.util.logging.Logger;

import javax.inject.Produces;
import javax.inject.manager.InjectionPoint;

public class LogProducer {
	@Produces
	Logger createLogger(InjectionPoint injectionPoint) {
		return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
	}
}
