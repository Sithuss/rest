package com.example.counterservice.controller;

import com.example.counterservice.ds.CounterServiceResponse;
import com.example.counterservice.service.MutableCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/counter/stateful")
public class StatefulCounter {

    @Autowired
    private MutableCounterService mutableCounterService;

    @PostMapping("/countUp")
    public CounterServiceResponse countUp() {
        mutableCounterService.countUp();
        return new CounterServiceResponse(mutableCounterService.getNumber());
    }
}
