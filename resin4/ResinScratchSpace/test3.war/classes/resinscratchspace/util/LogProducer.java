package resinscratchspace.util;

import java.util.logging.Logger;

import javax.inject.Produces;
import javax.inject.manager.InjectionPoint;

import net.sourceforge.stripes.util.Log;

public class LogProducer {
	@Produces
	Logger createLogger(InjectionPoint iPoint) {
		return Logger.getLogger(iPoint.getMember().getDeclaringClass().getName());
	}
	
	@Produces
	Log createLog(InjectionPoint iPoint){
		return Log.getInstance(iPoint.getMember().getDeclaringClass());
	}
}
