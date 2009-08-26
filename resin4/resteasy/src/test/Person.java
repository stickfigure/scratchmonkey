package test;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.jboss.resteasy.annotations.Form;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.googlecode.htmleasy.RedirectException;
import com.googlecode.htmleasy.ViewWith;

/**
 * 
 * @author Jeff Schnitzer <jeff@infohazard.org>
 */
@Path("/person")
public class Person
{
	private final static Logger log = LoggerFactory.getLogger(Person.class);
	
	static Map<Long, String> people = new HashMap<Long, String>();
	static {
		people.put(12L, "bob");
	}
	
	@ViewWith("/person.jsp")
	public static class PersonData
	{
		@PathParam("id")
		Long id;
		public Long getId() { return this.id; }
		
		@FormParam("nickname")
		String nickname;
		public String getNickname() { return this.nickname; }
		
		Map<String, String> errors;
		public Map<String, String> getErrors() { return this.errors; }
	}

	@GET @Path("/{id}")
	public PersonData getPerson(@PathParam("id") Long id)
	{
		log.info("Getting Person with id " + id);
		
		PersonData pers = new PersonData();
		pers.id = id;
		pers.nickname = people.get(id);
		
		return pers;
	}

	@GET @Path("/{id}/edit")
	@ViewWith(ifClass=Object.class, value="/person_edit.jsp")
	public PersonData editPerson(@PathParam("id") Long id)
	{
		return this.getPerson(id);
	}
	
	/** A little backwards from what you are used to; we return a PersonData on failure */
	@POST @Path("/{id}")
	@ViewWith("/person_edit.jsp")
	public PersonData submitPerson(@Form PersonData data) throws RedirectException
	{
		if (data.getNickname().length() > 0)
		{
			people.put(data.id, data.getNickname());
			throw new RedirectException("/person/" + data.id);
		}
		else
		{
			data.errors = new HashMap<String, String>();
			data.errors.put("nickname", "Must not be empty");
			
			return data;
		}
	}
}
