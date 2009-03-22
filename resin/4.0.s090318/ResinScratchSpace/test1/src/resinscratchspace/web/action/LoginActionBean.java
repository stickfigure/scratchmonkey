package resinscratchspace.web.action;

import java.util.concurrent.BlockingQueue;

import javax.inject.Current;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.util.Log;
import net.sourceforge.stripes.validation.LocalizableError;
import net.sourceforge.stripes.validation.SimpleError;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidationError;
import resinscratchspace.entities.User;
import resinscratchspace.web.LoginStatus;

@UrlBinding("/login")
public class LoginActionBean implements ActionBean {
	private static final Log log = Log.getInstance(LoginActionBean.class);
	
	//@Current
	protected ActionBeanContext context;
	
	@SuppressWarnings("unused")
	@Current
	private UserTransaction uTrans;

	@Current
	private EntityManager manager;

	@Current
	protected LoginStatus loginStatus;

	@SuppressWarnings("unchecked")
	@Current
	private BlockingQueue userUpdateQueue;	

  	@Validate(required = true)
	private String email;

	@Validate(required = true)
	private String password;

	public void setEmail(String val){ this.email=val;}
	public void setPassword(String val){ this.password=val;}

	@Override
	public ActionBeanContext getContext() {
		return this.context;
	}

	@Override
	public void setContext(ActionBeanContext val) {
		this.context = val;
	}

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
		
		if(this.manager == null) log.error("No EntityManager Injected!");
		if(this.loginStatus == null) log.error("No LoginStatus Injected!");
		if(this.userUpdateQueue == null) log.error("No Queue Ijected!");

		//the user
		User u = null; 
		
		Query q = manager.createQuery("select u from User u where u.password = :pw and u.email= :email");
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
		
		//queueUserUpdate(u);
		return true;
	}
	
	@SuppressWarnings({ "unchecked", "unused" })
	private void queueUserUpdate(User u){
		try {
			this.userUpdateQueue.put(u);
		} catch (InterruptedException e) {
			log.error(e);
		}
	}
}
