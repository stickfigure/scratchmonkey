package resinscratchspace.web.action;

import java.util.Date;
import java.util.concurrent.BlockingQueue;

import javax.inject.Current;

import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.util.Log;
import resinscratchspace.annotations.UserEvent;
import resinscratchspace.entities.UserLogEntry;
import resinscratchspace.web.AbstractActionBean;

@UrlBinding("/logout")
public class LogoutActionBean extends AbstractActionBean {
	private static final Log log = Log.getInstance(LogoutActionBean.class);

	@UserEvent
	@Current
	private BlockingQueue<UserLogEntry> userEventQueue;	


	@DefaultHandler
	@DontValidate
	public Resolution view() {
		if(!this.loginStatus.isLoggedIn()){
			getContext().getMessages().add(new SimpleMessage("You are not logged in."));
			return new RedirectResolution("/login");
		} else
			return new ForwardResolution("/logout.jsp");
	}
	
	@HandlesEvent("logout")
	public Resolution logout(){
		log.debug("Logging user out.");
		try {
			userEventQueue.put(new UserLogEntry(this.loginStatus.getUser(),"Logging user out: " + (new Date()).toString()));
		} catch (InterruptedException e) {
			log.error(e, "Failed to Queue UserLogEntry!");
		}
		this.loginStatus.clearUser();
		return new RedirectResolution("/home");
	}
}
