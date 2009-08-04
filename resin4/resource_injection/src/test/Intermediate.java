package test;

import java.util.logging.Logger;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Named;

@ApplicationScoped @Named("intermed")
public class Intermediate
{
	private static final Logger log = Logger.getLogger(Intermediate.class.getName());
	
	@Ours protected OurEntityManager em;
	
	/** */
	public Intermediate()
	{
		log.info("Constructor");
	}
	
	/**
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void foo()
	{
		this.em.clear();
	}
}