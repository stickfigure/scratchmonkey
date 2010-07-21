package test;

import java.io.IOException;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.mail.Message.RecipientType;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(loadOnStartup=1, urlPatterns="/go")
public class GoServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(GoServlet.class.getName());

	@Inject Session mailSession;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		log.info("Executing request");
		try
		{
			this.go();
		}
		catch (Exception e)
		{
			throw new ServletException(e);
		}
	}

	protected void go() throws Exception
	{
		log.info("Enqueueing");

		MimeMessage msg = new MimeMessage(mailSession);
		msg.setSubject("the subject");
		msg.setText("the body");
		msg.setRecipients(RecipientType.TO, "jeff@infohazard.org");
		
		Transport.send(msg);
	}
}
