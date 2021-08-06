package project1services;

import project1models.User;

public interface UserServices {
	
	public Boolean UserLoginCheck(String userName, String passWord);
	
	public User getUser (Integer userID);
	
	public Integer getUserId (String userName);
	
}
