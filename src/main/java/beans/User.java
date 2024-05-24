package beans;

public class User {
	int user_id;
	String userName;
	String password;
	public User(int user_id, String userName, String password) {
		super();
		this.user_id = user_id;
		this.userName = userName;
		this.password = password;
	}
	
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", userName=" + userName + ", password=" + password + "]";
	}
	
}
