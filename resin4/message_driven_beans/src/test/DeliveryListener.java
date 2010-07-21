/*
 * $Id: $
 * $URL:  $
 */

package test;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Process a queue message
 */
//@MessageDriven(name="delivery", activationConfig={
//		@ActivationConfigProperty(propertyName="destinationType", propertyValue="javax.jms.Queue"),
//		@ActivationConfigProperty(propertyName="destination", propertyValue="delivery")
//})
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class DeliveryListener implements MessageListener
{
	/** */
	private final static Logger log = LoggerFactory.getLogger(DeliveryListener.class);

	/**
	 */
	public void onMessage(Message qMsg)
	{
		try
		{
			String item = (String)((ObjectMessage) qMsg).getObject();
			log.warn("Processed message: " + item);
		}
		catch (JMSException ex)
		{
			if (log.isErrorEnabled())
				log.error("Error getting data out of message.", ex);
			
			throw new RuntimeException(ex);
		}
	}
}
