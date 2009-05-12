package test;

import java.util.logging.Logger;

import com.caucho.security.BasicLogin;
import com.caucho.security.MemorySingleSignon;

public class OurLogin extends BasicLogin
{
	private static final Logger log = Logger.getLogger(OurLogin.class.getName());

	public OurLogin()
	{
		MemorySingleSignon mss;
		mss = new MemorySingleSignon();
		mss.init();
		this._singleSignon = mss;
		
		log.info("MemorySingleSignon is " + mss);
	}
}
