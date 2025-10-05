package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "SessionTb")
@NoArgsConstructor
@Data
public class SessionTB {
	@Column(name = "SessionId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long SessionId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false)
	private UserTB Leader;

	@Column(name = "CurrencyCode")
	private String CurrencyCode;

	@Column(name = "JoinCode")
	private String JoinCode;

	@Column(name = "BlueToothRoomId")
	private String BluetoothRoomId;

	@Column(name = "Status")
	private String Status;

	@Column(name = "StartedAt")
	private Date CreatedAt;

	@Column(name = "ClosedAt")
	private Date ClosedAt;

	@OneToMany(mappedBy = "Session", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SessionUserTB> Participants = new ArrayList<>();

	@OneToMany(mappedBy = "Session", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ReceiptTB> Receipts = new ArrayList<>();


	@OneToMany(mappedBy = "session", cascade = CascadeType.ALL, orphanRemoval = true)
	private java.util.List<LeaderPayoutTB> LeaderPayouts = new java.util.ArrayList<>();

}
