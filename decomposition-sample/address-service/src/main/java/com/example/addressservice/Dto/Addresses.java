package com.example.addressservice.Dto;

import com.example.addressservice.entity.Address;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
public class Addresses {

    private List<Address> addresses;

    public Addresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Addresses() {
    }
}
