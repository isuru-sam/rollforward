package com.rollforward;

public class RollForwardCommand implements Runnable {

	
	public RollForwardCommand(String flightId, String userName) {
		
		this.flightId = flightId;
		this.userName = userName;
	}

	String flightId;
	String userName;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
System.out.println("Rollforward for flightid"+flightId+userName);
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
