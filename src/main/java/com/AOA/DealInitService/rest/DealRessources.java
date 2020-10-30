package com.AOA.DealInitService.rest;

import com.AOA.DealInitService.dto.DealDto;
import com.AOA.DealInitService.model.Deal;
import com.AOA.DealInitService.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
public class DealRessources {
    @Autowired
    private DealService dealService;

    @PostMapping(value="/Deal")
    public Deal create(@RequestBody Deal deal){
        return deal;
    }

    @GetMapping(value="/Users")
    public void sendRequest( DealDto dto){

    }




}
