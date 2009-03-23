/*
 * $Id: BeanMixin.java 948 2007-04-26 06:27:45Z jon $
 * $URL: http://subetha.tigris.org/svn/subetha/trunk/rtest/src/org/subethamail/rtest/util/BeanMixin.java $
 */

package test;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.security.client.SecurityClient;
import org.jboss.security.client.SecurityClientFactory;

/**
 * @author Jeff Schnitzer
 */
public class Client
{
	/** */
	@SuppressWarnings("unused")
	private static Log log = LogFactory.getLog(Client.class);

	/** */
	public static void main(String[] args) throws Exception
	{
//		Principal p = new SimplePrincipal("jduke");
//		SecurityAssociation.setPrincipal(p);
//		SecurityAssociation.setCredential("theduke");

		SecurityClient securityClient = SecurityClientFactory.getSecurityClient();
		securityClient.setSimple("jduke", "theduke");
		securityClient.login();
		
		Properties props = new Properties();
//		props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.security.jndi.LoginInitialContextFactory");
		props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
		props.setProperty(Context.PROVIDER_URL, "jnp://localhost:1099");
		props.setProperty(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
		
//		props.setProperty(Context.SECURITY_PRINCIPAL, "jduke");
//		props.setProperty(Context.SECURITY_CREDENTIALS, "theduke");
//		props.setProperty(Context.SECURITY_PROTOCOL, "ct");
		
		Context ctx = new InitialContext(props);
		Other other = (Other)ctx.lookup("ContainerTest/OtherBean/remote");
		
		other.foo();
	}
}
