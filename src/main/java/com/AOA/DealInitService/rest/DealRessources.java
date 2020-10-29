package com.AOA.DealInitService.rest;

import com.AOA.DealInitService.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DealRessources {
    @Autowired
    private DealService dealService;



}
