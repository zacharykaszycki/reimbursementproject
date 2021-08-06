package project1models;

public class User {
	private Integer ersUsersId;
	private String ersUserName;
	private String userFirstName;
	private String userLastName;
	private String userEmail;
	private String userRole;
	
	
	public User(Integer ersUsersId, String ersUserName,  String userFirstName, String userLastName,
			String userEmail, String userRole) {
		super();
		this.ersUsersId = ersUsersId;
		this.ersUserName = ersUserName;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userRole = userRole;
	}
	public Integer getErsUsersId() {
		return ersUsersId;
	}
	public String getErsUserName() {
		return ersUserName;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public String getUserRoleId() {
		return userRole;
	}
	@Override
	public String toString() {
		return "User [ersUsersId=" + ersUsersId + ", ersUserName=" + ersUserName + ", userFirstName=" + userFirstName
				+ ", userLastName=" + userLastName + ", userEmail=" + userEmail + ", userRole=" + userRole + "]";
	}
	
	
	
	
}


