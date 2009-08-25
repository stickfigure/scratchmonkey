package test;

import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.googlecode.htmleasy.ViewWith;

/**
 * 
 * @author Jeff Schnitzer <jeff@infohazard.org>
 */
@Path("/hello")
public class Hello
{
	private static final Logger log = Logger.getLogger(Hello.class.getName());

	@ViewWith("/stuff.jsp")
	public static class Stuff
	{
		String first;
		String second;
		
		public String getFirst() { return this.first; }
		public String getSecond() { return this.second; }
	}
	
	@GET
	public int yeah()
	{
		log.info("yeah()");
		
		return 1;
	}

	@GET
	@Path("/stuff")
	@ViewWith("/stuff2.jsp")
	public Stuff getStuff()
	{
		Stuff stu = new Stuff();
		stu.first = "hello, first";
		stu.second = "hello, second";
		
		return stu;
	}
}
