package com.example.webui.controller;

import com.example.webui.Dto.AddressDto;
import com.example.webui.Dto.Addresses;
import com.example.webui.Dto.EmployeeDto;
import com.example.webui.Dto.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/webui")
public class WebUIController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping({"/","/home"})
    public String home(Model model) {
//        List<EmployeeDto> employees = new ArrayList<>();
        model.addAttribute("employees", employeeDtos);
        model.addAttribute("addresses", addressDtos);
        return "home";
    }

    List<EmployeeDto> employeeDtos = new ArrayList<>();
    List<AddressDto> addressDtos = new ArrayList<>();

    @GetMapping("/addresses")
    public String listAllAddress(Model model) {
        ResponseEntity<Addresses> addressResponse = restTemplate.getForEntity("http://localhost:8080/address/addresses", Addresses.class);

        if (addressResponse.getStatusCode().is2xxSuccessful()) {
            this.addressDtos = Objects.requireNonNull(addressResponse.getBody()).getAddresses();

            return "forward:/webui/home";
        }
        else {
            model.addAttribute("addresses", List.of());
            return "forward:/webui/home";
        }
    }

    @GetMapping("/employees")
    public String listAllEmployees(Model model) {
        ResponseEntity<Employees> employeeResponse = restTemplate.getForEntity("http://localhost:8080/employee/employees", Employees.class);

        if (employeeResponse.getStatusCode().is2xxSuccessful()) {
            this.employeeDtos = employeeResponse.getBody().getEmployeeDtos();
            return "forward:/webui/home";
        }
        else {
            model.addAttribute("employees", List.of());
            return "forward:/webui/home";
        }
    }
 }
