package team.anonyms.athletelink.notificationservice.config.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@EnableConfigurationProperties(KafkaTopicsProperties.class)
public class KafkaConfiguration {
    @Bean
    public NewTopic notificationMessagesTopic(KafkaTopicsProperties topic) {
        return TopicBuilder.name(topic.notificationMessages()).partitions(3).replicas(1).build();
    }
}
