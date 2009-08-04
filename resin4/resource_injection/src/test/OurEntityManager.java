/*
 * $Id: EmailUtils.java 146 2006-06-14 23:32:07Z jon $
 * $Source: /cvsroot/Similarity4/src/java/com/similarity/util/Geometry.java,v $
 */

package test;

import javax.persistence.EntityManager;

/**
 * Gives us a prettier interface.
 * 
 * @author Jeff Schnitzer
 */
public class OurEntityManager extends EntityManagerBase
{
	/**
	 * A normal entity manager is wrapped, providing the new methods.
	 */
	public OurEntityManager(EntityManager base)
	{
		super(base);
	}
}
