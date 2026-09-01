package team.anonyms.athletelink.notificationservice.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.anonyms.athletelink.notificationservice.dtos.EmailNotificationRequest;
import team.anonyms.athletelink.notificationservice.services.EmailService;

@RestController
@RequestMapping("/notify")
public class NotificationController {
    private final EmailService emailService;

    public NotificationController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/email")
    public ResponseEntity<Void> notifyByEmail(@Valid @RequestBody EmailNotificationRequest request) {
        emailService.sendMessageByEmail(request);
        return ResponseEntity.noContent().build();
    }
}
