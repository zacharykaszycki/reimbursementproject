package project1dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

//import example.dao.CustomConnectionFactory;
import project1models.Reimbursement;
import project1models.User;

public class UserDaoImpl implements UserDao{
	static final Logger loggy = Logger.getLogger(UserDaoImpl.class);
	String url = "jdbc:postgresql://revbase.ctlzafcs0hn5.us-east-2.rds.amazonaws.com/ersdb";
	String username = "revbase";
	String password = "p4ssw0rd";
	
	public Boolean UserLoginCheck(String userName, String passWord) {
		loggy.info("SOMEONE IS TRYING TO LOG IN");
		//CHECK FOR EXISTENCE OF A
		Boolean bool = null;
		try(Connection conn = CustomConnectionFactory.getConnection()){
			String sql = "SELECT EXISTS (SELECT * FROM ers_users WHERE ers_username = ? AND ers_password = ?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, passWord);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				bool = rs.getBoolean(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			loggy.error("SQL exception has been triggered", e);
		}
		return bool;
	}

	public User getUser(Integer userID) {
		User user = null;
		try(Connection conn = CustomConnectionFactory.getConnection()){
			String sql = "SELECT A.ers_users_id, A.ers_username, A.user_first_name, A.user_last_name, A.user_email, B.user_role FROM ers_users  A INNER JOIN ers_user_roles B ON A.user_role_id = B.user_role_id WHERE ers_users_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
//				this.ersUsersId = ersUsersId;
//				this.ersUserName = ersUserName;
//				this.userFirstName = userFirstName;
//				this.userLastName = userLastName;
//				this.userEmail = userEmail;
//				this.userRoleId = userRoleId;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			loggy.error("SQL exception has been triggered", e);
		}
		return user;
	}

	@Override
	public Integer getUserID(String userName) {
		Integer userId = 0;
		try(Connection conn = CustomConnectionFactory.getConnection()){
			String sql = "SELECT ers_users_id FROM ers_users WHERE ers_username = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				userId = (rs.getInt(1));
//				this.ersUsersId = ersUsersId;
//				this.ersUserName = ersUserName;
//				this.userFirstName = userFirstName;
//				this.userLastName = userLastName;
//				this.userEmail = userEmail;
//				this.userRoleId = userRoleId;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			loggy.error("SQL exception has been triggered", e);
		}
		return userId;
	}
	
	

}
