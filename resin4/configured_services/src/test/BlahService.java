package test;

import java.util.logging.Logger;

import javax.context.ApplicationScoped;

@ApplicationScoped
public class BlahService implements Blah
{
	private static final Logger log = Logger.getLogger(BlahService.class.getName());
	
	String suffix = "-defaultSuffix";
	public void setSuffix(String value) { this.suffix = value; }

	public String blah(String s)
	{
		log.info("Blahing: " + s);

		return s + suffix;
	}
}
