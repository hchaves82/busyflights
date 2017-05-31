package com.travix.busyflights.converter.toughjet;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.travix.busyflights.domain.busyfligths.BusyFlightsResponse;
import com.travix.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.busyflights.format.datetime.DateFormatterBusyFlights;

@Component
public class ConverterToughJetResponse {

	private DateFormatterBusyFlights dateFormatterBusyFlights;
	
	@Autowired
	public ConverterToughJetResponse(DateFormatterBusyFlights dateFormatterBusyFlights) {
		this.dateFormatterBusyFlights = dateFormatterBusyFlights;
	}
	
	public BusyFlightsResponse convert(ToughJetResponse toughJetResponse) {
		
		LocalDateTime departureDate = ToughJetResponse.getLocalDateTime(
				toughJetResponse.getDepartureYear(), 
				toughJetResponse.getDepartureMonth(), 
				toughJetResponse.getDepartureDay());
		LocalDateTime arrivalDate = ToughJetResponse.getLocalDateTime(
				toughJetResponse.getReturnYear(), 
				toughJetResponse.getReturnMonth(), 
				toughJetResponse.getReturnDay());
		
		return new BusyFlightsResponse(
				toughJetResponse.getCarrier(), 
				ToughJetResponse.SUPPLIER, 
				toughJetResponse.getPrice(), 
				toughJetResponse.getDepartureAirportName(), 
				toughJetResponse.getArrivalAirportName(), 
				dateFormatterBusyFlights.parse(departureDate), 
				dateFormatterBusyFlights.parse(arrivalDate));
	}
}
