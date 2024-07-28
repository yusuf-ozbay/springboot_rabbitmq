package org.example.springbootrabbitmq.controller;

import org.example.springbootrabbitmq.publisher.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private RabbitMQProducer producer;
    public MessageController(RabbitMQProducer producer) {
        this.producer = producer;
    }

    // HTTP GET isteği ile '/publish' yoluna gelen istekleri işler
    @GetMapping("publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        // Mesajı RabbitMQ'ya gönderir
        producer.sendMessage(message);

        // İstek başarılı olduğunda geri döndürülecek yanıt
        return ResponseEntity.ok("Message sent to RabbitMQ.. ");
    }
}