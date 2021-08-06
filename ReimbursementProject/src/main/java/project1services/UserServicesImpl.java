package project1services;

import project1dao.UserDaoImpl;
import project1models.User;

public class UserServicesImpl implements UserServices{
	static UserDaoImpl udi = new UserDaoImpl();

	public Boolean UserLoginCheck(String userName, String passWord) {
		// TODO Auto-generated method stub
		return udi.UserLoginCheck(userName, passWord);
	}

	@Override
	public User getUser(Integer userID) {
		// TODO Auto-generated method stub
		return udi.getUser(userID);
	}

	@Override
	public Integer getUserId(String userName) {
		// TODO Auto-generated method stub
		return udi.getUserID(userName);
	}

}
