package test;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.googlecode.objectify.ObjectifyService;

@Entity(name="Thing4")
public class Thing
{
	static {
		ObjectifyService.register(Thing.class);
	}
	
	public @Id Long id;
	public String value;
}
