/*
 * $Id$
 */

package test.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * @author Jeff Schnitzer
 */
public interface TestAsync
{
	void blah(MyEntity other, AsyncCallback<MyEntity> callback);
}