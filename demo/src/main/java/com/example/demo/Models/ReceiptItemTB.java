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
	private Long ReceiptItemId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ReceiptId", referencedColumnName = "ReceiptId", nullable = false)
	private ReceiptTB Receipt;

	@Column(name = "LineNumber")
	private Integer LineNumber;

	@Column(name = "ItemName", nullable = false, length = 255)
	private String ItemName;

	@Column(name = "Category", length = 64)
	private String Category;

	@Column(name = "Quantity", precision = 9, scale = 3, nullable = false)
	private BigDecimal Quantity = BigDecimal.ONE;

	@Column(name = "UnitPrice", precision = 19, scale = 4, nullable = false)
	private BigDecimal UnitPrice;

	// 👇 computed column in DB, read-only in JPA
	@Column(name = "TotalAmount", precision = 19, scale = 4, insertable = false, updatable = false)
	private BigDecimal TotalAmount;

	@Column(name = "Notes", length = 500)
	private String Notes;

	@OneToMany(mappedBy = "ReceiptItem", cascade = CascadeType.ALL, orphanRemoval = true)
	private java.util.List<ItemClaimsTB> Claims = new java.util.ArrayList<>();

}
