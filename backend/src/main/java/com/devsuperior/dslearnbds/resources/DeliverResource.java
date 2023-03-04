package com.devsuperior.dslearnbds.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslearnbds.entities.dtos.DeliverRevisionDTO;
import com.devsuperior.dslearnbds.services.DeliverService;

@RestController
@RequestMapping(value = "/deliveries")
public class DeliverResource {
	
	final DeliverService deliverService;

	public DeliverResource(DeliverService deliverService) {
		this.deliverService = deliverService;
	}
	
	@PreAuthorize("hasAnyRole('ADMIN', 'INSTRUCTOR')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> saveRevision(@PathVariable Long id, @RequestBody DeliverRevisionDTO dto) {
        deliverService.saveRevision(id, dto);
        return ResponseEntity.noContent().build();
    }
}
