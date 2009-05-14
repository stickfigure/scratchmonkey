package test;


public interface Echo
{
	public String echo(String stuff);
	public String echo(byte[] stuff);
	public String echo(String[] stuff);
	public String echo(Payload[] stuff);
}
