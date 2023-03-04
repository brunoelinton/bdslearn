package com.devsuperior.dslearnbds.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslearnbds.services.DeliverService;

@RestController
@RequestMapping(value = "/deliveries")
public class DeliverResource {
	
	final DeliverService deliverService;

	public DeliverResource(DeliverService deliverService) {
		this.deliverService = deliverService;
	}
	

}
