package test.client;

import com.google.appengine.api.datastore.GeoPt;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.googlecode.objectify.Key;

public class Main implements EntryPoint
{
	TestAsync test = GWT.create(Test.class);
	
	@Override
	public void onModuleLoad()
	{
		MyEntity ent = new MyEntity();
		ent.id = 123;
		ent.other = new Key<MyEntity>(MyEntity.class, 456);
		ent.blah = "blah string";
		ent.geo = new GeoPt(37,	-122);
		ent.key = KeyFactory.createKey("SomeKind", 789);
		
		test.blah(ent, new AsyncCallback<MyEntity>() {
			@Override
			public void onFailure(Throwable caught)
			{
				Window.alert("It failed");
			}

			@Override
			public void onSuccess(MyEntity result)
			{
				Window.alert("It worked, the entity is " + result);
			}
		});
	}
}
