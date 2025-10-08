package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ItemClaimsTB", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "ReceiptItemId", "SessionUserId" }) })
public class ItemClaimsTB {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ItemClaimsId")
	private Long itemClaimsId;

	// Each claim belongs to a specific ReceiptItem
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ReceiptItemId", referencedColumnName = "ReceiptItemId", nullable = false)
	@JsonBackReference
	private ReceiptItemTB receiptItem;

	// Each claim also belongs to a specific SessionUser (the person claiming it)
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SessionUserId", referencedColumnName = "SessionUserId", nullable = false)
	@JsonBackReference
	private SessionUserTB sessionUser;

	@org.hibernate.annotations.CreationTimestamp
	@Column(name = "CreatedAt", nullable = false)
	private LocalDateTime createdAt;
}
