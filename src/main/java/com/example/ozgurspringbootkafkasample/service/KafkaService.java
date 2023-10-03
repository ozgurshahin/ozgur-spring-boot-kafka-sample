package com.example.ozgurspringbootkafkasample.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static org.springframework.kafka.support.KafkaHeaders.TOPIC;

@RequiredArgsConstructor(onConstructor = @__({@Autowired, @NotNull}))
@Service
public class KafkaService {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    public void sendMessage(Object message) {
        String messageString = objectMapper.writeValueAsString(message);
        kafkaTemplate.send(TOPIC, messageString);
    }
}
