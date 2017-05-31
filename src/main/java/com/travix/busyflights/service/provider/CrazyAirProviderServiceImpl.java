package com.travix.busyflights.service.provider;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.travix.busyflights.converter.crazyair.ConverterCrazyAirResponse;
import com.travix.busyflights.domain.busyfligths.BusyFlightsRequest;
import com.travix.busyflights.domain.busyfligths.BusyFlightsResponse;
import com.travix.busyflights.domain.crazair.CrazyAirResponse;

@Component
public class CrazyAirProviderServiceImpl implements ProviderService {

	private static final Logger LOG = LoggerFactory.getLogger(CrazyAirProviderServiceImpl.class);
	
	private String URL;
	
	private ConverterCrazyAirResponse converterCrazyAirResponse;
	
	@Autowired
	public CrazyAirProviderServiceImpl (
			ConverterCrazyAirResponse converterCrazyAirResponse,
			@Value("${url.service.crazyair}") String URL) {
		this.converterCrazyAirResponse = converterCrazyAirResponse;
		this.URL = URL;
	}
	
	@Async
	public Future<List<BusyFlightsResponse>> search (final BusyFlightsRequest request) {
		
		final RestTemplate restTemplate = new RestTemplate();
		
		// I already have the request validated here so I have not seen need to use the request parameter.
		// I do JUnit to RequestHelper
		LOG.info("requestAsyncHttp - Calling provider");
		List<BusyFlightsResponse> listBusyFlightsResponse = Arrays.asList(
				restTemplate.getForObject(URL, CrazyAirResponse[].class))
						.stream().map(converterCrazyAirResponse::convert)
						.collect(Collectors.toList());
		
		AsyncResult<List<BusyFlightsResponse>> response = new AsyncResult<>(listBusyFlightsResponse);
		
		LOG.info("requestAsyncHttp - Successfully calling provider!");

		return response;
	}

}