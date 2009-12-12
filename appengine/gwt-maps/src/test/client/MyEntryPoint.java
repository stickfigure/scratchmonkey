package test.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.geom.LatLng;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;

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
		DockLayoutPanel dl = new DockLayoutPanel(Unit.EM);
		
		LatLng cawkerCity = LatLng.newInstance(39.509, -98.434);

		MapWidget map = new MapWidget(cawkerCity, 4);
		map.setSize("100%", "100%");
		
		dl.add(map);
		
		RootLayoutPanel.get().add(dl);
	}
}
