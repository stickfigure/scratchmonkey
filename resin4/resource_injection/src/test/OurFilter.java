/*
 * $Id: SetRequestCharsetFilter.java 1120 2009-05-14 06:10:17Z lhoriman $
 * $URL: https://subetha.googlecode.com/svn/branches/resin/src/org/subethamail/web/util/SetRequestCharsetFilter.java $
 */

package test;

import java.io.IOException;
import java.util.logging.Logger;

import javax.enterprise.inject.Current;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Jeff Schnitzer
 */
public class OurFilter extends AbstractFilter
{
	private static final Logger log = Logger.getLogger(OurFilter.class.getName());

	/** */
	@Current Intermediate intermediate;
	
	/**
	 */
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
		throws IOException, ServletException
	{
		log.info("Running OurFilter for " + request.getRequestURL());
		
		chain.doFilter(request, response);
	}
}
