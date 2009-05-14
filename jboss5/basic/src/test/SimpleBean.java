/*
 * $Id: VelocityBean.java 988 2008-12-30 08:51:13Z lhoriman $
 * $URL: http://subetha.tigris.org/svn/subetha/trunk/core/src/org/subethamail/core/admin/VelocityBean.java $
 */

package test;

import javax.annotation.Resource;
import javax.annotation.security.RunAs;
import javax.ejb.EJB;
import javax.ejb.SessionContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.ejb3.annotation.SecurityDomain;
import org.jboss.ejb3.annotation.Service;

/**
 */
@Service(objectName="test:service=Simple")
@SecurityDomain("ct")
@RunAs("siteAdmin")
public class SimpleBean implements SimpleManagement
{
	/** */
	private static Log log = LogFactory.getLog(SimpleBean.class);

	/** */
	@Resource protected SessionContext sessionContext;
	@EJB Other other;

	/**
	 */
	public void start() throws Exception
	{
		log.info("Starting simple service");
		this.other.foo();
		log.info("Done calling foo");
	}
}
