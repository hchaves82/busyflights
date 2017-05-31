package com.travix.busyflights.converter.toughjet;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.travix.busyflights.domain.busyfligths.BusyFlightsRequest;
import com.travix.busyflights.domain.toughjet.ToughJetRequest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ConverterToughJetRequest.class})
public class ConverterToughJetRequestTest {

	@Autowired
	ConverterToughJetRequest converterToughJetRequest;
	
	@Test
	public void testConvert () {
		
		LocalDateTime date = LocalDateTime.of
				(2017, 6, 2, 15, 30);
		
		BusyFlightsRequest request = new BusyFlightsRequest();
		request.setDepartureDate(date);
		request.setReturnDate(date.plusDays(5).plusHours(10).plusMinutes(10));
		request.setOrigin("LGW");
		request.setDestination("GRU");
		request.setNumberOfPassengers(3);
		
		ToughJetRequest toughJetRequest = converterToughJetRequest.convert(request);
		Assert.assertEquals("LGW", toughJetRequest.getFrom());
		Assert.assertEquals("GRU", toughJetRequest.getTo());
		Assert.assertEquals("2", toughJetRequest.getDepartureDay());
		Assert.assertEquals("6", toughJetRequest.getDepartureMonth());
		Assert.assertEquals("2017", toughJetRequest.getDepartureYear());
		Assert.assertEquals("8", toughJetRequest.getReturnDay());
		Assert.assertEquals("6", toughJetRequest.getReturnMonth());
		Assert.assertEquals("2017", toughJetRequest.getReturnYear());
		Assert.assertEquals(3, toughJetRequest.getNumberOfAdults().intValue());
	}
}
