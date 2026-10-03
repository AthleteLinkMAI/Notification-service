package team.anonyms.athletelink.notificationservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import team.anonyms.athletelink.notificationservice.dto.EmailNotificationRequest;
import team.anonyms.athletelink.notificationservice.dto.kafka.NotificationMessage;
import team.anonyms.athletelink.notificationservice.dto.kafka.enums.NotificationType;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
@SuppressWarnings(value = {"unused"})
public class KafkaConsumerService {
    private final EmailService emailService;

    @KafkaListener(
            topics = "${app.kafka.topics.notification-messages}",
            groupId = "${spring.application.name}"
    )
    public void receiveNotificationMessage(ConsumerRecord<UUID, NotificationMessage> record) {
        log.info("Received notification {} from partition {}", record.key(), record.partition());

        if (!record.value().notificationType().equals(NotificationType.EMAIL)) {
            return;
        }

        emailService.sendMessageByEmail(
                new EmailNotificationRequest(
                        record.value().notificationAddress(),
                        record.value().subject(),
                        record.value().text()
                )
        );
    }
}
