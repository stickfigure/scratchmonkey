package resinscratchspace.web.action;

import java.util.concurrent.BlockingQueue;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.HandlesEvent;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.util.Log;
import net.sourceforge.stripes.validation.Validate;
import resinscratchspace.annotations.UserEvent;
import resinscratchspace.entities.User;
import resinscratchspace.entities.UserLogEntry;
import resinscratchspace.web.AbstractActionBean;

@UrlBinding("/user/{id}/{$event}")
public class UserActionBean extends AbstractActionBean {
	private static final Log log = Log.getInstance(UserActionBean.class);

	@SuppressWarnings("unchecked")
//	@Name("userEvent")
	@UserEvent
	private BlockingQueue userEventQueue;	
	
	@Validate(required=true)
	protected long id;

	public void setId(long value) { 
		this.id = value; 
	}
	public long getId(){return this.id;}
	
	@Validate(required=true)
	protected long num;
	
	//stored as context for the resolution (jsp page rendering)
	protected User u;
	
	@DefaultHandler
	@HandlesEvent("view")
	public Resolution view(){
		log.trace("finding user, id=" + id);
		return new ForwardResolution("/user.jsp");
	}
	
	@HandlesEvent("edit")
	public Resolution edit(){
		log.trace("forwarding to useredit.jsp");
		return new ForwardResolution("/useredit.jsp");
	}

	@SuppressWarnings("unchecked")
	@HandlesEvent("update")
	public Resolution update(){
		//Save changes.
		this.em.merge(this.u);
		
		try {
			this.userEventQueue.put(new UserLogEntry(this.u, "updated user: " + this.u.toString()));
		} catch (InterruptedException e) {
			// eat it...
			log.error(e.getStackTrace().toString());
		}
		
		log.trace("forwarding to useredit.jsp");
		return new ForwardResolution("/user.jsp");
	}
	
	@Override
	public void preBind() {
		Object idObject = getContext().getRequest().getAttribute("id");
		String id = idObject.toString();
		try{
			this.u = em.find(User.class, id);			
		} catch (Exception e){}
	}
	
	public User getUser(){
		log.debug("getUser called: id=" + this.u.getId());
		return this.u;
	} 
}