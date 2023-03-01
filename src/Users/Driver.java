package Users;
import static Users.User.userType.DRIVER;

import java.io.Serializable;

import gui.Main;

public class Driver extends User implements checks, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static int i;
	
	public Driver() {
		type = DRIVER;
	}
	
	
	private float rating;
	public int numOfTrips;
	
	@Override
	public String assignType() {
		return "Driver";
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}
	
	@Override
	public boolean login(String name, String pass) {
		for(i=0 ; i<Main.getdriversList().size() ; i++) {
			if(Main.getdriversList().get(i).getUsername().equals(name) && Main.getdriversList().get(i).getPassword().equals(pass)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean check(String name) {
		int j;
		for(j=0 ; j<Main.getdriversList().size(); j++) {
			if(Main.getdriversList().get(j).getUsername().equals(name))
				return true;
		}
		return false;
	}

	@Override
	public boolean checkMail(String email) {
		int j;
		for(j=0 ; j<Main.getdriversList().size(); j++) {
			if(Main.getdriversList().get(j).getEmail().equals(email))
				return true;
		}
		return false;
	}

}
