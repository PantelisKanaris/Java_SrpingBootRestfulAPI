package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ItemClaimsTB", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "ReceiptItemId", "SessionUserId" }) })
public class ItemClaimsTB {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ItemClaimsId")
	private Long ItemClaimsId;

	// Each claim belongs to a specific ReceiptItem
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ReceiptItemId", referencedColumnName = "ReceiptItemId", nullable = false)
	private ReceiptItemTB ReceiptItem;

	// Each claim also belongs to a specific SessionUser (the person claiming it)
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SessionUserId", referencedColumnName = "SessionUserId", nullable = false)
	private SessionUserTB SessionUser;

		@org.hibernate.annotations.CreationTimestamp
		@Column(name = "CreatedAt", nullable = false)
		private LocalDateTime CreatedAt;
}
