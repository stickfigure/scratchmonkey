package test;

import test.client.MyEntity;
import test.client.Test;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class TestService extends RemoteServiceServlet implements Test
{
	private static final long serialVersionUID = 1L;

	@Override
	public MyEntity blah(MyEntity other)
	{
		return other;
	}
}
