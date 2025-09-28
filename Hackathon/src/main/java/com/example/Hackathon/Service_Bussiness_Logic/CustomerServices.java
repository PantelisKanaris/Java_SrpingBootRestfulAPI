package com.example.Hackathon.Service_Bussiness_Logic;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.Hackathon.Models.Customer;
import com.example.Hackathon.Repository_Data_Layer.CustomerRepository;

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
