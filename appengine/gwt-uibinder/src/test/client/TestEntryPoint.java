package test.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class TestEntryPoint implements EntryPoint
{
	@Override
	public void onModuleLoad()
	{
		RootLayoutPanel.get().add(new TestPanel());
	}
}
