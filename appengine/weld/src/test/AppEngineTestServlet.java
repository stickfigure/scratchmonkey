package test;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class AppEngineTestServlet extends HttpServlet
{
	/** */
	private static final Logger log = Logger.getLogger(AppEngineTestServlet.class.getName());

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/plain");
		
		log.info("Executing doGet()");
		
		try
		{
			this.runTest();
		}
		catch (Exception ex)
		{
			throw new IOException(ex);
		}
	}
	
	public void runTest() throws Exception
	{
		
	}
}
