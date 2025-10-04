package com.example.demo.Repositories;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Models.Customer;
public interface CustomerRepository  extends JpaRepository<Customer, Integer>
{
    List<Customer> findByLocation(String location);
    Optional<Customer> findByEmail(String email);
}
