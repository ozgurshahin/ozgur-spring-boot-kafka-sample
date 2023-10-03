package com.example.ozgurspringbootkafkasample.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class KafkaTestControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testPublishKafkaMessage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/message")
                        .content("{\"name\":\"John\", \"surName\":\"Doe\"}")
                        .contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
