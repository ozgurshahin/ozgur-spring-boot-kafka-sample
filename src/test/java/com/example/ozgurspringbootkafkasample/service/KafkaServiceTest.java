package com.example.ozgurspringbootkafkasample.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.Mockito.verify;
import static org.springframework.kafka.support.KafkaHeaders.TOPIC;

class KafkaServiceTest {

    @InjectMocks
    private KafkaService kafkaService;

    @Mock
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Mock
    private ObjectMapper objectMapper;

    @Test
    void testSendMessage() throws Exception {
        MockitoAnnotations.openMocks(this);
        Object message = new Object();
        String messageString = "messageString";
        Mockito.when(objectMapper.writeValueAsString(message)).thenReturn(messageString);
        kafkaService.sendMessage(message);
        verify(kafkaTemplate).send(TOPIC, messageString);
    }
}
