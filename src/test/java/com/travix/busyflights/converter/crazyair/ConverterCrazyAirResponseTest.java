package com.travix.busyflights.converter.crazyair;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.travix.busyflights.domain.busyfligths.BusyFlightsResponse;
import com.travix.busyflights.domain.crazair.CrazyAirResponse;
import com.travix.busyflights.format.datetime.DateFormatterBusyFlights;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConverterCrazyAirResponse.class, DateFormatterBusyFlights.class})
public class ConverterCrazyAirResponseTest {

	@Autowired
	ConverterCrazyAirResponse converterCrazyAirResponse;
	
	@Test
	public void testConvert () {
		
		CrazyAirResponse crazyAirResponse = new CrazyAirResponse();
		crazyAirResponse.setAirline("Air France");
		crazyAirResponse.setArrivalDate("06-12-2017 20:30:00");  //mm-dd-yyyy HH:MM:ss
		crazyAirResponse.setDepartureDate("06-12-2017 18:00:00"); //mm-dd-yyyy HH:MM:ss
		crazyAirResponse.setPrice("200,00");
		
		BusyFlightsResponse response = converterCrazyAirResponse.convert(crazyAirResponse);
		
		LocalDateTime dtCrazyAirArrival = CrazyAirResponse.getLocalDateTime(crazyAirResponse.getArrivalDate());
		LocalDateTime dtCrazyAirDeparture = CrazyAirResponse.getLocalDateTime(crazyAirResponse.getDepartureDate());
		
		DateTimeFormatter dtFormatBusyFlightsResponse = 
				DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'").withZone(ZoneOffset.UTC);
		LocalDateTime expectedDateArrival = LocalDateTime.parse(
				dtCrazyAirArrival.format(dtFormatBusyFlightsResponse), dtFormatBusyFlightsResponse);
		LocalDateTime expectedDateDeparture = LocalDateTime.parse(
				dtCrazyAirDeparture.format(dtFormatBusyFlightsResponse), dtFormatBusyFlightsResponse);
		
		Assert.assertEquals(crazyAirResponse.getAirline(), response.getAirline());
		Assert.assertEquals(expectedDateArrival, response.getArrivalDate());
		Assert.assertEquals(expectedDateDeparture, response.getDepartureDate());
		Assert.assertEquals(new BigDecimal(
				crazyAirResponse.getPrice().replaceAll(",", ".")).setScale(2), response.getFare());
	}
}
