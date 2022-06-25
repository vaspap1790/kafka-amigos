package com.vaspap.kafkaamigoscode;

import org.springframework.stereotype.Component;

@Component
public class KafkaListener {

    @org.springframework.kafka.annotation.KafkaListener(topics = "vaspap", groupId = "groupId")
    void listener(String data){
        System.out.println("Listener received: " + data + " !!!");
    }
}
