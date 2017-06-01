package com.travix.busyflights.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.travix.busyflights.config.ExecutorConfig;
import com.travix.busyflights.domain.busyfligths.BusyFlightsRequest;
import com.travix.busyflights.domain.busyfligths.BusyFlightsResponse;
import com.travix.busyflights.service.provider.ProviderService;

import static org.mockito.Mockito.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

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
		ExecutorConfig executorServiceConfiguration = new ExecutorConfig(1, 1, 10);
        ExecutorService executor  = executorServiceConfiguration.executorService();
		busyFlightsService = new BusyFlightsServiceImpl(
				Arrays.asList(crazyAirProviderService, toughJetProviderService), executor);
	}

	@Test
	public void testSearch () throws InterruptedException, ExecutionException {

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

	    when(toughJetProviderService.search(busyFlightsRequest)).thenReturn(tougJetResponses);
		when(crazyAirProviderService.search(busyFlightsRequest)).thenReturn(crazyAirResponses);

		CompletableFuture<List<BusyFlightsResponse>> completableFutureflights = busyFlightsService.search(busyFlightsRequest);
		
		verify(toughJetProviderService, times(1)).search(busyFlightsRequest);
		verify(crazyAirProviderService, times(1)).search(busyFlightsRequest);
		
		List<BusyFlightsResponse> flightsResponses = completableFutureflights.get();

        assertNotNull(flightsResponses);
        assertThat(flightsResponses.size(), is(4));
		assertThat(flightsResponses.get(0), is(busyFlightsResponseToughJet1));
		assertThat(flightsResponses.get(1), is(busyFlightsResponseCrazyAir1));
		assertThat(flightsResponses.get(2), is(busyFlightsResponseCrazyAir2));
		assertThat(flightsResponses.get(3), is(busyFlightsResponseToughJet2));
	}
}