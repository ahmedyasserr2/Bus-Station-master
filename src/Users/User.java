package Users;

import java.io.Serializable;

public abstract class User implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public enum userType{
		DRIVER,
		MANAGER,
		PASSENGER
	}
	
	public String fName, lName;
	private String username;
	private String password;
	private String email;
	protected userType type;
	public int age;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public userType getType() {
		return type;
	}
	
	public void setType(userType type) {
		this.type = type;
	}
	
	public abstract String assignType();
}
