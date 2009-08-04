/*
 * $Id: EmailUtils.java 146 2006-06-14 23:32:07Z jon $
 * $Source: /cvsroot/Similarity4/src/java/com/similarity/util/Geometry.java,v $
 */

package test;

import javax.persistence.EntityManager;


/**
 * The methods we add to a regular entity manager to give ourselves
 * a "prettier" interface.
 * 
 * @author Jeff Schnitzer
 */
public class EntityManagerBase extends EntityManagerWrapper
{
	/**
	 * A normal entity manager is wrapped, providing the new methods.
	 */
	public EntityManagerBase(EntityManager base)
	{
		super(base);
	}
	
	/** Helper method makes "like" queries possible */
	public final String like(String query)
	{
		return "%" + query + "%";
	}
}
