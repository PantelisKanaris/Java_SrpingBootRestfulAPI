package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ReceiptItemTB")
@com.fasterxml.jackson.annotation.JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ReceiptItemTB {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ReceiptItemId")
	private Long receiptItemId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ReceiptId", referencedColumnName = "ReceiptId", nullable = false)
	@JsonBackReference
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


	@Column(name = "DiscountPercent", precision = 5, scale = 2, nullable = false)
	private BigDecimal discountPercent = BigDecimal.ZERO;

	// Computed columns in DB, read-only in JPA
	@Column(name = "DiscountPerUnit", precision = 19, scale = 4, insertable = false, updatable = false)
	private BigDecimal discountPerUnit;


	@Column(name = "DiscountedUnitPrice", precision = 19, scale = 4, insertable = false, updatable = false)
	private BigDecimal discountedUnitPrice;

	@Column(name = "TotalAmount", precision = 19, scale = 4, insertable = false, updatable = false)
	private BigDecimal totalAmount;

	@Column(name = "DiscountedTotal", precision = 19, scale = 4, insertable = false, updatable = false)
	private BigDecimal discountedTotal;

	@Column(name = "Notes", length = 500)
	private String notes;

	@OneToMany(mappedBy = "receiptItem", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private java.util.List<ItemClaimsTB> claims = new java.util.ArrayList<>();

}
