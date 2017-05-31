package com.travix.busyflights.service;

import java.util.List;

import com.travix.busyflights.domain.busyfligths.BusyFlightsRequest;
import com.travix.busyflights.domain.busyfligths.BusyFlightsResponse;

public interface BusyFlightsService {

	public List<BusyFlightsResponse> search(final BusyFlightsRequest request);
}
