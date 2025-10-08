package com.example.demo.Models;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    private Long receiptId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SessionId", referencedColumnName = "SessionId", nullable = false)
    private SessionTB session;

    @Column(name = "ImageUrl", length = 1000)
    private String imageUrl;

    // NVARCHAR(MAX) – store as String. Column name in DB is [Json]; in JPA just use "Json".
    @Column(name = "Json", columnDefinition = "NVARCHAR(MAX)")
    private String json;

    @Column(name = "CurrencyCode", length = 3, nullable = false)
    private String currencyCode;

    @Column(name = "SubTotalAmount", precision = 19, scale = 4)
    private BigDecimal subTotalAmount;

    @Column(name = "TaxTotalAmount", precision = 19, scale = 4)
    private BigDecimal taxTotalAmount;

    @Column(name = "ServiceFeeAmount", precision = 19, scale = 4)
    private BigDecimal serviceFeeAmount;

    @Column(name = "TipAmount", precision = 19, scale = 4)
    private BigDecimal tipAmount;

    @Column(name = "DiscountAmount", precision = 19, scale = 4)
    private BigDecimal discountAmount;

    // Computed column in SQL Server → read-only in JPA
    @Column(name = "GrandTotal", precision = 19, scale = 4, insertable = false, updatable = false)
    private BigDecimal grandTotal;

    @Column(name = "ExtractedAt", nullable = false)
    private LocalDateTime extractedAt;
	
}
