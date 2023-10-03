package com.example.ozgurspringbootkafkasample.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import static org.springframework.kafka.support.KafkaHeaders.TOPIC;

@Configuration
public class KafkaTopicConfiguration {
    @Bean
    public NewTopic createTopic() {
        return TopicBuilder.name(TOPIC)
                .build();
        /*Or you can use
         * return new NewTopic(TOPIC, 3, (short) 1);
         * */
    }
}
