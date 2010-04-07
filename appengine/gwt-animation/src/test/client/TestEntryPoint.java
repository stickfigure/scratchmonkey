package test.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class TestEntryPoint implements EntryPoint
{

	@Override
	public void onModuleLoad()
	{
		LayoutPanel top = new LayoutPanel();
		RootLayoutPanel.get().add(top);

		FlowPanel red = new FlowPanel();
		red.getElement().getStyle().setBackgroundColor("red");
		top.add(red);

		FlowPanel green = new FlowPanel();
		green.getElement().getStyle().setBackgroundColor("green");
		top.add(green);
	}
}
