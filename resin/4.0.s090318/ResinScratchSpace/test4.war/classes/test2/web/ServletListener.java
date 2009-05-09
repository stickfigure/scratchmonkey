package test2.web;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Current;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import test2.services.InitDBService;

public class ServletListener implements ServletContextListener
{
	@Current
	InitDBService init;
	
	/**
	 * Logger for this class
	 */
	private static final Logger	logger	= Logger.getLogger(ServletListener.class.getName());

	@Override
	public void contextDestroyed(ServletContextEvent arg0)
	{
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0)
	{
		if (logger.isLoggable(Level.CONFIG))
		{
			logger.config("contextInitialized - start"); //$NON-NLS-1$
		}

		init.start();
		
		if (logger.isLoggable(Level.CONFIG))
		{
			logger.config("contextInitialized - end"); //$NON-NLS-1$
		}
	}

}
