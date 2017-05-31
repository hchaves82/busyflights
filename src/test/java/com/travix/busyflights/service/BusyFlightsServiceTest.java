package com.travix.busyflights.service;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.scheduling.annotation.AsyncResult;

import com.travix.busyflights.domain.busyfligths.BusyFlightsRequest;
import com.travix.busyflights.domain.busyfligths.BusyFlightsResponse;
import com.travix.busyflights.service.provider.ProviderService;

@RunWith(MockitoJUnitRunner.class)
public class BusyFlightsServiceTest {

	@Mock
	private ProviderService crazyAirProviderService;

    @Mock
    private ProviderService toughJetProviderService;

	@Mock
	private BusyFlightsRequest busyFlightsRequest;

	@Mock
	private BusyFlightsResponse busyFlightsResponseToughJet1;
	@Mock
	private BusyFlightsResponse busyFlightsResponseCrazyAir1;
	@Mock
	private BusyFlightsResponse busyFlightsResponseToughJet2;
	@Mock
	private BusyFlightsResponse busyFlightsResponseCrazyAir2;

	private BusyFlightsService busyFlightsService;

	@Before
	public void setUp() {
		busyFlightsService = new BusyFligthsServiceImpl(
				Arrays.asList(crazyAirProviderService, toughJetProviderService));
	}

	@Test
	public void testRequestHttp () throws InterruptedException, ExecutionException {

	    when(busyFlightsResponseToughJet1.getFare()).thenReturn(new BigDecimal(175.75));
	    when(busyFlightsResponseCrazyAir1.getFare()).thenReturn(new BigDecimal(190));
	    when(busyFlightsResponseCrazyAir2.getFare()).thenReturn(new BigDecimal(200));
	    when(busyFlightsResponseToughJet2.getFare()).thenReturn(new BigDecimal(268.2));

	    List<BusyFlightsResponse> tougJetResponses = new ArrayList<>();
	    tougJetResponses.add(busyFlightsResponseToughJet1);
	    tougJetResponses.add(busyFlightsResponseToughJet2);

        List<BusyFlightsResponse> crazyAirResponses = new ArrayList<>();
        crazyAirResponses.add(busyFlightsResponseCrazyAir1);
        crazyAirResponses.add(busyFlightsResponseCrazyAir2);

	    when(toughJetProviderService.search(busyFlightsRequest)).thenReturn(new AsyncResult<>(tougJetResponses));
		when(crazyAirProviderService.search(busyFlightsRequest)).thenReturn(new AsyncResult<>(crazyAirResponses));

		List<BusyFlightsResponse> flightsResponses = busyFlightsService.search(busyFlightsRequest);
		
		verify(toughJetProviderService).search(busyFlightsRequest);
		verify(crazyAirProviderService).search(busyFlightsRequest);

		assertThat(flightsResponses, is(notNullValue()));
		assertThat(flightsResponses.size(), is(4));
		assertThat(flightsResponses.get(0), is(busyFlightsResponseToughJet1));
		assertThat(flightsResponses.get(1), is(busyFlightsResponseCrazyAir1));
		assertThat(flightsResponses.get(2), is(busyFlightsResponseCrazyAir2));
		assertThat(flightsResponses.get(3), is(busyFlightsResponseToughJet2));
	}
}