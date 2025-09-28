package com.example.Hackathon.Repository_Data_Layer;

import java.util.*;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Hackathon.Models.Customer;
public interface  CustomerRepository extends JpaRepository<Customer, Integer> 
{
    List<Customer> findByLocation(String location);
    Optional<Customer> findByEmail(String email);

    
}
