package com.vaspap.kafkaamigoscode;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/messages")
public class MessageController {

    private final KafkaTemplate<String, CustomMessage> kafkaTemplate;

    public MessageController(KafkaTemplate<String, CustomMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void publishCustom(@RequestBody MessageRequest request){
        CustomMessage customMessage = new CustomMessage(request.message(), LocalDateTime.now());
        kafkaTemplate.send("vaspap", customMessage);
    }
}
