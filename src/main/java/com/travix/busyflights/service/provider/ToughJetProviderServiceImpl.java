package com.travix.busyflights.service.provider;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.travix.busyflights.converter.toughjet.ConverterToughJetResponse;
import com.travix.busyflights.domain.busyfligths.BusyFlightsRequest;
import com.travix.busyflights.domain.busyfligths.BusyFlightsResponse;
import com.travix.busyflights.domain.toughjet.ToughJetResponse;

@Component
public class ToughJetProviderServiceImpl implements ProviderService {

	private String URL;

	private ConverterToughJetResponse converterToughJetResponse;
	
	@Autowired
	public ToughJetProviderServiceImpl (
			ConverterToughJetResponse converterToughJetResponse,
			@Value("${url.service.toughjet}") String URL) {
		this.converterToughJetResponse = converterToughJetResponse;
		this.URL = URL;
	}
	
	public List<BusyFlightsResponse> search (final BusyFlightsRequest request) {
		
		final RestTemplate restTemplate = new RestTemplate();
		
		// I already have the request validated here so I have not seen need to use the request parameter.
		// I do JUnit to RequestHelper
		List<BusyFlightsResponse> listBusyFlightsResponse = Arrays.asList(
				restTemplate.getForObject(URL, ToughJetResponse[].class))
						.stream().map(converterToughJetResponse::convert)
						.collect(Collectors.toList());
		
		return listBusyFlightsResponse;
	}

}
