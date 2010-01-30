/*
 * $Id$
 */

package test.client;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.google.appengine.api.datastore.GeoPt;
import com.googlecode.objectify.Key;


/**
 * @author Jeff Schnitzer
 */
@Entity
public class MyEntity implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id long id;
	String blah;
	Key<MyEntity> other;
	GeoPt geo;
	com.google.appengine.api.datastore.Key key;
	
	/** GAE & Objectify want this */
	public MyEntity() {}
	
	public String toString()
	{
		return this.getClass().getName() + "{"
			+ "other=" + other + ","
			+ "geo=" + geo + ","
			+ "key=" + key + ","
			+ "}";
	}
}