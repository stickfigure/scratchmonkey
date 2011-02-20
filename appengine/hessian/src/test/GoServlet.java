package test;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unsuck.hessian.ThrowableSerializerFactory;

import com.caucho.hessian.client.HessianProxyFactory;

@SuppressWarnings("serial")
public class GoServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/plain");

		String url = "http://localhost:8888/hello";

		HessianProxyFactory factory = new HessianProxyFactory();
		factory.setHessian2Request(true);
		factory.getSerializerFactory().addFactory(new ThrowableSerializerFactory());
		Hello hell = (Hello)factory.create(Hello.class, url);

//		StackTraceElement ele = hell.element();
//		resp.getWriter().println(ele);
		
		hell.exception();
		resp.getWriter().println("it worked");
	}
}
