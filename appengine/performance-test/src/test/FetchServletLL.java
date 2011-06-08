package test;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Query;

@SuppressWarnings("serial")
public class FetchServletLL extends HttpServlet
{
	/** */
	private static final Logger log = Logger.getLogger(FetchServletLL.class.getName());

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/plain");

		long time = System.currentTimeMillis();

		List<Entity> things = 
			DatastoreServiceFactory.getDatastoreService()
				.prepare(new Query(Thing.class.getAnnotation(javax.persistence.Entity.class).name()))
				.asList(FetchOptions.Builder.withDefaults());

		for (Entity ent: things)
		{
			ent.getKey();
			ent.getProperty("value");
		}
		
		long elapsed = System.currentTimeMillis() - time;
			
		log.info("Elapsed millis: " + elapsed);
		
		resp.getWriter().print("Fetched " + things.size() + " things in " + elapsed + " millis");
	}
}
