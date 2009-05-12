/*
 * $Id: SubEthaLoginModule.java 735 2006-08-20 04:21:14Z lhoriman $
 * $Source: /cvsroot/Similarity4/src/java/com/similarity/util/SimilarityLoginModule.java,v $
 */

package test;

import java.security.Principal;
import java.util.logging.Logger;

import javax.interceptor.Interceptors;

import util.LogMethodCalls;

import com.caucho.security.AbstractAuthenticator;
import com.caucho.security.Credentials;


/**
 * @author Jeff Schnitzer
 * @author Scott Hernandez
 */
@Interceptors({LogMethodCalls.class})
public class OurAuthenticator extends AbstractAuthenticator
{
	/** */
	private static final long serialVersionUID = 1L;
	
	/** */
	@SuppressWarnings("unused")
	private static Logger log = Logger.getLogger(OurAuthenticator.class.getName());
	
	/**
	 * Authenticate the user by the password, returning null on failure.
	 */
	public Principal authenticate(Principal prince, Credentials credentials, Object detail)
	{
		return prince;
	}

	/** */
	public boolean isUserInRole(Principal user, String role)
	{
		return true;
	}

	/** */
	public void logout(Principal user)
	{
		// Nothing special needed
	}	
}