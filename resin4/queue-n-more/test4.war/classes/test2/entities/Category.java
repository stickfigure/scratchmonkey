package test2.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category implements Serializable{
	private static final long serialVersionUID = 1L;

	protected Category(){}
	/*
	 * public constructor for a new named category
	 */
	public Category(String name) {this.name = name;}
	
	@SuppressWarnings("unused")
	@GeneratedValue
	@Id
	private long id;

	@Column
	private String name;
	/*
	 * Returns the category name
	 * 
	 */
	public String getName(){ return this.name;}
}
