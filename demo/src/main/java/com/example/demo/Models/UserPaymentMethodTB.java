package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@NoArgsConstructor
@Data
@Table(name = "UserPaymentMethodTB", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"UserId", "PaymentMethodId"})
})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserPaymentMethodTB {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UserPaymentMethodId")
	private Long userPaymentMethodId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false)
	@JsonBackReference
	private UserTB user;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PaymentMethodId", referencedColumnName = "PaymentMethodId", nullable = false)
	@JsonBackReference(value = "paymentMethod-userPaymentMethods")
	private PaymentMethodTB paymentMethod;

	@Column(name = "ProviderName", length = 40, nullable = false)
	private String providerName;

	@Column(name = "MethodReference", length = 255, nullable = false)
	private String methodReference;

	@Column(name = "ProviderCustomerId", length = 255)
	private String providerCustomerId;

	@Column(name = "IsDefault", nullable = false)
	private Boolean isDefault = false;

	@Column(name = "LinkedAt", nullable = false)
	private LocalDateTime linkedAt;
}
