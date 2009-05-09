/*
 * $Id: $
 * $URL: $
 */

package resinscratchspace.web;

import java.io.Serializable;
import javax.annotation.Named;
import javax.context.SessionScoped;
import javax.inject.Initializer;

import resinscratchspace.entities.User;

/**
 * Stores information about the LoginStatus
 * 
 * This object is SessionScoped and one will always exist, therefore.
 * If there associated User entity then the user has authenticated.
 * 
 * @author Scott Hernandez
 */
//@Named("loginStatus")
@SessionScoped
public class LoginStatus implements Serializable {
	private static final long serialVersionUID = 1L;
	
	User user = null;
	
	public boolean isLoggedIn() 
	{ 
		return (null != this.user);
	}
	
	/**
	 * Returns the current AuthCredentials for this LoginStatus
	 * @return
	 */
	public User getUser(){
		return user;	
	}
	/**
	 * Sets the AuthCredential for this LoginStatus
	 * @param value The AuthCredentials to associate
	 * @return The AuthCredentials set
	 */
	public User setUser(User value){
		this.user = value;
		return this.user;
	}
	/**
	 * Clears the current LoginStatus AuthCredentials
	 */
	public void clearUser(){ this.user = null;}
}
