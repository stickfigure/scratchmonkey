/*
 * $Id: BeanMixin.java 1075 2009-05-07 06:41:19Z lhoriman $
 * $URL: https://subetha.googlecode.com/svn/branches/resin/rtest/src/org/subethamail/rtest/util/BeanMixin.java $
 */

package test;

import java.net.URL;
import java.util.logging.Logger;

import javax.annotation.Named;

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
		
//		byte[] stuff = "abc".getBytes();
//		String[] stuff = {"foo", "bar"};
//		Payload[] stuff = {new Payload(), new Payload()};
		URL stuff = new URL("http://www.example.com/foo");

		String got = ech.echo(stuff);
		
		System.out.println("Got back:  " + got);
	}
}