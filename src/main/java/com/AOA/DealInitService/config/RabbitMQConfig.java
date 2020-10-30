package com.AOA.DealInitService.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class RabbitMQConfig {

    @Value("${DealInitServiceApplication.rabbitmq.queue1}")
    String dealQueue;
    @Value("${DealInitServiceApplication.rabbitmq.queue2}")
    String notifQueue;

    @Value("${DealInitServiceApplication.rabbitmq.exchange}")
    String exchange;

    @Value("${DealInitServiceApplication.rabbitmq.routingkey}")
    String routingkey;

    @Bean
    @Qualifier("deal")
    @Primary
    Queue queueDeal() {
        return new Queue(dealQueue, true);
    }
    @Bean
    @Qualifier("notif")
    Queue queueNotif() {
        return new Queue(notifQueue, true);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    @Qualifier("rtdeal")
    Binding bindingDeal(@Qualifier("deal")Queue  queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingkey);
    }

    @Bean
    @Qualifier("rtnotif")
    Binding binding(@Qualifier("notif")Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingkey);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}
