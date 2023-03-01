package System;

import java.io.Serializable;

public class Bus implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public Bus()  {
		
	}
	
	public Bus(int n, busType t) {
		setType(t);
		setNumOfSeats(n);
	}
	
	public enum busType{
		BUS,
		MINIBUS,
		LIMOUSINE
	}
	
	private int busCode;
    private busType type;
    private int numOfSeats;
    
	public int getBusCode() {
		return busCode;
	}
	
	public void setBusCode(int busCode) {
		this.busCode = busCode;
	}

	public busType getType() {
		return type;
	}

	public void setType(busType type) {
		this.type = type;
	}

	public int getNumOfSeats() {
		return numOfSeats;
	}

	public void setNumOfSeats(int numOfSeats) {
		this.numOfSeats = numOfSeats;
	}
}
