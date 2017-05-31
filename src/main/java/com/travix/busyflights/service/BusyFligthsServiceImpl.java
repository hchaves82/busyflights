package com.travix.busyflights.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.travix.busyflights.domain.busyfligths.BusyFlightsRequest;
import com.travix.busyflights.domain.busyfligths.BusyFlightsResponse;
import com.travix.busyflights.service.exception.BusyFlightsServiceException;
import com.travix.busyflights.service.provider.ProviderService;

@Component(value = "busyFligthsService")
public class BusyFligthsServiceImpl implements BusyFlightsService {
	
	private List<ProviderService> listProviderService;
	
	@Autowired
	public BusyFligthsServiceImpl(List<ProviderService> listProviderService) {
		this.listProviderService = listProviderService;
	}

	@Override
	public List<BusyFlightsResponse> search(BusyFlightsRequest request) {
		
		List<Future<List<BusyFlightsResponse>>> listFutureBusyFlight = new ArrayList<>();
		
		// calling async provides services 
		listProviderService.stream().forEach(p -> listFutureBusyFlight.add(p.search(request)));
		
		List<BusyFlightsResponse> listBusyFlight = new ArrayList<>(); 
		listFutureBusyFlight.forEach(f -> {
			try {
				listBusyFlight.addAll(f.get());
			} catch (Exception e) {
				throw new BusyFlightsServiceException();
			}
		});
		
		Collections.sort(listBusyFlight, Comparator.comparing(BusyFlightsResponse::getFare));
		
		return listBusyFlight;
	}
			 
}
