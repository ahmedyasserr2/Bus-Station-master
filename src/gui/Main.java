package gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import Users.Passenger;
import Users.Manager;
import Users.Driver;
import System.Trip;
import System.Bus;
import System.Tickets;

public class Main {
	
	private static final long serialVersionUID = 1L;
	
	private static ArrayList<Passenger> passengersList = new ArrayList<Passenger>();
	private static ArrayList<Manager> managersList = new ArrayList<Manager>();
	private static ArrayList<Driver> driversList = new ArrayList<Driver>();
	private static ArrayList<Trip> tripList = new ArrayList<Trip>();
	private static ArrayList<Tickets> ticketList = new ArrayList<Tickets>();
	private static ArrayList<Bus> busList = new ArrayList<Bus>();


	
	//For Passengers
	
	public static ArrayList<Passenger> getPassengersList() {
		return passengersList;
	}

	public static void setPassengersList() {
		
		try {
			FileInputStream passengersFile = new FileInputStream("database\\passengersFile.ser");
			ObjectInputStream passengersObject = new ObjectInputStream(passengersFile);
			
			while(passengersObject.available()>-1) {
				Main.passengersList.add((Passenger) passengersObject.readObject());
			}
			
			passengersObject.close();
			passengersFile.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Passengers file not found");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Passengers class not found");
		}
	}
	
	public static void writeToFilePassengersList() {
		try {
			FileOutputStream passengersFile = new FileOutputStream("database\\passengersFile.ser");
			ObjectOutputStream passengersObject = new ObjectOutputStream(passengersFile);

			for(int i = 0 ; i < Main.getPassengersList().size() ; i++)
				passengersObject.writeObject(Main.getPassengersList().get(i));
			
			passengersObject.close();
			passengersFile.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Passengers file not found");
		} catch (IOException e) {
			System.out.println("Passengers File Read");
		}	

	}

	
	//For Managers
	
	public static ArrayList<Manager> getmanagersList() {
		return managersList;
	}

	public static void setmanagersList() {
		try {
			FileInputStream managersFile = new FileInputStream("database\\managersFile.ser");
			ObjectInputStream managersObject = new ObjectInputStream(managersFile);
			
			while(managersObject.available()>-1) {
				Main.managersList.add((Manager) managersObject.readObject());
			}
			
			managersObject.close();
			managersFile.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Managers file not found");
		} catch (IOException e) {
			System.out.println("Managers File Read");
		} catch (ClassNotFoundException e) {
			System.out.println("Managers class not found");
		}
	}
	
	public static void writeToFileManagersList() {
		try {
			FileOutputStream managersFile = new FileOutputStream("database\\managersFile.ser");
			ObjectOutputStream managersObject = new ObjectOutputStream(managersFile);
			System.out.println("Done...");

			for(int i = 0 ; i < Main.getmanagersList().size() ; i++)
				managersObject.writeObject(Main.getmanagersList().get(i));
			
			managersObject.close();
			managersFile.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Managers write file not found");
		} catch (IOException e) {
			System.out.println("Managers File Read");
		}	

	}

	
	//For Drivers
	
	public static ArrayList<Driver> getdriversList() {
		return driversList;
	}

	public static void setdriversList() {
		try {
			FileInputStream driversFile = new FileInputStream("database\\driversFile.ser");
			ObjectInputStream driversObject = new ObjectInputStream(driversFile);
			
			while(driversObject.available()>-1) {
				Main.driversList.add((Driver) driversObject.readObject());
			}
			
			driversObject.close();
			driversFile.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Drivers file not found");
		} catch (IOException e) {
			System.out.println("Drivers File Read");
		} catch (ClassNotFoundException e) {
			System.out.println("Drivers class not found");
		}
	}
	
	public static void writeToFileDriversList() {
		try {
			FileOutputStream driversFile = new FileOutputStream("database\\driversFile.ser");
			ObjectOutputStream driversObject = new ObjectOutputStream(driversFile);

			for(int i = 0 ; i < Main.getdriversList().size() ; i++)
				driversObject.writeObject(Main.getdriversList().get(i));
			
			driversObject.close();
			driversFile.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Drivers file not found");
		} catch (IOException e) {
			System.out.println("Drivers File Read");
		}	

	}

	
	//For Trips
	
	public static ArrayList<Trip> getTripList() {
		return tripList;
	}

	public static void setTripList() {
		try {
			FileInputStream tripsFile = new FileInputStream("database\\tripsFile.ser");
			ObjectInputStream tripsObject = new ObjectInputStream(tripsFile);
			
			while(tripsObject.available()>-1) {
				Main.tripList.add((Trip) tripsObject.readObject());
			}
			
			tripsObject.close();
			tripsFile.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Trips file not found");
		} catch (IOException e) {
			System.out.println("Trips File Read");
		} catch (ClassNotFoundException e) {
			System.out.println("Trips class not found");
		}
	}
	
	public static void writeToTripList() {
		try {
			FileOutputStream tripsFile = new FileOutputStream("database\\tripsFile.ser");
			ObjectOutputStream tripsObject = new ObjectOutputStream(tripsFile);

			for(int i = 0 ; i < Main.getTripList().size() ; i++)
				tripsObject.writeObject(Main.getTripList().get(i));
			
			tripsObject.close();
			tripsFile.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Trips file not found");
		} catch (IOException e) {
			System.out.println("Trips File Read");
		}	

	}

	
	//For Tickets
	
	public static ArrayList<Tickets> getTicketList() {
		return ticketList;
	}

	public static void setTicketList() {
		try {
			FileInputStream ticketsFile = new FileInputStream("database\\ticketsFile.ser");
			ObjectInputStream ticketsObject = new ObjectInputStream(ticketsFile);
			
			while(ticketsObject.available()>-1) {
				Main.ticketList.add((Tickets) ticketsObject.readObject());
			}
			
			ticketsObject.close();
			ticketsFile.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Tickets file not found");
		} catch (IOException e) {
			System.out.println("Tickets File Read");
		} catch (ClassNotFoundException e) {
			System.out.println("Tickets class not found");
		}
	}
	
	public static void writeToTicketList() {
		try {
			FileOutputStream ticketsFile = new FileOutputStream("database\\ticketsFile.ser");
			ObjectOutputStream ticketsObject = new ObjectOutputStream(ticketsFile);

			for(int i = 0 ; i < Main.getTicketList().size() ; i++)
				ticketsObject.writeObject(Main.getTicketList().get(i));
			
			ticketsObject.close();
			ticketsFile.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Tickets file not found");
		} catch (IOException e) {
			System.out.println("Tickets File Read");
		}	

	}
	

	//For Bus
	
	public static ArrayList<Bus> getBusList() {
		return busList;
	}

	public static void setBusList() {
		try {
			FileInputStream busFile = new FileInputStream("database\\busFile.ser");
			ObjectInputStream busObject = new ObjectInputStream(busFile);
			
			while(busObject.available()>-1) {
				Main.busList.add((Bus) busObject.readObject());
			}
			
			busObject.close();
			busFile.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Bus file not found");
		} catch (IOException e) {
			System.out.println("Bus File Read");
		} catch (ClassNotFoundException e) {
			System.out.println("Bus class not found");
		}
	}
	
	public static void writeToBusList() {
		try {
			FileOutputStream busFile = new FileOutputStream("database\\busFile.ser");
			ObjectOutputStream busObject = new ObjectOutputStream(busFile);

			for(int i = 0 ; i < Main.getBusList().size() ; i++)
				busObject.writeObject(Main.getBusList().get(i));
			
			busObject.close();
			busFile.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Tickets file not found");
		} catch (IOException e) {
			System.out.println("Tickets File Read");
		}	

	}
	//.......................................................................................................//
	
	public static void save() {
		writeToFileDriversList();
		writeToFileManagersList();
		writeToFilePassengersList();
		writeToTicketList();
		writeToTripList();
		writeToBusList();
	}
	
	
	public static void main(String[] args) {
		
		Main.setPassengersList();
		Main.setdriversList();
		Main.setmanagersList();
		Main.setTripList();
		Main.setTicketList();
		Main.setBusList();
		
		login Login = new login();
		Login.frame.setVisible(true);
	}
}
