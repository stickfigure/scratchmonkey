package resinscratchspace.queues;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.MessageDriven;
import javax.inject.Current;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.persistence.EntityManager;

import resinscratchspace.annotations.UserEvent;
import resinscratchspace.entities.User;
import resinscratchspace.entities.UserLogEntry;

@MessageDriven()
public class UserUpdateListener implements MessageListener {
	private static final Logger log = Logger.getLogger(UserUpdateListener.class.getName());
	@Current EntityManager entMgr;

	@Current @UserEvent
	private BlockingQueue<UserLogEntry> userEventQueue;	
	  
	public void onMessage(Message qMsg) {
		try {
			User u = (User)((ObjectMessage) qMsg).getObject();
			UserLogEntry ule = new UserLogEntry(u, "Login: " + u.getLastLogin());
			try {
				this.userEventQueue.put(ule);
			} catch (InterruptedException e) {
				//eat it.
				log.log(Level.SEVERE,e.getStackTrace().toString());
			}
			entMgr.merge(u);
			log.log(Level.INFO, "User updated: " + u.getFriendlyName() + "(" + u.getId()+ ")");
		} catch (JMSException e) {
			log.log(Level.SEVERE, e.getStackTrace().toString());
		}		
	}
}
