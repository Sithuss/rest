package com.example.addressservice.controller;

import com.example.addressservice.Dto.Addresses;
import com.example.addressservice.dao.AddressDao;
import com.example.addressservice.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressDao addressDao;

    @GetMapping("/addresses")
    public Addresses listAllAddresses() {
        return new Addresses(addressDao.findAll());
    }
}
