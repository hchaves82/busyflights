package com.travix.busyflights.converter.toughjet;

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
import com.travix.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.busyflights.format.datetime.DateFormatterBusyFlights;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConverterToughJetResponse.class, DateFormatterBusyFlights.class})
public class ConverterToughJetResponseTest {

	@Autowired
	ConverterToughJetResponse converterToughJetResponse;
	
	@Test
	public void testConvert () {
		
		ToughJetResponse toughJetResponse = new ToughJetResponse();
		toughJetResponse.setCarrier("British Airways");;
		toughJetResponse.setBasePrice("200");
		toughJetResponse.setTax("50");
		toughJetResponse.setDiscount("10");
		toughJetResponse.setDepartureDay("10");  
		toughJetResponse.setDepartureMonth("1");  
		toughJetResponse.setDepartureYear("2018");  
		toughJetResponse.setReturnDay("15");  
		toughJetResponse.setReturnMonth("1");  
		toughJetResponse.setReturnYear("2018");  
		
		LocalDateTime dtToughJetDeparture = ToughJetResponse.getLocalDateTime(
				toughJetResponse.getDepartureYear(), toughJetResponse.getDepartureMonth(),
				toughJetResponse.getDepartureDay());
		LocalDateTime dtToughJetReturn = ToughJetResponse.getLocalDateTime(
				toughJetResponse.getReturnYear(), toughJetResponse.getReturnMonth(),
				toughJetResponse.getReturnDay());
		
		DateTimeFormatter dtFormatBusyFlightsResponse = 
				DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'").withZone(ZoneOffset.UTC);
		LocalDateTime expectedDateDeparture = LocalDateTime.parse(
				dtToughJetDeparture.format(dtFormatBusyFlightsResponse), dtFormatBusyFlightsResponse);
		LocalDateTime expectedDateReturn = LocalDateTime.parse(
				dtToughJetReturn.format(dtFormatBusyFlightsResponse), dtFormatBusyFlightsResponse);
		
		BusyFlightsResponse response = converterToughJetResponse.convert(toughJetResponse);
		
		Assert.assertEquals(toughJetResponse.getCarrier(), response.getAirline());
		Assert.assertEquals(expectedDateDeparture, response.getDepartureDate());
		Assert.assertEquals(expectedDateReturn, response.getArrivalDate());
		Assert.assertEquals(new BigDecimal("225").setScale(2), response.getFare());
	}
}
