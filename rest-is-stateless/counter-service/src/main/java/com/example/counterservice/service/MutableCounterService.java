package com.example.counterservice.service;

import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
@Getter
public class MutableCounterService {
    private int number;

    public void countUp() {
        ++number;
    }
}
