package resinscratchspace.entities;

import java.io.Serializable;

import javax.inject.Initializer;
import javax.persistence.*;


@Entity
@Table(name="UserLogEntries")
public class UserLogEntry implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue
	@Id
	protected long id;

	@ManyToOne(optional=false, targetEntity=User.class)
	//@OneToOne(mappedBy="userlogentry")\
	//@JoinColumn(referencedColumnName="id",name="user_id")
	protected User user;
	
	@Column(nullable=false)
	protected String event;
	
	protected UserLogEntry(){}
	
	@Initializer
	public UserLogEntry(User user, String event){
		this.user=user;
		this.event=event;
		//log.log(Level.INFO, "Created new UserLogEntry (" + user + "," + event + ")");
	}
	
	public String getEvent(){
		return event;
	}
	
	public long getId(){return this.id;}
	public User getUser(){return this.user;}
	
	public String toString(){
		return (user.getFriendlyName() + "(" + user.getId()  + "): " + event);
		
	}
	
}
