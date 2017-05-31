package com.travix.busyflights.domain.crazair;

public class CrazyAirRequest {

    private String origin;
    private String destination;

    private String departureDate;
    private String returnDate;

    private Integer numberOfPassengers;
    
    public CrazyAirRequest() {
    	
    }
    
	public CrazyAirRequest(String origin, String destination, String departureDate, 
			String returnDate, Integer numberOfPassengers) {
    	this.origin = origin;
    	this.destination = destination;
    	this.departureDate = departureDate;
    	this.returnDate = returnDate;
    	this.numberOfPassengers = numberOfPassengers;
    }

	/**
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * @return the departureDate
	 */
	public String getDepartureDate() {
		return departureDate;
	}

	/**
	 * @param departureDate the departureDate to set
	 */
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	/**
	 * @return the returnDate
	 */
	public String getReturnDate() {
		return returnDate;
	}

	/**
	 * @param returnDate the returnDate to set
	 */
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	/**
	 * @return the numberOfPassengers
	 */
	public Integer getNumberOfPassengers() {
		return numberOfPassengers;
	}

	/**
	 * @param numberOfPassengers the numberOfPassengers to set
	 */
	public void setNumberOfPassengers(Integer numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}
    
    
}
