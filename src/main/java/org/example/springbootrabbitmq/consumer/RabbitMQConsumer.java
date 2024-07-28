package org.example.springbootrabbitmq.consumer;

import org.example.springbootrabbitmq.publisher.RabbitMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);
    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(String message){   //belirli bir kuyrukraki öesajı okumak ve tüketmek için kullanırız

        LOGGER.info(String.format("Received message -> %s",message));

    }

}
