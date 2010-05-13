package test;

import java.io.IOException;
import java.util.logging.Logger;

import javax.enterprise.inject.spi.BeanManager;
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

		Object mgr = this.getServletContext().getAttribute(BeanManager.class.getName());
		
		resp.getWriter().println("Mgr is " + mgr);
	}
}
