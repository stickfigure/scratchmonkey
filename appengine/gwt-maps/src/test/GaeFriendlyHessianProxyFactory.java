package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.net.MalformedURLException;
import java.net.URL;

import com.caucho.hessian.client.HessianProxy;
import com.caucho.hessian.client.HessianProxyFactory;
import com.caucho.hessian.io.HessianRemoteObject;

/**
 * Fixes some behaviors that break on google appengine. 
 */
public class GaeFriendlyHessianProxyFactory extends HessianProxyFactory
{
	/**
	 * This used to set a timeout and expire a quick fetch in order to clear
	 * any keepalives.  GAE doesn't keepalive and it throws a RuntimeException
	 * (not IOException) when it times out, so that is no good.
	 */
	@Override
	@SuppressWarnings({ "unchecked", "serial" })
	public Object create(Class api, String urlName, ClassLoader loader) throws MalformedURLException
	{
		if (api == null)
			throw new NullPointerException("api must not be null for HessianProxyFactory.create()");
		
		InvocationHandler handler = null;

		URL url = new URL(urlName);

		handler = new HessianProxy(url, this, api) {};

		return Proxy.newProxyInstance(
				loader,
				new Class[] { api, HessianRemoteObject.class },
				handler);
	}
}
