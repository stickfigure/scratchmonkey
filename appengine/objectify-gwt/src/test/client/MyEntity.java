/*
 * $Id$
 */

package test.client;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.googlecode.objectify.OKey;


/**
 * @author Jeff Schnitzer
 */
@Entity
public class MyEntity implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id long id;
	String blah;
	OKey<MyEntity> other;
	
	/** GAE & Objectify want this */
	public MyEntity() {}
}