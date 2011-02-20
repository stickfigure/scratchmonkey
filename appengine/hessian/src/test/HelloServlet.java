package test;

import com.caucho.hessian.server.HessianServlet;


public class HelloServlet extends HessianServlet implements Hello
{
	private static final long serialVersionUID = 1L;

	@Override
	public StackTraceElement element()
	{
		return new StackTraceElement("declaringClass", "methodName", "fileName", 1);
	}
	
	@Override
	public void exception()
	{
		//return "Hello, " + name;
		throw new RuntimeException("this is something bad", new IllegalStateException("this is nested"));
	}
}
