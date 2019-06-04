package vmd;

import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;

public class LogoutVmd {
	
	@Command("logout")
	public void logout(){
		Sessions.getCurrent().removeAttribute("user");
		Executions.getCurrent().sendRedirect("/login.zul");
		
	}

}
