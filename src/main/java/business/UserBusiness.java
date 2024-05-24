package business;

import beans.User;
import dao.DataSource;

public interface UserBusiness {
	public boolean determineExistant(User user);
	}
