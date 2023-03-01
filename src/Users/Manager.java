package Users;
import static Users.User.userType.MANAGER;

import java.io.Serializable;

import gui.Main;

public class Manager extends User implements Serializable, checks{

	private static final long serialVersionUID = 1L;
	
	public static int i;
	
	public Manager() {
		type = MANAGER;
	}
	
	public float salary;
	
	public String assignType() {
		return "Manager";
	}
	
	public boolean login(String name, String pass) {
		for(i=0 ; i<Main.getmanagersList().size() ; i++) {
			if(Main.getmanagersList().get(i).getUsername().equals(name) && Main.getmanagersList().get(i).getPassword().equals(pass)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkMail(String mail) {
		int j;
		for(j=0 ; j<Main.getmanagersList().size(); j++) {
			if(Main.getmanagersList().get(j).getEmail().equals(mail))
				return true;
		}
		return false;
	}

	public boolean check(String name) {
		int j;
		for(j=0 ; j<Main.getmanagersList().size(); j++) {
			if(Main.getmanagersList().get(j).getUsername().equals(name))
				return true;
			}
		return false;
		}
	
	public static boolean bookedTrip(int j) {
		if(Main.getTicketList().get(i).getClientName().equals(Main.getPassengersList().get(Passenger.i).getUsername()))
			return true;
		return false;
	}	
}
