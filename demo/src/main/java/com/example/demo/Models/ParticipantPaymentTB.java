package com.example.demo.Models;

import com.example.demo.Models.Enums.ParticipantPaymentStatus;
import com.example.demo.Models.Enums.PaymentMethodType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(
    name = "ParticipantPaymentTB",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"SessionUserId"}) // mirrors PARTICIPANTPAYMENT_UN
    }
)
public class ParticipantPaymentTB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ParticipantPayment_id")
    private Long ParticipantPaymentId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SessionUserId", referencedColumnName = "SessionUserId", nullable = false)
    private SessionUserTB SessionUser;

    @Enumerated(EnumType.STRING)
    @Column(name = "Method", length = 10, nullable = false)
    private PaymentMethodType Method; // CARD / CASH

    @Column(name = "AmountDue", precision = 19, scale = 4, nullable = false)
    private BigDecimal AmountDue;

    @Column(name = "CurrencyCode", length = 3, nullable = false)
    private String CurrencyCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "Status", length = 16, nullable = false)
    private ParticipantPaymentStatus Status = ParticipantPaymentStatus.PENDING;

    @Column(name = "Provider", length = 40)
    private String Provider;

    @Column(name = "ProviderPaymentID", length = 255)
    private String ProviderPaymentId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CreatedAt", nullable = false)
    private Date CreatedAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UpdatedAt")
    private Date UpdatedAt;
}
