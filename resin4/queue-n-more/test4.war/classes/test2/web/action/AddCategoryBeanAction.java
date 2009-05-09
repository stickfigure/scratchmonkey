package test2.web.action;

import java.util.List;

import javax.inject.Current;
import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import net.sourceforge.stripes.action.*;
import net.sourceforge.stripes.util.Log;
import net.sourceforge.stripes.validation.Validate;
import test2.entities.Category;

@UrlBinding("/add/{catName}")
public class AddCategoryBeanAction implements ActionBean{
	ActionBeanContext ctx;
	private static final Log log = Log.getInstance(AddCategoryBeanAction.class);

	@Current UserTransaction ut;
	
	@Validate 
	private String catName;
	
	public void setCatName(String value){this.catName=value;}
	public String getCatName() {return this.catName;}
	
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
	public Resolution add() throws IllegalStateException, SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException, NotSupportedException{
		log.debug("running default view:");
		//this.em.getTransaction().begin();
		ut.begin();
		this.em.persist(new Category(this.catName));
		this.em.flush();
		ut.commit();
		
		//this.em.getTransaction().commit();
		log.debug("added new cat:" + this.catName);
		
		return new ForwardResolution("/index.jsp");
	}
}