package com.devsuperior.dslearnbds.resources;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslearnbds.entities.dtos.NotificationDTO;
import com.devsuperior.dslearnbds.services.NotificationService;

@RestController
@RequestMapping(value = "/notifications")
public class NotificationResource {

	final NotificationService notificationService;

	public NotificationResource(NotificationService notificationService) {
		this.notificationService = notificationService;
	}
	
	@GetMapping
	public ResponseEntity<Page<NotificationDTO>> notificationForCurrentUser(Pageable pageable) {
		Page<NotificationDTO> page = notificationService.notificationForCurrentUser(pageable);
		return ResponseEntity.ok().body(page);
	}
	
}
