package com.example.webui.Dto;


import lombok.Data;

import java.util.List;

@Data
public class Addresses {

    private List<AddressDto> addresses;

    public Addresses(List<AddressDto> addresses) {
        this.addresses = addresses;
    }

    public Addresses() {
    }
}
