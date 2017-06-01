package com.travix.busyflights.service;

import static java.util.concurrent.CompletableFuture.allOf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.travix.busyflights.domain.busyfligths.BusyFlightsRequest;
import com.travix.busyflights.domain.busyfligths.BusyFlightsResponse;
import com.travix.busyflights.service.provider.ProviderService;

@Component(value = "busyFligthsService")
public class BusyFlightsServiceImpl implements BusyFlightsService {
	
	private List<ProviderService> listProviderService;
	
	private ExecutorService executor;
	
	@Autowired
	public BusyFlightsServiceImpl(List<ProviderService> listProviderService, ExecutorService executor) {
		this.listProviderService = listProviderService;
		this.executor = executor;
	}

	private CompletableFuture<List<BusyFlightsResponse>> joinListBusyFlights(
			CompletableFuture<List<BusyFlightsResponse>>[] completableFutures) {
		CompletableFuture<List<List<BusyFlightsResponse>>> listCompletableFuture =
				allOf(completableFutures)
				.thenApply(c -> Stream.of(completableFutures)
					.map(CompletableFuture::join)
					.collect(Collectors.toList()));
		return listCompletableFuture.thenApply(listListBusyFlights -> convert(listListBusyFlights));
	}
	
	private List<BusyFlightsResponse> convert(List<List<BusyFlightsResponse>> listListBusyFlights) {
		List<BusyFlightsResponse> listBusyFlight = new ArrayList<>(); 
		listListBusyFlights.forEach(listBusyFlights -> 
			listBusyFlights.forEach(b -> listBusyFlight.add(b)));
		Collections.sort(listBusyFlight, Comparator.comparing(BusyFlightsResponse::getFare));
		return listBusyFlight;
	}
	
	@Override
	public CompletableFuture<List<BusyFlightsResponse>> search(BusyFlightsRequest request) {
		
		CompletableFuture<List<BusyFlightsResponse>>[] completableFutures =
			listProviderService.stream().map(
				provide -> CompletableFuture.supplyAsync(() -> provide.search(request), executor)).toArray(CompletableFuture[]::new);

		return joinListBusyFlights(completableFutures);
	}
			 
}
