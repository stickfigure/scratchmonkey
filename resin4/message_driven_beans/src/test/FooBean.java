package test;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Logger;

/**
 * Running the basic examples from the docs
 * 
 * @author Jeff Schnitzer
 */
public class FooBean
{
	private static final Logger log = Logger.getLogger(FooBean.class.getName());
	
	FooBean bar;
	public void setBar(FooBean value)
	{
		log.warning("From " + this + ", setting bar " + value);
		this.bar = value; 
	}
	
	BlockingQueue<?> dest;
	public void setDest(BlockingQueue<?> value)
	{
		log.warning("From " + this + ", setting dest " + value);
		this.dest = value; 
	}
}
