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
		

//		String url = "http://voodoodyne.appspot.com/hello";

//		HessianProxyFactory factory = new HessianProxyFactory();
//		factory.setHessian2Request(true);
//		Hello hell = (Hello)factory.create(Hello.class, url);

//		resp.getWriter().println("hello(): " + hell.hello("Jeff2"));
	}
}
