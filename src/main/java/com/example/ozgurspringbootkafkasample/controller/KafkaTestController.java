package com.example.ozgurspringbootkafkasample.controller;

import com.example.ozgurspringbootkafkasample.request.KafkaTestRequest;
import com.example.ozgurspringbootkafkasample.service.KafkaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/message")
@RequiredArgsConstructor(onConstructor = @__({@Autowired, @NotNull}))
public class KafkaTestController {
    private final KafkaService kafkaService;

    @PostMapping
    public void publishKafkaMessage(@Valid @RequestBody KafkaTestRequest command) {
        kafkaService.sendMessage(command);
    }
}
