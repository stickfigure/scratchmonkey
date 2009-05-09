package resinscratchspace.web.action;

import java.util.concurrent.BlockingQueue;

import javax.inject.Current;

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

	@UserEvent
	@Current
	private BlockingQueue<UserLogEntry> userEventQueue;	
	
	@Validate(required=true)
	protected long id;

	public void setId(long value) { 
		this.id = value;
		if(this.u==null || this.u.getId() != this.id) { 
			this.u = this.em.find(User.class, this.id);
		}
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
		log.debug("preBind Init");
		Object idObject = getContext().getRequest().getParameter("id");
		
		
		if(idObject != null){
			log.debug("finding user, id=" + idObject);
			String id = idObject.toString();
			try{
				this.u = em.find(User.class, id);			
			} catch (Exception e){}
		} else {
			log.error("No id provided for preBind-ing of Entities[User]");
		}
		
	}
	
	public User getUser(){
		log.debug("getUser called: id=" + this.u.getId());
		return this.u;
	} 
}