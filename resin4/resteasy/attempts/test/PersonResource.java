package test;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Named;
import javax.context.RequestScoped;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.jboss.resteasy.annotations.Form;

import com.googlecode.htmleasy.RedirectException;

@Path("/person")
public class PersonResource
{
	@Data public static class PersonData
	{
		@PathParam("id") Long id;
		@FormParam("nickname") String nickname;
		Map<String, String> errors;
	}

	/** 
	 * Using the return value as the name of the view to render.  This is not bad,
	 * although it doesn't seem quite as natural as returning the PersonData
	 * and this method is only good for text/html. Also, since JSR299 creates the
	 * PersonData object, it means we have to populate it field-by-field. */
	@GET @Path("/{id}")
	@Produces("text/html")
	public String getPerson(@RequestScoped @Named("model") @Form PersonData model)
	{
		PersonData p = database.loadPerson(model.id);
		model.nickname = p.nickname;
		
		return "/person.jsp";
	}

	/** Form processing isn't too bad */
	@POST @Path("/{id}")
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public String submitPerson(@RequestScoped @Named("model") @Form PersonData data) throws RedirectException
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
			
			return "/person_edit.jsp";
		}
	}

	/**
	 * Here's an example of something that wouldn't work, though.  You mentioned having
	 * an API to do JSP (or whatever) forwards - you can't do this within the body of
	 * the submitPerson method because the transaction hasn't committed yet. This isn't
	 * so obvious a problem when doing POST-AND-REDIRECT but POST-AND-FORWARD is a big
	 * problem. */
	@POST @Path("/{id}")
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void submitPerson(@RequestScoped @Named("model") @Form PersonData data) throws RedirectException
	{
		if (data.nickname.length() > 0)
		{
			... // save the data
			
			// It's not safe to do this because the transaction commit could fail when
			// we leave this method.
			SpecialAPI.forward("/save_successful.jsp");
		}
		else
		{
			data.errors = new HashMap<String, String>();
			data.errors.put("nickname", "Must not be empty");
			
			SpecialAPI.forward("/person_edit.jsp");
		}
	}
}
