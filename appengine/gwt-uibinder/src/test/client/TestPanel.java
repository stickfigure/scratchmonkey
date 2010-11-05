package test.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class TestPanel extends Composite
{
	private static TestPanelUiBinder uiBinder = GWT.create(TestPanelUiBinder.class);
	interface TestPanelUiBinder extends UiBinder<Widget, TestPanel> {}

	@UiField Label stuff;

	public TestPanel()
	{
//		FlowPanel holder = new FlowPanel();
//		holder.add(uiBinder.createAndBindUi(this));
//		this.initWidget(holder);
		this.initWidget(uiBinder.createAndBindUi(this));
		
		stuff.setText("blah!");
	}
}
