package com.travix.busyflights.domain.crazair;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CrazyAirResponse {

	public static final String SUPPLIER = "CrazyAir";
    
	private String airline;
	private String price;
	private String cabinclass;
	private String departureAirportCode;
	private String destinationAirportCode;
	private String departureDate;
	private String arrivalDate;
	/**
	 * @return the airline
	 */
	public String getAirline() {
		return airline;
	}
	/**
	 * @param airline the airline to set
	 */
	public void setAirline(String airline) {
		this.airline = airline;
	}
	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/**
	 * @return the cabinclass
	 */
	public String getCabinclass() {
		return cabinclass;
	}
	/**
	 * @param cabinclass the cabinclass to set
	 */
	public void setCabinclass(String cabinclass) {
		this.cabinclass = cabinclass;
	}
	/**
	 * @return the departureAirportCode
	 */
	public String getDepartureAirportCode() {
		return departureAirportCode;
	}
	/**
	 * @param departureAirportCode the departureAirportCode to set
	 */
	public void setDepartureAirportCode(String departureAirportCode) {
		this.departureAirportCode = departureAirportCode;
	}
	/**
	 * @return the destinationAirportCode
	 */
	public String getDestinationAirportCode() {
		return destinationAirportCode;
	}
	/**
	 * @param destinationAirportCode the destinationAirportCode to set
	 */
	public void setDestinationAirportCode(String destinationAirportCode) {
		this.destinationAirportCode = destinationAirportCode;
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
	 * @return the arrivalDate
	 */
	public String getArrivalDate() {
		return arrivalDate;
	}
	/**
	 * @param arrivalDate the arrivalDate to set
	 */
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	
    public static LocalDateTime getLocalDateTime(String date) {
    	final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
        return LocalDateTime.parse(date, formatter);
    }
    
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CrazyAirResponse [airline=" + airline + ", price=" + price + ", cabinclass=" + cabinclass
				+ ", departureAirportCode=" + departureAirportCode + ", destinationAirportCode="
				+ destinationAirportCode + ", departureDate=" + departureDate + ", arrivalDate=" + arrivalDate + "]";
	}

}
