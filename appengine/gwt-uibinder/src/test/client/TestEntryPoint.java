package test.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class TestEntryPoint implements EntryPoint
{
	@Override
	public void onModuleLoad()
	{
		FlowPanel holder = new FlowPanel();
		holder.getElement().getStyle().setHeight(100, Unit.PCT);
		holder.getElement().getStyle().setWidth(100, Unit.PCT);
		TestPanel tp = new TestPanel();
		tp.getElement().getStyle().setHeight(100, Unit.PCT);
		tp.getElement().getStyle().setWidth(100, Unit.PCT);
		holder.add(tp);
		RootLayoutPanel.get().add(holder);
		
		//RootLayoutPanel.get().add(new TestPanel());
	}
}
