package org.jboss.resteasy.core;

import java.lang.reflect.Constructor;

import javax.inject.manager.Manager;
import javax.ws.rs.WebApplicationException;

import org.jboss.resteasy.spi.ApplicationException;
import org.jboss.resteasy.spi.ConstructorInjector;
import org.jboss.resteasy.spi.Failure;
import org.jboss.resteasy.spi.HttpRequest;
import org.jboss.resteasy.spi.HttpResponse;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

/**
 * <p>
 * This modified version of the original Resteasy file creates beans through the
 * JSR299 BeanManager instead. Note that JAX-RS constructor parameters
 * (@QueryParam, etc) are not honored in this case; only JSR299 parameters are.
 * </p>
 * <p>
 * Put this class on the classpath ahead of the original Resteasy version. In
 * Resin4, simply include it (with correct package) in WEB-INF/classes.
 * </p>
 * 
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @author Jeff Schnitzer
 * @version $Revision: 1 $
 */
public class ConstructorInjectorImpl implements ConstructorInjector
{
	Class<Object> clazz;
	Manager beanManager;

	@SuppressWarnings("unchecked")
	public ConstructorInjectorImpl(Constructor constructor, ResteasyProviderFactory factory)
	{
		this.clazz = constructor.getDeclaringClass();

        try
		{
			Class injectorClass = Class.forName("com.caucho.config.inject.InjectManager");
			this.beanManager = (Manager) injectorClass.getDeclaredMethod("create").invoke(null);
		}
		catch (Exception ex)
		{
			throw new RuntimeException(ex);
		}
    }

	public Object[] injectableArguments(HttpRequest input, HttpResponse response)
	{
		return null;
	}

	public Object[] injectableArguments()
	{
		return null;
	}

	public Object construct(HttpRequest request, HttpResponse httpResponse)
		throws Failure, ApplicationException, WebApplicationException
	{
		return this.beanManager.getInstanceByType(this.clazz);
	}

	public Object construct()
	{
		return this.beanManager.getInstanceByType(this.clazz);
	}
}