package com.travix.busyflights.domain.busyfligths;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BusyFlightsResponse {

	private String airline;
	private String supplier;
	private BigDecimal fare;
	private String departureAirportCode;
	private String destinationAirportCode;
	private LocalDateTime departureDate;
	private LocalDateTime arrivalDate;
	
	public BusyFlightsResponse () {
	}
	
	public BusyFlightsResponse (String airline, String supplier, BigDecimal fare,
			String departureAirportCode, String destinationAirportCode,
			LocalDateTime departureDate, LocalDateTime arrivalDate) {
		this.airline = airline;
		this.supplier = supplier;
		this.fare = fare;
		this.destinationAirportCode = destinationAirportCode;
		this.departureAirportCode = departureAirportCode;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
	}
	
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
	 * @return the supplier
	 */
	public String getSupplier() {
		return supplier;
	}
	/**
	 * @param supplier the supplier to set
	 */
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	/**
	 * @return the fare
	 */
	public BigDecimal getFare() {
		return fare;
	}
	/**
	 * @param fare the fare to set
	 */
	public void setFare(BigDecimal fare) {
		this.fare = fare;
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
	public LocalDateTime getDepartureDate() {
		return departureDate;
	}
	/**
	 * @param departureDate the departureDate to set
	 */
	public void setDepartureDate(LocalDateTime departureDate) {
		this.departureDate = departureDate;
	}
	/**
	 * @return the arrivalDate
	 */
	public LocalDateTime getArrivalDate() {
		return arrivalDate;
	}
	/**
	 * @param arrivalDate the arrivalDate to set
	 */
	public void setArrivalDate(LocalDateTime arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BusyFlightsResponse [airline=" + airline + ", supplier=" + supplier + ", fare=" + fare
				+ ", departureAirportCode=" + departureAirportCode + ", destinationAirportCode="
				+ destinationAirportCode + ", departureDate=" + departureDate + ", arrivalDate=" + arrivalDate + "]";
	}
	

}
