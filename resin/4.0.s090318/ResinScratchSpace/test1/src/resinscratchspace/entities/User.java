package resinscratchspace.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.inject.Initializer;
import javax.persistence.*;

@Entity()
@Table(name="Users")

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@GeneratedValue
	@Id
	protected long id;
	
	@Basic
	@Column(nullable=false)
	protected String fullName;

	@Basic
	@Column(nullable=false)
	protected String password;
	
	@Basic
	@Column(nullable=false, unique=true)
	protected String email;
	
	@Basic
	@Column(nullable=false)
	protected String friendlyName;
	
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	protected Date lastLogin;
	
	
	//@OneToMany(targetEntity=UserLogEntry.class, cascade={CascadeType.ALL})
	//@Transient
	@OneToMany
	protected Collection<UserLogEntry> logEntries;
	
	//needed for container creation
	protected User(){}
	
	@Initializer
	public User(String email, String password, String fullName, String name)
	{
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.friendlyName=name;
	}
	
	public long getId() {
		return id;
	}

	public String getFullName() {
		return fullName;
	}
	
	public String getEmail() {
		return email;
	}
	public String getFriendlyName() {
		return friendlyName;
	}
	
	public Date getLastLogin(){
		return lastLogin;
	}
	
	public void updateLastLogin(){
		this.lastLogin = new Date();
	}
	public void setLastLogin(Date value){
		this.lastLogin = value;
	}
	
	public Collection<UserLogEntry> GetLog(){	
		return this.logEntries;
	}
}
