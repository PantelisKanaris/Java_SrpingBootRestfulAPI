package com.example.demo.Models;

import com.example.demo.Models.Enums.*;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Table(name = "SessionUserTB")
@NoArgsConstructor
@Data
public class SessionUserTB {
	@Column(name = "SessionUserId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long SessionUserId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SessionId", referencedColumnName = "SessionId", nullable = false)
	private SessionTB Session;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false)
	@Enumerated(EnumType.STRING)
	private UserTB User;

	@Column(name = "Role", nullable = false)
	private Role IsLeader;

	@Enumerated(EnumType.STRING)
	@Column(name = "ParticipantStatus", nullable = false)
	private UserStatus ParticipantStatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "JoinedAt", nullable = false)
	private Date JoinedAt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DoneAt")
	private Date DoneAt;

	@OneToMany(mappedBy = "SessionUser", cascade = CascadeType.ALL, orphanRemoval = true)
	private java.util.List<ItemClaimsTB> ClaimedItems = new java.util.ArrayList<>();
	
	@OneToMany(mappedBy = "SessionUser", cascade = CascadeType.ALL, orphanRemoval = true)
	private java.util.List<ParticipantPaymentTB> Payments = new java.util.ArrayList<>();

}