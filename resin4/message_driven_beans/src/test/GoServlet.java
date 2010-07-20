package test;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(loadOnStartup=1, urlPatterns="/go")
public class GoServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(GoServlet.class.getName());
	
	@Inject @Named("delivery") BlockingQueue<String> queue;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		log.info("Executing request");
		this.go();
	}

	protected void go() throws ServletException
	{
		log.info("Enqueueing");
		
		try
		{
			this.queue.put("A Thing");
		}
		catch (InterruptedException e)
		{
			throw new ServletException(e);
		}
	}
}
