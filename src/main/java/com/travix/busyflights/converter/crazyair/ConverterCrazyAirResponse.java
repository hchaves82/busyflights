package com.travix.busyflights.converter.crazyair;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.travix.busyflights.domain.busyfligths.BusyFlightsResponse;
import com.travix.busyflights.domain.crazair.CrazyAirResponse;
import com.travix.busyflights.format.datetime.DateFormatterBusyFlights;

@Component
public class ConverterCrazyAirResponse {
	
	private DateFormatterBusyFlights dateFormatterBusyFlights;
	
	@Autowired
	public ConverterCrazyAirResponse(DateFormatterBusyFlights dateFormatterBusyFlights) {
		this.dateFormatterBusyFlights = dateFormatterBusyFlights;
	}

	public BusyFlightsResponse convert(
			CrazyAirResponse crazyAirResponse) {
		
		LocalDateTime departureDate = CrazyAirResponse.getLocalDateTime(crazyAirResponse.getDepartureDate());
		LocalDateTime arrivalDate = CrazyAirResponse.getLocalDateTime(crazyAirResponse.getArrivalDate());
	
		return new BusyFlightsResponse(
				crazyAirResponse.getAirline(), 
				CrazyAirResponse.SUPPLIER, 
				new BigDecimal(crazyAirResponse.getPrice().replaceAll(",", ".")).setScale(2), 
				crazyAirResponse.getDepartureAirportCode(), 
				crazyAirResponse.getDestinationAirportCode(), 
				dateFormatterBusyFlights.parse(departureDate), 
				dateFormatterBusyFlights.parse(arrivalDate));
	}

}
