package test.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MyEntryPoint implements EntryPoint
{
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad()
	{
		LatLng cawkerCity = LatLng.newInstance(39.509, -98.434);

		MapWidget map = new MapWidget(cawkerCity, 4);
		map.setSize("100%", "100%");
		
		SplitLayoutPanel sl = new SplitLayoutPanel();
		sl.add(map);
		RootLayoutPanel.get().add(sl);

		RootLayoutPanel.get().forceLayout();
		sl.forceLayout();
		
		map.checkResize();
	}
}
