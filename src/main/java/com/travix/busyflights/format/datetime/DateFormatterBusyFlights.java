package com.travix.busyflights.format.datetime;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

@Component
public class DateFormatterBusyFlights {
	
	private DateTimeFormatter dtFormatBusyFlightsResponse = 
				DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'").withZone(ZoneOffset.UTC);
	
	public String format(LocalDateTime date) {
		return date.format(dtFormatBusyFlightsResponse);
	}
	
	public LocalDateTime parse (LocalDateTime date) {
		return LocalDateTime.parse(format(date), dtFormatBusyFlightsResponse);
	}
}
