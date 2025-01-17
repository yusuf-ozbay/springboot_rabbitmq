package org.example.springbootrabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.queue.name}")
    private String queue;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    // application.yml dosyasındaki rabbitmq.routing.key değerini routingKey değişkenine atar.
    private String routingKey;

    @Bean
    public Queue queue() {
        return new Queue(queue); // Kuyruk ismi ile yeni bir Queue nesnesi oluşturur.
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchange); // Exchange ismi ile yeni bir TopicExchange nesnesi oluşturur.
    }

    @Bean
    public Binding binding() {
        return BindingBuilder
                .bind(queue())     // Kuyruğu bağlar
                .to(exchange())    // Exchange'e bağlar
                .with(routingKey); // Routing key kullanarak bağlama işlemini gerçekleştirir
    }
}
