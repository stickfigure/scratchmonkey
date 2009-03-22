package resinscratchspace.entities;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Initializer;
import javax.inject.New;
import javax.persistence.*;


@Entity
@Table(name="UserLogEntries")
public class UserLogEntry {
	//@Current
	@New
	private Logger log = Logger.getLogger(UserLogEntry.class.getName());	
	
	@GeneratedValue
	@Id
	protected long id;

	@ManyToOne(targetEntity=User.class, fetch=FetchType.EAGER, optional=false)
	protected User user;
	
	@Column(nullable=false)
	protected String event;
	
	protected UserLogEntry(){}
	
	@Initializer
	public UserLogEntry(User user, String event){
		this.user=user;
		this.event=event;
		log.log(Level.INFO, "Created new UserLogEntry (" + user + "," + event + ")");
	}
	
	public String getEvent(){
		return event;
	}
}
