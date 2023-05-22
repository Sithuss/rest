package com.example.addressservice;

import com.example.addressservice.dao.AddressDao;
import com.example.addressservice.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class AddressServiceApplication {

    @Autowired
    private AddressDao addressDao;

//    @Bean @Profile("test")
    @Transactional
    public ApplicationRunner runner() {
        return r -> {
            Address address1 = new Address("dream land","799","Mdy", "1111");
            Address address2 = new Address("blue lagoon","899","Tdy", "1411");
            Address address3 = new Address("creek bridge road","899","london", "1711");
            Address address4 = new Address("Park Avenue","749","Mdy", "1211");

            addressDao.save(address1);
            addressDao.save(address2);
            addressDao.save(address3);
            addressDao.save(address4);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(AddressServiceApplication.class, args);
    }

}
