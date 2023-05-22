package com.example.counterservice.ds;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CounterServiceRequest {
    public int number;
    public CounterServiceRequest(@JsonProperty("number") int number) {
        this.number = number;
    }

}
