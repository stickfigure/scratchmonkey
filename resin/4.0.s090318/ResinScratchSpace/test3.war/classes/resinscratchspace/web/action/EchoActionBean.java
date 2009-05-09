package resinscratchspace.web.action;

import javax.annotation.Named;
import javax.context.SessionScoped;
import javax.inject.Current;

import resinscratchspace.web.AbstractActionBean;

import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.util.Log;
import net.sourceforge.stripes.validation.Validate;

@UrlBinding("/echo/{$event}")
@SessionScoped
@Named("echo")
public class EchoActionBean extends AbstractActionBean {
//	@Current
//	private Log log;
	private static final Log log = Log.getInstance(EchoActionBean.class);

	@Current
	private resinscratchspace.util.EchoService echoSvc;
	
	@Validate
	private String echoString = "replaceme";


	protected void setEchoString(String v){ this.echoString = v;}
	
	public String getEchoString(){return this.echoString;}
	
	@DontValidate
	@DefaultHandler
	public Resolution view(){
		return new ForwardResolution("/echo.jsp");
	}
	
	@Validate
	@HandlesEvent("echo")
	public Resolution echo(){
		this.echoString = echoSvc.echo(this.echoString);
		log.debug(getEchoString());
		return new ForwardResolution("/echo.jsp");
	}	
}
