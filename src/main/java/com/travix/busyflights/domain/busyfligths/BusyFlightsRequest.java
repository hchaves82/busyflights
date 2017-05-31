package com.travix.busyflights.domain.busyfligths;

import java.time.LocalDateTime;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BusyFlightsRequest {

	@NotNull
	@Size(min = 3, max = 3, message = "The origin must contain 3 letters")
	private String origin;
	@NotNull
	@Size(min = 3, max = 3, message = "The destination must contain 3 letters")
	private String destination;
	@NotNull
	private LocalDateTime departureDate;
	@NotNull
	private LocalDateTime returnDate;
	@NotNull
	@Min(value = 1, message = "The minimum number of passengers allowed is 1")
	@Max(value = 4, message = "The maximum number of passengers allowed is 4")
	private Integer numberOfPassengers;
	
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
	 * @return the returnDate
	 */
	public LocalDateTime getReturnDate() {
		return returnDate;
	}
	/**
	 * @param returnDate the returnDate to set
	 */
	public void setReturnDate(LocalDateTime returnDate) {
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
