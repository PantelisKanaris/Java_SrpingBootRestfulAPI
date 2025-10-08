package com.example.demo.Models;
import java.math.BigDecimal;
import  java.time.*;

import com.example.demo.Models.Enums.LeaderPayoutStatus;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "LeaderPayoutTB")
public class LeaderPayoutTB 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LeaderPayoutId")
	private Long LeaderPayoutId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SessionId", referencedColumnName = "SessionId", nullable = false)
	private SessionTB Session;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="UserId",referencedColumnName="UserId",nullable=false)
	private UserTB  User;
	  @Column(name = "Amount", precision = 19, scale = 4, nullable = false)
    private BigDecimal Amount;

    @Column(name = "CurrencyCode", length = 3, nullable = false)
    private String CurrencyCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", length = 16, nullable = false)
    private LeaderPayoutStatus Status = LeaderPayoutStatus.PENDING;

    @Column(name = "Provider", length = 40)
    private String Provider;

    @Column(name = "ProviderPayoutId", length = 255)
    private String ProviderPayoutId;

	@org.hibernate.annotations.CreationTimestamp
    @Column(name = "CreatedAt", nullable = false)
    private LocalDateTime CreatedAt;

    @Column(name = "ExecutedAt")
    private LocalDateTime ExecutedAt;


	
}
