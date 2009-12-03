package test;

import com.caucho.hessian.server.HessianServlet;


public class HelloServlet extends HessianServlet implements Hello
{
	private static final long serialVersionUID = 1L;

	@Override
	public String hello(String name)
	{
		return "Hello, " + name;
	}
}
