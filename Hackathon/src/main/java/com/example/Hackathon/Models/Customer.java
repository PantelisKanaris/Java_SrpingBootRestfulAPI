package com.example.Hackathon.Models;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Customers")
public class Customer {

    @Id
    @Column(name = "Customerid")
    private Integer customerId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Location")
    private String location;

    @Column(name = "Email")
    private String email;

}