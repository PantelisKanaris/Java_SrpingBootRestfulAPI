package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ReceiptItemTB")
public class ReceiptItemTB {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ReceiptItemId")
	private Long receiptItemId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ReceiptId", referencedColumnName = "ReceiptId", nullable = false)
	private ReceiptTB receipt;

	@Column(name = "LineNumber")
	private Integer lineNumber;

	@Column(name = "ItemName", nullable = false, length = 255)
	private String itemName;

	@Column(name = "Category", length = 64)
	private String category;

	@Column(name = "Quantity", precision = 9, scale = 3, nullable = false)
	private BigDecimal quantity = BigDecimal.ONE;

	@Column(name = "UnitPrice", precision = 19, scale = 4, nullable = false)
	private BigDecimal unitPrice;

	// 👇 computed column in DB, read-only in JPA
	@Column(name = "TotalAmount", precision = 19, scale = 4, insertable = false, updatable = false)
	private BigDecimal totalAmount;

	@Column(name = "Notes", length = 500)
	private String notes;

	@OneToMany(mappedBy = "receiptItem", cascade = CascadeType.ALL, orphanRemoval = true)
	private java.util.List<ItemClaimsTB> claims = new java.util.ArrayList<>();

}
