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

import resinscratchspace.entities.UserLogEntry;

@MessageDriven()
public class UserEventListener implements MessageListener {
	private static final Logger log = Logger.getLogger(UserEventListener.class.getName());
	@Current EntityManager entMgr;
	
	  
	@Override
	public void onMessage(Message qMsg) {
		try {
			UserLogEntry ule = (UserLogEntry)((ObjectMessage) qMsg).getObject();
			entMgr.persist(ule);
			log.log(Level.INFO, "User Event Saved: " + ule.toString());
		} catch (JMSException e) {
			log.log(Level.SEVERE, e.getStackTrace().toString());
		}
		
	}
	

}
