package test;

import java.io.IOException;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@ApplicationScoped
public class AppEngineTestServlet extends HttpServlet
{
	/** */
	private static final Logger log = Logger.getLogger(AppEngineTestServlet.class.getName());
	
	/** */
	int invokeCount;

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/plain");
		
		log.info("Executing doGet() on the same obj: " + invokeCount++);
	}
}
