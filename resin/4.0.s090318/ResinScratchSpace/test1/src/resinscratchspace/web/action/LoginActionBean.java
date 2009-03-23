package resinscratchspace.web.action;

import java.util.concurrent.BlockingQueue;

import javax.inject.Current;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.util.Log;
import net.sourceforge.stripes.validation.LocalizableError;
import net.sourceforge.stripes.validation.SimpleError;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidationError;
import resinscratchspace.entities.User;
import resinscratchspace.web.AbstractActionBean;

@UrlBinding("/login")
public class LoginActionBean  extends AbstractActionBean {
	private static final Log log = Log.getInstance(LoginActionBean.class);

	@SuppressWarnings("unchecked")
	@Current
	private BlockingQueue userUpdateQueue;	

  	@Validate(required = true)
	private String email;

	@Validate(required = true)
	private String password;

	public void setEmail(String val){ this.email=val;}
	public void setPassword(String val){ this.password=val;}

	@DefaultHandler
	@DontValidate
	public Resolution view() {
		if(this.loginStatus.isLoggedIn()){
			getContext().getMessages().add(
					new SimpleMessage("You are already logged in, and have been sent home:"));
			return new RedirectResolution("/home");
		} else
			return new ForwardResolution("/login.jsp");
	}

	@HandlesEvent("login")
	public Resolution login() {
		if(!this.doLogin()){
			return getContext().getSourcePageResolution();
		}
		return new RedirectResolution("/home");
	}

	private boolean doLogin() {
		log.debug("Starting doLogin: (email/pass) " + this.email + "/" + this.password);
		
		//the user
		User u = null; 
		
		Query q = this.em.createQuery("select u from User u where u.password = :pw and u.email= :email");
		log.debug("Created Query (from entity manager)");
		
		q.setParameter("pw", this.password);
		q.setParameter("email", this.email);
		
		try {
			u = (User) q.getSingleResult();
		} catch (NoResultException nre){
			getContext().getValidationErrors().add("password", new SimpleError("Invalid email or password." ));

		} catch (NonUniqueResultException nure){
			//um, maybe a problem!
		}

		if (u == null) {
			if (!"password".equals(this.password)) {
	            ValidationError error = new LocalizableError("usernameDoesNotExist");
	            getContext().getValidationErrors().add("username", error);
				return false;
			}
		} else {
			this.loginStatus.setUser(u);
		}
		
		queueUserUpdate(u);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	private void queueUserUpdate(User u){
		try {
			u.updateLastLogin();
			this.userUpdateQueue.put(u);
		} catch (InterruptedException e) {
			log.error(e);
		}
	}
}
