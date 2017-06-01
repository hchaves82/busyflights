package com.travix.busyflights.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.travix.busyflights.domain.busyfligths.BusyFlightsRequest;
import com.travix.busyflights.domain.busyfligths.BusyFlightsResponse;

public interface BusyFlightsService {

	public CompletableFuture<List<BusyFlightsResponse>> search(final BusyFlightsRequest request);
}
