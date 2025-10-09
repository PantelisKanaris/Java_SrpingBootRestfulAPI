package com.example.demo.Models;

import com.example.demo.Models.Enums.ParticipantPaymentStatus;
import com.example.demo.Models.Enums.PaymentMethodType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ParticipantPaymentTB")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ParticipantPaymentTB {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ParticipantPayment_id")
	private Long participantPaymentId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SessionUserId", referencedColumnName = "SessionUserId", nullable = false)
	@JsonBackReference
	private SessionUserTB sessionUser;

	@Enumerated(EnumType.STRING)
	@Column(name = "Method", length = 10, nullable = false)
	private PaymentMethodType method; // CARD / CASH

	@Column(name = "AmountDue", precision = 19, scale = 4, nullable = false)
	private BigDecimal amountDue;

	@Column(name = "CurrencyCode", length = 3, nullable = false)
	private String currencyCode;

	@Enumerated(EnumType.STRING)
	@Column(name = "Status", length = 16, nullable = false)
	private ParticipantPaymentStatus status = ParticipantPaymentStatus.PENDING;

	@Column(name = "Provider", length = 40)
	private String provider;

	@Column(name = "ProviderPaymentID", length = 255)
	private String providerPaymentId;

	@Column(name = "ProviderConsentID", length = 255)
	private String providerConsentId;

	@Column(name = "ProviderPaymentRef", length = 255)
	private String providerPaymentRef;

	@Column(name = "SettledAt")
	private LocalDateTime settledAt;

	@org.hibernate.annotations.CreationTimestamp
	@Column(name = "CreatedAt", nullable = false)
	private LocalDateTime createdAt;

	@Column(name = "UpdatedAt")
	private LocalDateTime updatedAt;
}
