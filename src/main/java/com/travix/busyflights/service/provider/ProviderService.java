package com.travix.busyflights.service.provider;

import java.util.List;
import java.util.concurrent.Future;

import com.travix.busyflights.domain.busyfligths.BusyFlightsRequest;
import com.travix.busyflights.domain.busyfligths.BusyFlightsResponse;

public interface ProviderService {

	public Future<List<BusyFlightsResponse>> search (final BusyFlightsRequest request);
}
