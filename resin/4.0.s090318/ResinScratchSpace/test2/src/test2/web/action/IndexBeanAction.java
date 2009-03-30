package test2.web.action;

import java.util.List;

import javax.inject.Current;
import javax.persistence.EntityManager;

import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.util.Log;
import net.sourceforge.stripes.validation.Validate;
import test2.entities.Category;

@UrlBinding("/")
public class IndexBeanAction implements ActionBean{
	ActionBeanContext ctx;
	private static final Log log = Log.getInstance(IndexBeanAction.class);

	@Current
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
		
		return new ForwardResolution("/index.jsp");
	}
}