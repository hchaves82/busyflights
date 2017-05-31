package com.travix.busyflights.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.travix.busyflights.domain.busyfligths.BusyFlightsRequest;
import com.travix.busyflights.domain.busyfligths.BusyFlightsResponse;
import com.travix.busyflights.service.BusyFlightsService;

@RestController
@RequestMapping(value = "/search")
public class BusyFlightsController {
	
    private BusyFlightsService service;
    
    @Autowired
    public BusyFlightsController(BusyFlightsService service) {
    	this.service = service;
    }
	
    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BusyFlightsResponse>> search(@Validated @RequestBody BusyFlightsRequest request) {

    	List<BusyFlightsResponse> responseList = service.search(request);
    	if (responseList.isEmpty()) {
    		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    	}
    	return new ResponseEntity<>(responseList, HttpStatus.OK);
    }
}
