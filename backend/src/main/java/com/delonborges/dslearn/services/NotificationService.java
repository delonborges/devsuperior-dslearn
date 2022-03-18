package com.delonborges.dslearn.services;

import com.delonborges.dslearn.dto.NotificationDTO;
import com.delonborges.dslearn.entities.Notification;
import com.delonborges.dslearn.entities.User;
import com.delonborges.dslearn.repositories.NotificationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final AuthService authService;

    public NotificationService(NotificationRepository notificationRepository, AuthService authService) {
        this.notificationRepository = notificationRepository;
        this.authService = authService;
    }

    @Transactional(readOnly = true)
    public Page<NotificationDTO> notificationForCurrentUser(Pageable pageable) {
        User user = authService.authenticated();
        Page<Notification> notificationPage = notificationRepository.findByUser(user, pageable);
        return notificationPage.map(NotificationDTO::new);
    }
}
