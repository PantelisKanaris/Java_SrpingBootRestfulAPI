package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@NoArgsConstructor
@Data
@Table(name = "PaymentMethodTB")
public class PaymentMethodTB {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PaymentMethodId")
	private Long paymentMethodId;

	@Column(name = "Brand", length = 40)
	private String brand;

	@Column(name = "Last4", length = 4)
	private String last4;

	@Column(name = "ExpMonth")
	private Integer expMonth;

	@Column(name = "ExpYear")
	private Integer expYear;

	@Column(name = "CardFingerprint", length = 64)
	private String cardFingerprint;

	@org.hibernate.annotations.CreationTimestamp
	@Column(name = "CreatedAt")
	private LocalDateTime createdAt;

	@OneToMany(mappedBy = "paymentMethod", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference(value = "paymentMethod-userPaymentMethods")
	private java.util.List<UserPaymentMethodTB> userPaymentMethods = new java.util.ArrayList<>();

}
