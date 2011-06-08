package test;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.googlecode.objectify.ObjectifyService;

@Entity(name="Thing4")
public class Thing
{
	/** Never do this in production */
	static {
		ObjectifyService.register(Thing.class);
	}
	
	public @Id Long id;
	public Long getId() { return this.id; }
	
	public String value;
	public String getValue() { return this.value; }
}
