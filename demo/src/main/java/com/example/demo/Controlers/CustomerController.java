package com.example.demo.Controlers;

import com.example.demo.Models.Customer;
import com.example.demo.Service.CustomerServices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customers")

public class CustomerController 
{
     private final CustomerServices m_customerServices;

    public CustomerController(CustomerServices customerServices) {
        this.m_customerServices = customerServices;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomers() 
    {
        List<Customer> customers = m_customerServices.getAll();

        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    
}