package com.travix.busyflights.converter.crazyair;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.travix.busyflights.domain.busyfligths.BusyFlightsRequest;
import com.travix.busyflights.domain.crazair.CrazyAirRequest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConverterCrazyAirRequest.class})
public class ConverterCrazyAirRequestTest {

	@Autowired
	ConverterCrazyAirRequest converterCrazyAirRequest;
	
	@Test
	public void testConvert () {
		LocalDateTime date = LocalDateTime.of
				(2017, 6, 2, 15, 30);
		
		BusyFlightsRequest request = new BusyFlightsRequest();
		request.setDepartureDate(date);
		request.setReturnDate(date.plusDays(10).plusMinutes(10));
		request.setOrigin("LHR");
		request.setDestination("AMS");
		request.setNumberOfPassengers(2);
		
		CrazyAirRequest crazyAirRequest = converterCrazyAirRequest.convert(request);
		
		Assert.assertEquals("06-02-2017", crazyAirRequest.getDepartureDate());
		Assert.assertEquals("06-12-2017", crazyAirRequest.getReturnDate());
		Assert.assertEquals("LHR", crazyAirRequest.getOrigin());
		Assert.assertEquals("AMS", crazyAirRequest.getDestination());
		Assert.assertEquals(2, crazyAirRequest.getNumberOfPassengers().intValue());
	}
}
