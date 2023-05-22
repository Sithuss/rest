package com.example.counterservice.controller;

import com.example.counterservice.ds.CounterServiceRequest;
import com.example.counterservice.ds.CounterServiceResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/counter/stateless")
public class StatelessCounter {

    //curl -XPOST -H "Content-Type: application/json" -d '{"number":5}' http://localhost:8080/counter/stateless/countUp
    @PostMapping("/countUp")
    public CounterServiceResponse countUp(@RequestBody CounterServiceRequest request) {
        return new CounterServiceResponse(
                request.getNumber() + 1
        );
    }
}
