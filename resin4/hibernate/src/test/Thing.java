/*
 * $Id: Config.java 988 2008-12-30 08:51:13Z lhoriman $
 * $URL: http://subetha.tigris.org/svn/subetha/branches/resin/core/src/org/subethamail/entity/Config.java $
 */

package test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * A random thing.
 *
 * @author Jeff Schnitzer
 */
@Entity
//@Cache(usage=CacheConcurrencyStrategy.TRANSACTIONAL)
public class Thing
{
	/** */
	@Id
	public String id;

	/** */
	@Column
	public String value;

	/**
	 */
	public Thing() {}

	/**
	 */
	public Thing(String id, String value)
	{
		this.id = id;
		this.value = value;
	}

	/** */
	@Override
	public String toString()
	{
		return this.getClass() + " {id=" + this.id + "}";
	}
}

