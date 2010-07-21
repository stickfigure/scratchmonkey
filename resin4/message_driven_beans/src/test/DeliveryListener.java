/*
 * $Id: $
 * $URL:  $
 */

package test;

import java.util.logging.Logger;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

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
	private static final Logger log = Logger.getLogger(DeliveryListener.class.getName());

	/**
	 */
	public void onMessage(Message qMsg)
	{
		try
		{
			String item = (String)((TextMessage) qMsg).getText();
			log.warning("Processed message: " + item);
		}
		catch (JMSException ex)
		{
			log.severe("Error getting data out of message." + ex);
			throw new RuntimeException(ex);
		}
	}
}
