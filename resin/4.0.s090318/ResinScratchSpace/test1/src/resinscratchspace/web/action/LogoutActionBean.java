package resinscratchspace.web.action;

import javax.inject.Current;
import javax.transaction.UserTransaction;

import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.util.Log;
import resinscratchspace.web.LoginStatus;

@UrlBinding("/logout/${view}")
public class LogoutActionBean implements ActionBean {
	private static final Log log = Log.getInstance(LogoutActionBean.class);
	
	//@Current
	ActionBeanContext context;
	
	@SuppressWarnings("unused")
	@Current
	private UserTransaction uTrans;

	@Current
	LoginStatus loginStatus;

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
