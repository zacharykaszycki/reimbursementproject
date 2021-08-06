package project1dao;

import java.util.List;

import project1models.Reimbursement;
import project1models.User;

public interface UserDao {

	public Boolean UserLoginCheck (String userName, String passWord);
	
	public User getUser(Integer userID);
		
	public Integer getUserID(String userName);
}
