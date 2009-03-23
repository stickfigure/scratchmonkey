/*
 * $Id: VelocityBean.java 988 2008-12-30 08:51:13Z lhoriman $
 * $URL: http://subetha.tigris.org/svn/subetha/trunk/core/src/org/subethamail/core/admin/VelocityBean.java $
 */

package test;

import org.jboss.ejb3.annotation.Management;

/**
 */
@Management
public interface SimpleManagement
{
	/**
	 */
	public void start() throws Exception;
}
