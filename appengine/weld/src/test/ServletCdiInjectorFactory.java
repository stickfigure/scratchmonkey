/*
 * $Id$
 */

package test;

import javax.enterprise.inject.spi.BeanManager;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.jboss.resteasy.cdi.CdiInjectorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 */
public class ServletCdiInjectorFactory extends CdiInjectorFactory
{
	private final static Logger log = LoggerFactory.getLogger(ServletCdiInjectorFactory.class);

	static ServletContext servletContext;
	
	public static class Listener implements ServletContextListener
	{
		@Override
		public void contextInitialized(ServletContextEvent ev)
		{
			servletContext = ev.getServletContext();
		}
		
		@Override
		public void contextDestroyed(ServletContextEvent ev)
		{
			servletContext = null;
		}
	}

	@Override
	protected BeanManager lookupBeanManager()
	{
		BeanManager mgr = (BeanManager)servletContext.getAttribute(BeanManager.class.getName());
		log.info("BeanManager is " + mgr);
		return mgr;
	}
}