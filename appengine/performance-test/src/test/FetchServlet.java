package test;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

@SuppressWarnings("serial")
public class FetchServlet extends HttpServlet
{
	/** */
	private static final Logger log = Logger.getLogger(FetchServlet.class.getName());

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/plain");

		long time = System.currentTimeMillis();
		new Thing();
		
		Objectify ofy = ObjectifyService.begin();
		
		List<Thing> things = ofy.query(Thing.class).list();
		
		for (Thing thing: things)
		{
			thing.getId();
			thing.getValue();
		}
		
		long elapsed = System.currentTimeMillis() - time;
			
		log.info("Elapsed millis: " + elapsed);
		
		resp.getWriter().print("Fetched " + things.size() + " things in " + elapsed + " millis");
	}
}
