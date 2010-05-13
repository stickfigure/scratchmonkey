/*
 * $Id$
 */

package test;

import javax.enterprise.context.ApplicationScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 */
@ApplicationScoped
public class Thing
{
	protected int times = 0;
	
	/** */
	private final static Logger log = LoggerFactory.getLogger(Thing.class);

	/** */
	public void doit()
	{
		times++;
		
		log.info("Done times: " + times);
	}

}