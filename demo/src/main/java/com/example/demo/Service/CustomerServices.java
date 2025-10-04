package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import com.example.demo.Models.Customer;
import com.example.demo.Repositories.CustomerRepository;
import jakarta.transaction.Transactional;

@Service
@Validated
public class CustomerServices 
{
    private final CustomerRepository m_CustomerRepository;
    
    public CustomerServices(CustomerRepository customerRepository) 
    {
        this.m_CustomerRepository = customerRepository;
    }
     @Transactional()
    public List<Customer> getAll() 
    {
        return m_CustomerRepository.findAll();
    }
}