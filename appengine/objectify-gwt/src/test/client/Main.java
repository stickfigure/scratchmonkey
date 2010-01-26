package test.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.googlecode.objectify.OKey;

public class Main implements EntryPoint
{
	TestAsync test = GWT.create(Test.class);
	
	@Override
	public void onModuleLoad()
	{
		MyEntity ent = new MyEntity();
		ent.id = 123;
		ent.other = new OKey<MyEntity>(MyEntity.class, 456);
		ent.blah = "blah string";
		
		test.blah(ent, new AsyncCallback<MyEntity>() {
			@Override
			public void onFailure(Throwable caught)
			{
				Window.alert("It failed");
			}

			@Override
			public void onSuccess(MyEntity result)
			{
				Window.alert("It worked, the other key is " + result.other);
			}
		});
	}
}
