package com.example.demo.Models;

import java.math.BigDecimal;
import java.time.*;

import com.example.demo.Models.Enums.LeaderPayoutStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "LeaderPayoutTB")
public class LeaderPayoutTB {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LeaderPayoutId")
	private Long leaderPayoutId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SessionId", referencedColumnName = "SessionId", nullable = false)
	@JsonBackReference
	private SessionTB session;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false)
	@JsonBackReference
	private UserTB user;
	@Column(name = "Amount", precision = 19, scale = 4, nullable = false)
	private BigDecimal amount;

	@Column(name = "CurrencyCode", length = 3, nullable = false)
	private String currencyCode;

	@Enumerated(EnumType.STRING)
	@Column(name = "Status", length = 16, nullable = false)
	private LeaderPayoutStatus status = LeaderPayoutStatus.PENDING;

	@Column(name = "Provider", length = 40)
	private String provider;

	@Column(name = "ProviderPayoutId", length = 255)
	private String providerPayoutId;

	@org.hibernate.annotations.CreationTimestamp
	@Column(name = "CreatedAt", nullable = false)
	private LocalDateTime createdAt;

	@Column(name = "ExecutedAt")
	private LocalDateTime executedAt;

}
