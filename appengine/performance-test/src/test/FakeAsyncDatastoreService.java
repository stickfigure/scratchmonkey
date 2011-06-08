package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

import com.google.appengine.api.datastore.AsyncDatastoreService;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyRange;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.QueryResultIterable;
import com.google.appengine.api.datastore.QueryResultIterator;
import com.google.appengine.api.datastore.QueryResultList;
import com.google.appengine.api.datastore.Transaction;

/**
 * Just returns a stock set of Entities for the query
 */
public class FakeAsyncDatastoreService implements AsyncDatastoreService
{
	static List<Entity> RESULTS = new ArrayList<Entity>();
	static {
		for (int i=1; i<=10000; i++)
		{
			Entity ent = new Entity(Thing.class.getAnnotation(javax.persistence.Entity.class).name(), i);
			ent.setProperty("value", "thing" + i);
			RESULTS.add(ent);
		}
	}
	
	@Override
	public PreparedQuery prepare(Transaction txn, Query query)
	{
		return new PreparedQuery() {
			
			@Override
			public int countEntities(FetchOptions fetchOptions)
			{
				return 0;
			}
			
			@Override
			public int countEntities()
			{
				return 0;
			}
			
			@Override
			public Entity asSingleEntity() throws TooManyResultsException
			{
				return null;
			}
			
			@Override
			public QueryResultList<Entity> asQueryResultList(FetchOptions fetchOptions)
			{
				return null;
			}
			
			@Override
			public QueryResultIterator<Entity> asQueryResultIterator(FetchOptions fetchOptions)
			{
				final Iterator<Entity> it = RESULTS.iterator();
				return new QueryResultIterator<Entity>() {

					@Override
					public boolean hasNext()
					{
						return it.hasNext();
					}

					@Override
					public Entity next()
					{
						return it.next();
					}

					@Override
					public void remove()
					{
					}

					@Override
					public Cursor getCursor()
					{
						return null;
					}
				};
			}
			
			@Override
			public QueryResultIterator<Entity> asQueryResultIterator()
			{
				return null;
			}
			
			@Override
			public QueryResultIterable<Entity> asQueryResultIterable(final FetchOptions fetchOptions)
			{
				return new QueryResultIterable<Entity>() {

					@Override
					public QueryResultIterator<Entity> iterator()
					{
						return asQueryResultIterator(fetchOptions);
					}
				};
			}
			
			@Override
			public QueryResultIterable<Entity> asQueryResultIterable()
			{
				return null;
			}
			
			@Override
			public List<Entity> asList(FetchOptions fetchOptions)
			{
				return RESULTS;
			}
			
			@Override
			public Iterator<Entity> asIterator(FetchOptions fetchOptions)
			{
				return RESULTS.iterator();
			}
			
			@Override
			public Iterator<Entity> asIterator()
			{
				return RESULTS.iterator();
			}
			
			@Override
			public Iterable<Entity> asIterable(FetchOptions fetchOptions)
			{
				return RESULTS;
			}
			
			@Override
			public Iterable<Entity> asIterable()
			{
				return RESULTS;
			}
		};
	}


	@Override
	public Collection<Transaction> getActiveTransactions()
	{
		return null;
	}

	@Override
	public Transaction getCurrentTransaction()
	{
		return null;
	}

	@Override
	public Transaction getCurrentTransaction(Transaction returnedIfNoTxn)
	{
		return null;
	}

	@Override
	public PreparedQuery prepare(Query query)
	{
		return null;
	}


	@Override
	public Future<Transaction> beginTransaction()
	{
		return null;
	}


	@Override
	public Future<Entity> get(Key paramKey)
	{
		return null;
	}


	@Override
	public Future<Entity> get(Transaction paramTransaction, Key paramKey)
	{
		return null;
	}


	@Override
	public Future<Map<Key, Entity>> get(Iterable<Key> paramIterable)
	{
		return null;
	}


	@Override
	public Future<Map<Key, Entity>> get(Transaction paramTransaction, Iterable<Key> paramIterable)
	{
		return null;
	}


	@Override
	public Future<Key> put(Entity paramEntity)
	{
		return null;
	}


	@Override
	public Future<Key> put(Transaction paramTransaction, Entity paramEntity)
	{
		return null;
	}


	@Override
	public Future<List<Key>> put(Iterable<Entity> paramIterable)
	{
		return null;
	}


	@Override
	public Future<List<Key>> put(Transaction paramTransaction, Iterable<Entity> paramIterable)
	{
		return null;
	}


	@Override
	public Future<Void> delete(Key... paramArrayOfKey)
	{
		return null;
	}


	@Override
	public Future<Void> delete(Transaction paramTransaction, Key... paramArrayOfKey)
	{
		return null;
	}


	@Override
	public Future<Void> delete(Iterable<Key> paramIterable)
	{
		return null;
	}


	@Override
	public Future<Void> delete(Transaction paramTransaction, Iterable<Key> paramIterable)
	{
		return null;
	}


	@Override
	public Future<KeyRange> allocateIds(String paramString, long paramLong)
	{
		return null;
	}


	@Override
	public Future<KeyRange> allocateIds(Key paramKey, String paramString, long paramLong)
	{
		return null;
	}

}
