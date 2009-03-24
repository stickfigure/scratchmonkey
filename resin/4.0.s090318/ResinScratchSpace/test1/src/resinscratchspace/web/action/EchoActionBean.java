package resinscratchspace.web.action;

import javax.context.SessionScoped;
import javax.inject.Current;

import resinscratchspace.web.AbstractActionBean;

import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.util.Log;
import net.sourceforge.stripes.validation.Validate;

@UrlBinding("/echo/{$event}")
@SessionScoped
public class EchoActionBean extends AbstractActionBean {
	private static final Log log = Log.getInstance(EchoActionBean.class);

	@Current
	private resinscratchspace.util.EchoService echoSvc;
	
	private String echo = "";

	@Validate
	protected void setEchoString(String v){ this.echo = v;}
	
	public String getEcho(){return this.echo;}
	
	@DefaultHandler
	public Resolution view(){
		return new ForwardResolution("/echo.jsp");
	}
	
	@HandlesEvent("echo")
	public Resolution echo(){
		this.echo = echoSvc.echo(echo);
		log.debug(getEcho());
		return new ForwardResolution("/echo.jsp");
	}	
}
