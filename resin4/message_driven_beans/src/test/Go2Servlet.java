package test;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(loadOnStartup=1, urlPatterns="/go2")
public class Go2Servlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(Go2Servlet.class.getName());
	
//	@Inject @Named("a") FooBean a;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		log.info("Executing request");
		this.go();
	}

	protected void go() throws ServletException
	{
//		log.info("a is " + a);
	}
}
