package team.anonyms.athletelink.notificationservice.dto.kafka;

import team.anonyms.athletelink.notificationservice.dto.kafka.enums.NotificationType;

public record NotificationMessage(
        NotificationType notificationType,
        String notificationAddress,
        String subject,
        String text
) {
}
