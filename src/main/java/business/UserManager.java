package business;

import beans.User;
import dao.UserDaoImplOrcl;

public class UserManager implements UserBusiness{
	private UserDaoImplOrcl usr; 
		
	public UserManager() {
	}

	public UserManager(UserDaoImplOrcl usr) {
		this.usr = usr;
	}

	public boolean determineExistant(User user) {
		if(usr.selectUser(user.getUserName(), user.getPassword()) == null) {
			return false;
		}
		else if(usr.selectUser(user.getUserName(), user.getPassword()).getUserName().equals(user.getUserName()) && usr.selectUser(user.getUserName(), user.getPassword()).getPassword().equals(user.getPassword())) {
			return true;
		}
		return false;
	}
}
