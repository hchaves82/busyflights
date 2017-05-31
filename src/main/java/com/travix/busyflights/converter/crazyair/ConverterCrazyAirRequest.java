package com.travix.busyflights.converter.crazyair;


import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.travix.busyflights.domain.busyfligths.BusyFlightsRequest;
import com.travix.busyflights.domain.crazair.CrazyAirRequest;

@Component
public class ConverterCrazyAirRequest {

	public CrazyAirRequest convert(
			BusyFlightsRequest busyFlightsRequest) {
		
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		
		return new CrazyAirRequest(
				busyFlightsRequest.getOrigin(), 
				busyFlightsRequest.getDestination(),
				dateFormatter.format(busyFlightsRequest.getDepartureDate()), 
				dateFormatter.format(busyFlightsRequest.getReturnDate()), 
				busyFlightsRequest.getNumberOfPassengers());
	}
}
