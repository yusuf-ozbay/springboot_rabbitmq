package org.example.springbootrabbitmq.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    // Logger nesnesi: Log mesajları yazmak için kullanılır
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);

    // @Value anotasyonları ile application.yml dosyasındaki değerleri değişkenlere atar
    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    // Mesaj gönderme metodu
    public void sendMessage(String message) {
        // Log mesajı yazılır
        LOGGER.info(String.format("Message -> %s", message));

        // Mesajı exchange'e ve routing key ile RabbitMQ'ya gönderir
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }
}
