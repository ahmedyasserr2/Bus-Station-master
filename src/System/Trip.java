package System;

import java.io.Serializable;

public class Trip implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public enum tripType {
		Internal,
		External
	}
	
	public int day, month, year;
	public int busCode;
	public String driver;
	
	private String source, destination;
	private int tripCode;
	private double price;
	private int tripFlavor; //Non Stop = 0 , One Stop = 1 , More Stops = 2
	private boolean ticketType; //Round = True , One Way = False
	public int availableSeats, seats;
	
	final static private int tripFactor = 10;
	
	public String getSource() {
		return source;
	}
	
	public void setSource(String source) {
		this.source = source;
	}
	
	public int getTripCode() {
		return tripCode;
	}
	
	public void setTripCode(int tripCode) {
		this.tripCode = tripCode;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getTripFlavor() {
		return tripFlavor;
	}
	
	public void setTripFlavor(int tripFlavor) {
		this.tripFlavor = tripFlavor;
	}
	
	public boolean isTicketType() {
		return ticketType;
	}
	
	public void setTicketType(boolean ticketType) {
		this.ticketType = ticketType;
	}

	public static int getTripfactor() {
		return tripFactor;
	}
	
	public String getDateString() {
		return(Integer.toString(day) + " " + Integer.toString(month) + " " + Integer.toString(year));
	}	
	
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
		this.seats = availableSeats;
	}
}
