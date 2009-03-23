package resinscratchspace.web.action;

import javax.inject.Current;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.util.Log;

@UrlBinding("/home")
public class HomeActionBean implements ActionBean {
	private static final Log log = Log.getInstance(HomeActionBean.class);

	@Current
	resinscratchspace.biz.SecurityManager secMgr;
	
	public ActionBeanContext getContext() {
		// TODO Auto-generated method stub
		return null;
	}

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
