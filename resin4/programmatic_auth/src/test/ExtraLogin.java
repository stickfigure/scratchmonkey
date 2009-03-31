package test;

import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import com.caucho.security.AbstractLogin;
import com.caucho.security.Authenticator;
import com.caucho.security.BasicPrincipal;
import com.caucho.security.Credentials;
import com.caucho.security.PasswordCredentials;

public class ExtraLogin extends AbstractLogin {
	private static final Logger log = Logger.getLogger(ExtraLogin.class.getName());

	/**
	 * Logs in the user/pass to the container.
	 * 
	 * @return true if success, false if the credentials were bad.
	 */
	public boolean login(String name, String pass, HttpServletRequest request)
	{
		Authenticator auth = this.getAuthenticator();
		
	    BasicPrincipal user = new BasicPrincipal(name);

	    Credentials credentials = new PasswordCredentials(pass);
	    Principal principal = auth.authenticate(user, credentials, request);

	    if (log.isLoggable(Level.FINE))
	      log.fine("extra: " + user + " -> " + principal);
	    
	    if (principal == null)
	    {
	    	return false;
	    }
	    else
	    {
	    	this.saveUser(request, principal);
	    	return true;
	    }
	}
}
