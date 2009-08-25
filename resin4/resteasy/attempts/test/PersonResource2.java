package test;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.jboss.resteasy.annotations.Form;

@Path("/person")
public class PersonResource2
{
	@View("/person.jsp")	// default rendering view
	@Data public static class PersonData
	{
		@PathParam("id") Long id;
		@FormParam("nickname") String nickname;
		Map<String, String> errors;
	}

	/** Simple and straightforward; rendering HTML is just like rendering JSON or XML */
	@GET @Path("/{id}")
	public PersonData getPerson(@PathParam("id") Long id)
	{
		return database.loadPerson(id);
	}

	/** Using JSR299 for form processing */
	@POST @Path("/{id}")
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public View submitPerson(@RequestScoped @Named("model") @Form PersonData data) throws RedirectException
	{
		if (data.nickname.length() > 0)
		{
			... // save the data
			throw new RedirectException("/person/" + data.id);
		}
		else
		{
			data.errors = new HashMap<String, String>();
			data.errors.put("nickname", "Must not be empty");
			
			return new View("/person_edit.jsp");
		}
	}
}
