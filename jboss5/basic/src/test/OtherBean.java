/*
 * $Id: VelocityBean.java 988 2008-12-30 08:51:13Z lhoriman $
 * $URL: http://subetha.tigris.org/svn/subetha/trunk/core/src/org/subethamail/core/admin/VelocityBean.java $
 */

package test;

import java.security.Principal;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.ejb3.annotation.SecurityDomain;

/**
 */
@Stateless
@SecurityDomain("ct")
@RolesAllowed("siteAdmin")
public class OtherBean implements Other, OtherRemote
{
	/** */
	private static Log log = LogFactory.getLog(OtherBean.class);

	/** */
	@Resource protected SessionContext sessionContext;
	
	public void foo()
	{
		log.info("########## foo()");
		
		Principal p = this.sessionContext.getCallerPrincipal();
		if (p == null)
			log.info("########## principal is null");
		else
			log.info("########## principal name is: " + p.getName());
	}
}
