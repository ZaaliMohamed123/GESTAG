package dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.User;

public class UserDaoImplOrcl {
	Connection cnx;
	
	public UserDaoImplOrcl(DataSource ds) {
		cnx=ds.getConnection();
	}
	public User selectUser(String userName,String password) {
		User user = null;
		try {
			String query = "SELECT * FROM RH_USER WHERE"
					+ " username = '" +userName + "' AND "
					+ "password = '" + password + "'";
			Statement st = cnx.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			
			if (rs.next()) {
				user=new User(rs.getInt(1),userName,password);
			}
			   st.close();
	            rs.close();
			cnx.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return user;
	}
}
