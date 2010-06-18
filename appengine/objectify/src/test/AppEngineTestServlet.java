package test;

import java.io.IOException;
import java.util.logging.Logger;

import javax.persistence.Id;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.annotation.Cached;

@SuppressWarnings("serial")
public class AppEngineTestServlet extends HttpServlet
{
	/** */
	private static final Logger log = Logger.getLogger(AppEngineTestServlet.class.getName());

	/** */
	@Cached
	static class SimpleEntity
	{
		@Id String id;
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		String op = req.getParameter("op");
		
		resp.setContentType("text/plain");
		
		log.info("Executing doGet()");
		
		ObjectifyFactory fact = new ObjectifyFactory();
		fact.register(SimpleEntity.class);

		Objectify ofy = fact.begin();

		if ("put".equals(op))
		{
			SimpleEntity simp = new SimpleEntity();
			simp.id = "foo";
			
			ofy.put(simp);
		}
		else
		{
			ofy.get(SimpleEntity.class, "foo");
		}
	}
}
