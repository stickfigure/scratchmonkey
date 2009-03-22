package resinscratchspace.web.action;

import javax.inject.Current;

import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.util.Log;

@UrlBinding("/home")
public class HomeActionBean implements ActionBean {
	private static final Log log = Log.getInstance(HomeActionBean.class);

	@Current
	resinscratchspace.biz.SecurityManager secMgr;
	
	@Override
	public ActionBeanContext getContext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setContext(ActionBeanContext context) {
		// TODO Auto-generated method stub

	}

	@DefaultHandler
	public Resolution view(){
		return new ForwardResolution("/home.jsp");
	}
	
	public boolean isAuthenticatedToBackend(){
		if(this.secMgr == null) log.error("The stateless EJB is null!");
		return secMgr.isAuthenticated();
	}

}
