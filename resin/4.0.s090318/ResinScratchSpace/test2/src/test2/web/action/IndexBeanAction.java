package test2.web.action;

import java.util.List;

import javax.inject.Current;
import javax.persistence.EntityManager;

import test2.entities.Category;

import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.validation.Validate;

@UrlBinding("/{$event}")
public class IndexBeanAction implements ActionBean{
	ActionBeanContext ctx;

	@Current
	EntityManager em;
	
	public ActionBeanContext getContext() {
		return ctx;
	}

	public void setContext(ActionBeanContext value) {
		this.ctx = value;
	}

	@SuppressWarnings("unchecked")
	public List<Category> listCategories(){
		return (List<Category>)em.createQuery("select c from Category c").getResultList();	
	}
	
	@DefaultHandler
	@Validate
	public Resolution view(){
		return new ForwardResolution("/index.jsp");
		
	}
}
