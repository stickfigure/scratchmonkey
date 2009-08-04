/*
 * $Id: BeanMixin.java 1075 2009-05-07 06:41:19Z lhoriman $
 * $URL: https://subetha.googlecode.com/svn/branches/resin/rtest/src/org/subethamail/rtest/util/BeanMixin.java $
 */

package test;

import java.util.logging.Logger;

import javax.enterprise.inject.Named;

import com.caucho.hessian.client.HessianProxyFactory;

/**
 * @author Jeff Schnitzer
 */
@Named("echo-client")
public class Client
{
	/** */
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(Client.class.getName());
	
	public static void main(String[] args) throws Exception
	{
		HessianProxyFactory fact = new HessianProxyFactory();
		fact.setOverloadEnabled(true);
//		fact.setUser("harry");
//		fact.setPassword("potter");
		
		String url = "http://localhost:8080/ct/api/Echo";
		
		Echo ech = (Echo)fact.create(Echo.class, url);

		String got = ech.echo("foo");
		
		System.out.println("Got back:  " + got);
	}
}