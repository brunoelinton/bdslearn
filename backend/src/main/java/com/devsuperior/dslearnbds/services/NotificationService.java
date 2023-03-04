package com.devsuperior.dslearnbds.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslearnbds.entities.Notification;
import com.devsuperior.dslearnbds.entities.User;
import com.devsuperior.dslearnbds.entities.dtos.NotificationDTO;
import com.devsuperior.dslearnbds.repositories.NotificationRepository;

@Service
public class NotificationService {

	final NotificationRepository notificationRepository;
	final AuthService authService;

	public NotificationService(NotificationRepository notificationRepository, AuthService authService) {

		this.notificationRepository = notificationRepository;
		this.authService = authService;
	}

	@Transactional(readOnly = true)
	public Page<NotificationDTO> notificationForCurrentUser(Pageable pageable) {
		User user = authService.authenticated();
		Page<Notification> page = notificationRepository.findByUser(user, pageable);
		return page.map(x -> new NotificationDTO(x));
	}
}
