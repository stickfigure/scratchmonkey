/*
 * $Id: SubEthaLoginModule.java 735 2006-08-20 04:21:14Z lhoriman $
 * $Source: /cvsroot/Similarity4/src/java/com/similarity/util/SimilarityLoginModule.java,v $
 */

package test;

import java.security.Principal;
import java.util.logging.Logger;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;

import com.caucho.security.Authenticator;
import com.caucho.security.Credentials;


/**
 * @author Jeff Schnitzer
 */
@Interceptors({LogMethodCalls.class})
public class OurAuthenticator implements Authenticator
{
	/** */
	private static Logger log = Logger.getLogger(OurAuthenticator.class.getName());

	/**
	 * Authenticate the user by the password, returning null on failure.
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
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