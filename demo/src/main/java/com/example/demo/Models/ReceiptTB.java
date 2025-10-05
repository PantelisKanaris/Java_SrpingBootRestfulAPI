package com.example.demo.Models;
import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Entity
@Table(name = "ReceiptTB")
@Data
public class ReceiptTB 
{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReceiptId")
    private Long ReceiptId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SessionId", referencedColumnName = "SessionId", nullable = false)
    private SessionTB Session;

    @Column(name = "ImageUrl", length = 1000)
    private String ImageUrl;

    // NVARCHAR(MAX) – store as String. Column name in DB is [Json]; in JPA just use "Json".
    @Column(name = "Json", columnDefinition = "NVARCHAR(MAX)")
    private String Json;

    @Column(name = "CurrencyCode", length = 3, nullable = false)
    private String CurrencyCode;

    @Column(name = "SubTotalAmount", precision = 19, scale = 4)
    private BigDecimal SubTotalAmount;

    @Column(name = "TaxTotalAmount", precision = 19, scale = 4)
    private BigDecimal TaxTotalAmount;

    @Column(name = "ServiceFeeAmount", precision = 19, scale = 4)
    private BigDecimal ServiceFeeAmount;

    @Column(name = "TipAmount", precision = 19, scale = 4)
    private BigDecimal TipAmount;

    @Column(name = "DiscountAmount", precision = 19, scale = 4)
    private BigDecimal DiscountAmount;

    // Computed column in SQL Server → read-only in JPA
    @Column(name = "GrandTotal", precision = 19, scale = 4, insertable = false, updatable = false)
    private BigDecimal GrandTotal;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ExtractedAt", nullable = false)
    private Date ExtractedAt;
	
}
