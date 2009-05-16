package test;

import java.io.Serializable;


public class Payload implements Serializable, Cloneable
{
	private static final long serialVersionUID = 1L;

	public Payload()
	{
		this.foo = "foo";
		this.bar = "bar";
	}
	
	public String foo;
	public String bar;
	
	public String toString()
	{
		return "Payload {" + this.foo + ", " + this.bar + "}";
	}
}
