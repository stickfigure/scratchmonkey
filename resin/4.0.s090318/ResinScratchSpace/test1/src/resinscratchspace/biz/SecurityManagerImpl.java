package resinscratchspace.biz;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Current;

import resinscratchspace.web.LoginStatus;

@Stateless
@Local
public class SecurityManagerImpl implements SecurityManager{

	@Current
	LoginStatus loginStatus;
	
	public boolean isAuthenticated(){
		return (this.loginStatus != null && this.loginStatus.isLoggedIn());
	}
}
