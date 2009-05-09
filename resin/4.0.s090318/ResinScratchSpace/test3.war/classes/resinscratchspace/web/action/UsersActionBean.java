package resinscratchspace.web.action;

import java.util.Collection;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.HandlesEvent;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.util.Log;
import net.sourceforge.stripes.validation.Validate;
import resinscratchspace.entities.User;
import resinscratchspace.web.AbstractActionBean;

@UrlBinding("/users/{$event}")
public class UsersActionBean extends AbstractActionBean {
	private static final Log log = Log.getInstance(UsersActionBean.class);
	
	//stored as context for the resolution (jsp page rendering)
	protected Collection<User> users;
	
	public Collection<User> getUsers(){
		log.debug("Returning users collection (to render)");
		return this.users;
	}
	
	@SuppressWarnings("unchecked")
	@DefaultHandler
	@HandlesEvent("view")
	@Validate
	public Resolution view(){
		log.debug("Getting users");
		this.users = em.createQuery("select u from User u").getResultList();
		log.debug("got users:" + this.users.size() );
		if(this.users.size() > 0) {
			log.debug("user[0].log.size:" + ((User)this.users.toArray()[0]).GetLog().size());
		}
		
		return new ForwardResolution("/users.jsp");
	}
}