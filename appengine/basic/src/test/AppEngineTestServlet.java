package test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class AppEngineTestServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/plain");
		
		String urlStr = "http://pushproxy.mobcasting.us/api/pushToApple?msg=Ivan+Dobbs%3A+Yet+again&deviceToken=eb26259073c553a269e09569d7533afc3d05b41e48759bfb81940f591164f784&badge=2";
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestProperty("Authorization", "Basic PUTAUTHSTRINGHERE");
		
		resp.getWriter().println("Response was: " + conn.getResponseCode() + " " + conn.getResponseMessage());
	}
}
