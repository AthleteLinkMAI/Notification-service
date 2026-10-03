package team.anonyms.athletelink.notificationservice.config.kafka;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("app.kafka.topics")
public record KafkaTopicsProperties(
        String notificationMessages
) {
}
