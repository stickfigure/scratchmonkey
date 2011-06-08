package test;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.AsyncDatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceConfig;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;

@SuppressWarnings("serial")
public class FakeFetchServlet extends HttpServlet
{
	/** */
	private static final Logger log = Logger.getLogger(FakeFetchServlet.class.getName());

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/plain");
		
		ObjectifyFactory fact = new ObjectifyFactory() {
			@Override
			protected AsyncDatastoreService getRawAsyncDatastoreService(DatastoreServiceConfig cfg)
			{
				return new FakeAsyncDatastoreService();
			}
		};
		
		fact.register(Thing.class);

		long time = System.currentTimeMillis();
		
		Objectify ofy = fact.begin();
		
		List<Thing> things = ofy.query(Thing.class).list();
		
		long elapsed = System.currentTimeMillis() - time;
			
		log.info("Elapsed millis: " + elapsed);
		
		resp.getWriter().print("Fetched " + things.size() + " things in " + elapsed + " millis");
	}
}
