package resinscratchspace.util;

import java.util.logging.Logger;

import com.googlecode.condistripes.ConDIActionResolver;

public class ScratchActionResolver extends ConDIActionResolver {
	//@Current
	@SuppressWarnings("unused")
	private Logger log = Logger.getLogger(ScratchActionResolver.class.getName());	
	
    @Override
    public String getBindingSuffix() { return ".s"; }

}
