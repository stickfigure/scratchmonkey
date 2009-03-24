package resinscratchspace.web;

import javax.inject.Current;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;

public class AbstractActionBean implements ActionBean {
	protected ActionBeanContext context;
	
	@Current
	protected EntityManager em;
	
	@Current
	protected UserTransaction uTrans;

	@Current
	protected LoginStatus loginStatus;

	public ActionBeanContext getContext() {
		return this.context;
	}

	public void setContext(ActionBeanContext val) {
		this.context = val;
		preBind();
	}
	
	protected void preBind(){}
	public LoginStatus getLoginStatus(){return this.loginStatus;}
}
