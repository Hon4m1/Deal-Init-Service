package com.AOA.DealInitService.rest;

import com.AOA.DealInitService.dto.DealDto;
import com.AOA.DealInitService.model.Deal;
import com.AOA.DealInitService.service.DealService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DealRessources {
    @Autowired
    private DealService dealService;
    @Autowired
    AmqpTemplate rabbitTemplate;

    @Value("${DealInitServiceApplication.rabbitmq.exchange}")
    private String exchange;

    @Value("${DealInitServiceApplication.rabbitmq.routingkey}")
    private String routingkey;

    @PostMapping(value="/deal")
    public void create(@RequestBody Deal deal){
        rabbitTemplate.convertAndSend(exchange, routingkey, deal);
        System.out.println("Send msg = " + deal);
    }
    /*
    @PostMapping(value="/deal")
    public Deal create(@RequestBody Deal deal){
        String userList = deal.getListUser().join(",", userList);
        sendRequest(userList);
    }*/

    /*@GetMapping(value="/deal")
    public Deal sendRequest(List<String> user){
        return
    }*/





}
