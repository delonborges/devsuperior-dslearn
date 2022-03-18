package com.delonborges.dslearn.resources;

import com.delonborges.dslearn.dto.NotificationDTO;
import com.delonborges.dslearn.services.NotificationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/notifications")
public class NotificationResource {

    private final NotificationService notificationService;

    public NotificationResource(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    public ResponseEntity<Page<NotificationDTO>> notificationForCurrentUser(Pageable pageable) {
        Page<NotificationDTO> notificationDTOPage = notificationService.notificationForCurrentUser(pageable);
        return ResponseEntity.ok().body(notificationDTOPage);
    }
}
