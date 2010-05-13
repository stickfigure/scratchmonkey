package test;

import java.io.IOException;
import java.util.logging.Logger;

import javax.persistence.Id;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Transaction;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.annotation.Cached;
import com.googlecode.objectify.impl.CachingDatastoreService;

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

		ObjectifyFactory fact = new ObjectifyFactory();
		
		// Need to register it so the entity kind becomes cacheable
		fact.register(SimpleEntity.class);
		
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		ds = new CachingDatastoreService(fact, ds);

		// This is the weirdest thing.  If you change the *name* of one of these two keys, the test passes.
		// If the keys have the same *name*, the test fails because ent3 has the "original" property.  WTF??
		com.google.appengine.api.datastore.Key parentKey = KeyFactory.createKey("SimpleParent", "asdf");
		com.google.appengine.api.datastore.Key childKey = KeyFactory.createKey(parentKey, "SimpleEntity", "asdf");
		
		Entity ent1 = new Entity(childKey);
		ent1.setProperty("foo", "original");
		ds.put(ent1);

		// Start transaction
		Transaction txn = ds.beginTransaction();
		Entity ent2;
		try {
			ent2 = ds.get(txn, childKey);
			ent2.setProperty("foo", "changed");
			ds.put(txn, ent2);
			txn.commit();
		} finally {
			if (txn.isActive())
				txn.rollback();
		}

		Entity ent3 = ds.get(childKey);
		
		if (!"changed".equals(ent3.getProperty("foo")))
			throw new IllegalStateException("Not changed!  Still " + ent3);
	}
}
