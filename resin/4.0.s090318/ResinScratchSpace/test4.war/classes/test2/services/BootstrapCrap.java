package test2.services;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.manager.Manager;

import com.caucho.config.ConfigException;
import com.caucho.config.Configurable;
import com.caucho.config.Unbound;
import com.caucho.config.inject.InjectManager;
import com.caucho.lifecycle.StartLifecycleException;
import com.caucho.loader.Environment;
import com.caucho.loader.EnvironmentClassLoader;
import com.caucho.loader.EnvironmentListener;

//@Configurable @Unbound
public class BootstrapCrap implements EnvironmentListener
{
	private static final Logger log = Logger.getLogger(BootstrapCrap.class.getName());

	static
	{
		System.err.println("AAARRRGGGGGGGG");
		System.out.println("AAARRRGGGGGGGG");
		log.log(Level.FINE,"adding envListener (new this)");
		//Environment.addEnvironmentListener(new BootstrapCrap());
	}
	
	public BootstrapCrap(){}
	
	public void environmentBind(EnvironmentClassLoader loader) throws ConfigException
	{
		log.log(Level.FINE,"envBind()");
	}
	public void environmentConfigure(EnvironmentClassLoader loader) throws ConfigException
	{
		log.log(Level.FINE,"envConfigure()");	
	}
	public void environmentStart(EnvironmentClassLoader loader) throws StartLifecycleException
	{
		log.log(Level.FINE,"envStart()");
		Manager mgr = InjectManager.create();
		InitDBService svc = (InitDBService)mgr.getInstanceByName(InitDBService.class.getName());
		svc.start();
	}
	public void environmentStop(EnvironmentClassLoader loader)
	{
		log.log(Level.FINE,"envStop()");		
	}
}