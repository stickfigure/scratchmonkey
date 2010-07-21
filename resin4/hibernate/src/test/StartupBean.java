package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Named("startup")
@ApplicationScoped
@Startup
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class StartupBean
{
	private static final Logger log = Logger.getLogger(StartupBean.class.getName());
	
	@Inject EntityManager em;
	
	@Inject @Named("jdbc/subetha") DataSource ds;
	
	/** */
	public StartupBean()
	{
	}

	/** */
	@PostConstruct
	public void start() throws Exception
	{
		this.go();
	}
	
	/** */
	public void go() throws Exception
	{
		log.info("Starting");
		
		Connection conn = this.ds.getConnection();
		ResultSet rs = conn.createStatement().executeQuery("select * from Thing where id = 'first'");
		if (rs.next())
			log.info("####### First value was: " + rs.getString("value"));
		else
			log.info("####### There was no first value");
		
		rs.close();
		conn.close();
		
		
		Thing th = this.em.find(Thing.class, "first");
		
		log.info("##################### Loaded Thing('first') is " + th);
		
		if (th == null)
		{
			th = new Thing("first", "stuff");
			this.em.persist(th);
			log.info("#################### Created Thing");
		}
	}
}
