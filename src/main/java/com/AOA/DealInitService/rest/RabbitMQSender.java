package com.AOA.DealInitService.rest;

import com.AOA.DealInitService.model.Deal;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value="/dealInitService")
public class RabbitMQSender {

    @Autowired
    AmqpTemplate rabbitTemplate;

    @Value("${DealInitServiceApplication.rabbitmq.exchange}")
    private String exchange;

    @Value("${DealInitServiceApplication.rabbitmq.routingkey}")
    private String routingkey;

    @PostMapping(value="/deal")
    public void send(@RequestBody Deal deal) {
        rabbitTemplate.convertAndSend(exchange, routingkey, deal);
        System.out.println("Send msg = " + deal);

    }
}
