package test2.entities;
import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Request implements Serializable{
	private static final long serialVersionUID = 1L;

	protected Request(){}
	
	public Request(Category cat, String desc){this.c=cat;this.description=desc;}
	
	@GeneratedValue
	@Id
	protected long id;
	
	@JoinColumn(name="category")
	@ManyToOne
	protected Category c;
	
	@Basic
	protected String description;
	
}
