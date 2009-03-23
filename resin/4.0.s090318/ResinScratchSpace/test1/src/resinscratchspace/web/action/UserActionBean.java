package resinscratchspace.web.action;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.HandlesEvent;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.util.Log;
import net.sourceforge.stripes.validation.Validate;
import resinscratchspace.entities.User;
import resinscratchspace.web.AbstractActionBean;

@UrlBinding("/user/{id}/{$event}")
public class UserActionBean extends AbstractActionBean {
	private static final Log log = Log.getInstance(UserActionBean.class);
	
	@Validate(required=true)
	protected long id;

	protected void setId(long value) { 
		log.debug("Setting id = " + value);
		this.id = value; 
	}
	
	@Validate(required=true)
	protected long num;
	
	
	//stored as context for the resolution (jsp page rendering)
	protected User u;
	
	@DefaultHandler
	@HandlesEvent("view")
	public Resolution view(){
		log.debug("finding user, id=" + id);
		this.u = em.find(User.class, id);
		return new ForwardResolution("/user.jsp");
	}
	
	@HandlesEvent("edit")
	@Validate
	public Resolution edit(){
		this.u = this.loginStatus.getUser();
		log.debug("forwarding to useredit.jsp");
		return new ForwardResolution("/useredit.jsp");
	}

	public User getUser(){
		log.debug("getUser called: id=" + this.u.getId());
		return this.u;
	} 
}