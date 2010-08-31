package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unsuck.web.CookieUtils;

/**
 */
public class AppEngineTestServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(AppEngineTestServlet.class.getName());
	
	/** */
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		log.info("Executing doGet()");
		
		resp.setContentType("text/plain");
		PrintWriter out = resp.getWriter();
		
		String cookieName = req.getParameter("cookieName");
		if (cookieName == null)
			cookieName = "cooKey";
		
		Cookie cook = CookieUtils.getCookie(req, cookieName);

		out.println("Cookie was " + CookieUtils.toString(cook));
		
		if (cook == null)
			cook = new Cookie(cookieName, "0");

		int nextVal = Integer.parseInt(cook.getValue()) + 1;
		cook.setValue("" + nextVal);
		cook.setMaxAge(60 * 60 * 24 * 365 * 2);
		cook.setPath("/appenginetest");
		
		out.println("New value will be " + CookieUtils.toString(cook));
		
		resp.addCookie(cook);
	}
}
