package Users;
import static Users.User.userType.PASSENGER;

import java.io.Serializable;

import gui.Main;

public class Passenger extends User implements checks, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public static int i;
	
	public Passenger() {
		type = PASSENGER;
		numOfTrips = 0;
		isDeleted = false;
	}
	public int numOfTrips;
	private boolean isDeleted;
	
	public String assignType() {
		return "Passenger";
	}

	public boolean login(String name, String pass) {
		for(i=0 ; i<Main.getPassengersList().size() ; i++) {
			if(Main.getPassengersList().get(i).getUsername().equals(name) && Main.getPassengersList().get(i).getPassword().equals(pass)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean check(String name) {
		int j;
		for(j=0 ; j<Main.getPassengersList().size(); j++) {
			if(Main.getPassengersList().get(j).getUsername().contentEquals(name))
				return true;
		}
		return false;
	}
	
	public boolean checkMail(String mail) {
		int j;
		for(j=0 ; j<Main.getPassengersList().size(); j++) {
			if(Main.getPassengersList().get(j).getEmail().equals(mail))
				return true;
		}
		return false;
	}
	
	public static boolean bookedTrip(int j) {
		if(Main.getTicketList().get(i).getClientName().equals(Main.getPassengersList().get(Passenger.i).getUsername()))
			return true;
		return false;
	}
	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
}
