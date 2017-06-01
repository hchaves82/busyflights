package com.travix.busyflights.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import com.travix.busyflights.domain.busyfligths.BusyFlightsRequest;
import com.travix.busyflights.domain.busyfligths.BusyFlightsResponse;
import com.travix.busyflights.service.BusyFlightsService;

@RestController
@RequestMapping(value = "/search")
public class BusyFlightsController {
	
    @Autowired
    private BusyFlightsService service;
    
    @Autowired
    private ExecutorService executor;
	
    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public DeferredResult<ResponseEntity<List<BusyFlightsResponse>>> search(
			@Validated @RequestBody BusyFlightsRequest request) {

    	DeferredResult<ResponseEntity<List<BusyFlightsResponse>>> deferredResult = new DeferredResult<>();
    	
        CompletableFuture.supplyAsync(() -> service.search(request), executor)
	        .whenCompleteAsync((response, e) -> {
	            response.exceptionally(ex -> {
	                deferredResult.setErrorResult(ex.getCause());
	                return null;
	            });
	            response.thenAccept(results -> {
	                deferredResult.setResult(new ResponseEntity<>(results, HttpStatus.OK));
	            });
	        });
    	
    	return deferredResult;
    }
}
