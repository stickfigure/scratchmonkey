package resinscratchspace.queues;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.MessageDriven;
import javax.inject.Current;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.persistence.EntityManager;

import resinscratchspace.entities.User;

@MessageDriven()
public class UserUpdateListener implements MessageListener {
	private static final Logger log = Logger.getLogger(UserUpdateListener.class.getName());
	@Current EntityManager entMgr;
	
	  
	@Override
	public void onMessage(Message qMsg) {
		try {
			User u = (User)((ObjectMessage) qMsg).getObject();
			entMgr.persist(u);
			log.log(Level.INFO, "User updated: " + u.getFriendlyName() + "(" + u.getId()+ ")");
		} catch (JMSException e) {
			log.log(Level.SEVERE, e.getStackTrace().toString());
		}
		
	}
	

}
