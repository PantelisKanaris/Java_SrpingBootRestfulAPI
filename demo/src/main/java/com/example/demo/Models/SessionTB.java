package com.example.demo.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "SessionTB")
@NoArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SessionTB {
	@Column(name = "SessionId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sessionId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false)
	@JsonBackReference 
	private UserTB leader;

	@Column(name = "CurrencyCode")
	private String currencyCode;

	@Column(name = "JoinCode")
	private String joinCode;

	@Column(name = "BlueToothRoomId")
	private String bluetoothRoomId;

	@Column(name = "Status")
	private String status;

	@org.hibernate.annotations.CreationTimestamp
	@Column(name = "StartedAt")
	private LocalDateTime createdAt;


	@Column(name = "ClosedAt")
	private LocalDateTime closedAt;

	@Column(name = "OneOff", nullable = false)
	private Boolean oneOff = true;

	@OneToMany(mappedBy = "session", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<SessionUserTB> participants = new ArrayList<>();

	@OneToMany(mappedBy = "session", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<ReceiptTB> receipts = new ArrayList<>();


}
