package Users;

public interface checks {
	
	public boolean login(String name, String Password);
	
	public boolean check(String name);
	
	public boolean checkMail(String email);
	
}
