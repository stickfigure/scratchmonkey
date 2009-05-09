package test2.web.action;

import java.util.List;

import javax.inject.Current;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.util.Log;
import net.sourceforge.stripes.validation.Validate;
import test2.ejbs.DBInit;
import test2.entities.Category;
import test2.services.InitDBService;

@UrlBinding("/")
public class IndexBeanAction implements ActionBean{
	ActionBeanContext ctx;
	private static final Log log = Log.getInstance(IndexBeanAction.class);

	@Current
	DBInit dbinit;
	
	@Current
	InitDBService idbs;

	@PersistenceUnit(unitName="hbm")
	EntityManagerFactory emf;
	
	@PersistenceContext(unitName="hbm")
	EntityManager em;
	
	public ActionBeanContext getContext() {
		return ctx;
	}

	public void setContext(ActionBeanContext value) {
		this.ctx = value;
	}

	@SuppressWarnings("unchecked")
	public List<Category> getCategories(){
		log.debug("returning categories");
		return (List<Category>)em.createQuery("select c from Category c").getResultList();	
	}

	@DefaultHandler
	@Validate
	public Resolution view(){
		log.debug("running default view:");		
		List<Category> cats = this.getCategories();
		log.debug("cats.size="+cats.size());
		for(Category cat : cats){
			log.debug("cat:" + cat.getName());
		}
		return new ForwardResolution("/index.jsp");
	}
}