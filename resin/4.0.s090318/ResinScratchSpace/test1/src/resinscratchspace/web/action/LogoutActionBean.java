package resinscratchspace.web.action;

import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.util.Log;
import resinscratchspace.web.AbstractActionBean;

@UrlBinding("/logout")
public class LogoutActionBean extends AbstractActionBean {
	private static final Log log = Log.getInstance(LogoutActionBean.class);
	

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
		log.debug("Logging using out.");
		this.loginStatus.clearUser();
		return new RedirectResolution("/home");
	}
}
