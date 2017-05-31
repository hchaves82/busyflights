package com.travix.busyflights.converter.toughjet;


import org.springframework.stereotype.Component;

import com.travix.busyflights.domain.busyfligths.BusyFlightsRequest;
import com.travix.busyflights.domain.toughjet.ToughJetRequest;

@Component
public class ConverterToughJetRequest {

	public ToughJetRequest convert(
			BusyFlightsRequest busyFlightsRequest) {
		
		return new ToughJetRequest(
				busyFlightsRequest.getOrigin(), 
				busyFlightsRequest.getDestination(),
				String.valueOf(busyFlightsRequest.getDepartureDate().getDayOfMonth()), 
				String.valueOf(busyFlightsRequest.getDepartureDate().getMonthValue()), 
				String.valueOf(busyFlightsRequest.getDepartureDate().getYear()), 
				String.valueOf(busyFlightsRequest.getReturnDate().getDayOfMonth()), 
				String.valueOf(busyFlightsRequest.getReturnDate().getMonthValue()), 
				String.valueOf(busyFlightsRequest.getReturnDate().getYear()), 
				busyFlightsRequest.getNumberOfPassengers());
	}
}
