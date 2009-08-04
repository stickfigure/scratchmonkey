/*
 * $Id: EmailUtils.java 146 2006-06-14 23:32:07Z jon $
 * $Source: /cvsroot/Similarity4/src/java/com/similarity/util/Geometry.java,v $
 */

package test;

import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.Query;

/**
 * Simple wrapper of all EntityManager methods. 
 * 
 * @author Jeff Schnitzer
 */
public class EntityManagerWrapper implements EntityManager
{
	/** */
	EntityManager base;
	
	/**
	 * Wraps the base entity manager
	 */
	public EntityManagerWrapper(EntityManager base)
	{
		this.base = base;
	}
	
	public EntityManager getBase()
	{
		return this.base;
	}

	@Override
	public void persist(Object arg0)
	{
		this.base.persist(arg0);
	}

	@Override
	public <T> T merge(T arg0)
	{
		return this.base.merge(arg0);
	}

	@Override
	public void remove(Object arg0)
	{
		this.base.remove(arg0);
	}

	@Override
	public <T> T find(Class<T> arg0, Object arg1)
	{
		return this.base.find(arg0, arg1);
	}

	@Override
	public <T> T getReference(Class<T> arg0, Object arg1)
	{
		return this.base.getReference(arg0, arg1);
	}

	@Override
	public void flush()
	{
		this.base.flush();
	}

	@Override
	public void setFlushMode(FlushModeType arg0)
	{
		this.base.setFlushMode(arg0);
	}

	@Override
	public FlushModeType getFlushMode()
	{
		return this.base.getFlushMode();
	}

	@Override
	public void lock(Object arg0, LockModeType arg1)
	{
		this.base.lock(arg0, arg1);
	}

	@Override
	public void refresh(Object arg0)
	{
		this.base.refresh(arg0);
	}

	@Override
	public void clear()
	{
		this.base.clear();
	}

	@Override
	public boolean contains(Object arg0)
	{
		return this.base.contains(arg0);
	}

	@Override
	public Query createQuery(String arg0)
	{
		return this.base.createNamedQuery(arg0);
	}

	@Override
	public Query createNamedQuery(String arg0)
	{
		return this.base.createNamedQuery(arg0);
	}

	@Override
	public Query createNativeQuery(String arg0)
	{
		return this.base.createNativeQuery(arg0);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Query createNativeQuery(String arg0, Class arg1)
	{
		return this.base.createNativeQuery(arg0, arg1);
	}

	@Override
	public Query createNativeQuery(String arg0, String arg1)
	{
		return this.createNativeQuery(arg0, arg1);
	}

	@Override
	public void joinTransaction()
	{
		this.base.joinTransaction();
	}

	@Override
	public Object getDelegate()
	{
		return this.base.getDelegate();
	}

	@Override
	public void close()
	{
		this.base.clear();
	}

	@Override
	public boolean isOpen()
	{
		return this.base.isOpen();
	}

	@Override
	public EntityTransaction getTransaction()
	{
		return this.base.getTransaction();
	}
	
	@Override
	public void clear(Object arg0)
	{
		this.base.clear(arg0);
	}

	@Override
	public <T> T find(Class<T> arg0, Object arg1, LockModeType arg2)
	{
		return this.base.find(arg0, arg1, arg2);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T find(Class<T> arg0, Object arg1, LockModeType arg2, Map arg3)
	{
		return this.base.find(arg0, arg1, arg2, arg3);
	}

	@Override
	public EntityManagerFactory getEntityManagerFactory()
	{
		return this.base.getEntityManagerFactory();
	}

	@Override
	public LockModeType getLockMode(Object arg0)
	{
		return this.base.getLockMode(arg0);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Map getProperties()
	{
		return this.base.getProperties();
	}

	@Override
	public Set<String> getSupportedProperties()
	{
		return this.base.getSupportedProperties();
	}

	@Override
	@SuppressWarnings("unchecked")
	public void lock(Object arg0, LockModeType arg1, Map arg2)
	{
		this.base.lock(arg0, arg1, arg2);
	}

	@Override
	public void refresh(Object arg0, LockModeType arg1)
	{
		this.base.refresh(arg0, arg1);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void refresh(Object arg0, LockModeType arg1, Map arg2)
	{
		this.base.refresh(arg0, arg1, arg2);
	}
}
