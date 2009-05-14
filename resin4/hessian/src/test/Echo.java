package test;

import java.net.URL;


public interface Echo
{
	public String echo(String stuff);
	public String echo(byte[] stuff);
	public String echo(String[] stuff);
	public String echo(Payload[] stuff);
	public String echo(URL stuff);
}
