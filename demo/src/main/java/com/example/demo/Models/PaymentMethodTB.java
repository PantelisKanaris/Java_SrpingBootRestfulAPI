package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@Table(name = "PaymentMethodTB")
public class PaymentMethodTB {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PaymentMethodId")
	private Long paymentMethodId;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	// name is the foreign key column in this table
	// referencedColumnName is the primary key column in the target table
	@JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false)
	private UserTB user;
	@Column(name = "ProviderName")
	private String providerName;
	@Column(name = "MethodReference")
	private String methodReference;
	@Column(name = "Brand")
	private String brand;
	@Column(name = "Last4")
	private String last4;
	@Column(name = "ExpMonth")
	private Integer expMonth;
	@Column(name = "ExpYear")
	private Integer expYear;
	@Column(name = "IsDefault")
	private Boolean isDefault;

	@org.hibernate.annotations.CreationTimestamp
	@Column(name = "CreatedAt")
	private LocalDateTime createdAt;

}
