/*
 * $Id$
 */

package test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

	/**
	 * Generates an error of the specified type
	 */
	@GET @Path("/error")
	public Response error(@QueryParam("code") int code)
	{
		return Response.status(code).entity("Fake error code " + code).build();
	}
	
	/**
	 * Just a quick test of the templating system
	 */
	@GET @Path("/blah")
	@Produces(MediaType.TEXT_PLAIN)
	public String blah(@QueryParam("blah") String blah) throws Exception
	{
		return blah;
	}
}