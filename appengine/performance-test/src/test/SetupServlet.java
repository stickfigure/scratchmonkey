package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;
import com.google.appengine.api.taskqueue.TaskOptions.Method;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

@SuppressWarnings("serial")
public class SetupServlet extends HttpServlet
{
	/** */
	private static final Logger log = Logger.getLogger(SetupServlet.class.getName());

	public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/plain");
		
		if (req.getParameter("run") == null)
			this.createTask(resp);
		else
			this.runTask(resp);
	}
	
	private void createTask(HttpServletResponse resp) throws IOException
	{
		QueueFactory.getDefaultQueue().add(TaskOptions.Builder.withUrl("/setup?run=true").method(Method.GET));
		
		resp.getWriter().print("Created task");
	}
	
	private void runTask(HttpServletResponse resp) throws IOException
	{
		Objectify ofy = ObjectifyService.begin();
		
		for (int i=0; i<100; i++)
		{
			List<Thing> ten = new ArrayList<Thing>();
			
			for (int j=0; j<100; j++)
			{
				long number = (i*100 + j) + 1;
				
				Thing th = new Thing();
				th.id = number;
				th.value = "thing" + number;
				ten.add(th);
			}
			
			ofy.put(ten);
			
			log.fine("Created batch " + i);
		}
		
		log.info("Created 10,000 things");
	}
}
