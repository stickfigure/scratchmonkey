package test;

import java.io.IOException;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/go")
public class GoServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(GoServlet.class.getName());

	@Inject StartupBean bean;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		log.info("Executing request");
		try
		{
			this.bean.go();
		}
		catch (Exception e)
		{
			throw new ServletException(e);
		}
	}

}
