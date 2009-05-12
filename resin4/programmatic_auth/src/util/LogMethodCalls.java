/*
 * $Id: BeanMixin.java 1075 2009-05-07 06:41:19Z lhoriman $
 * $URL: https://subetha.googlecode.com/svn/branches/resin/rtest/src/org/subethamail/rtest/util/BeanMixin.java $
 */

package util;

import java.util.logging.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 * Interceptor which logs method calls at level INFO
 * 
 * @author Jeff Schnitzer
 */
public class LogMethodCalls
{
	@AroundInvoke
	public Object logCall(InvocationContext ctx) throws Exception
	{
		StringBuilder bld = new StringBuilder();
		bld.append(ctx.getTarget().getClass().getName());
		bld.append(".");
		bld.append(ctx.getMethod().getName());
		bld.append("(");

		boolean needsComma = false;
		for (Object param: ctx.getParameters())
		{
			if (needsComma)
				bld.append(", ");
			else
				needsComma = true;
			
			if (param == null)
				bld.append("null");
			else
				bld.append(param.toString());
		}
		
		Logger log = Logger.getLogger(ctx.getTarget().getClass().getName());
		log.info(bld.toString());
			
		return ctx.proceed();
	}

}