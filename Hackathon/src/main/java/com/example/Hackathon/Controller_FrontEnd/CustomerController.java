package com.example.Hackathon.Controller_FrontEnd;
import com.example.Hackathon.Models.Customer;
import com.example.Hackathon.Service_Bussiness_Logic.CustomerServices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customers")

public class CustomerController 
{
     private final CustomerServices customerServices;

    public CustomerController(CustomerServices customerServices) {
        this.customerServices = customerServices;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomers() 
    {
        List<Customer> customers = customerServices.getAll();

        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
    
}
