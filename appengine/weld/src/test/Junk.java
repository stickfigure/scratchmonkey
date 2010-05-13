/*
 * $Id$
 */

package test;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Some random junk for client testing
 * 
 * @author Jeff Schnitzer
 */
@Path("/test")
public class Junk
{
	/** */
	@SuppressWarnings("unused")
	private final static Logger log = LoggerFactory.getLogger(Junk.class);

	@Inject Thing thing;
	
	/**
	 * Blah!
	 */
	@GET @Path("/blah")
	@Produces(MediaType.TEXT_PLAIN)
	public String blah(@QueryParam("blah") String blah) throws Exception
	{
		this.thing.doit();
		
		return blah;
	}
}