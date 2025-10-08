package com.example.demo.Models;

import com.example.demo.Models.Enums.*;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "SessionUserTB")
@NoArgsConstructor
@Data
public class SessionUserTB {
	@Column(name = "SessionUserId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sessionUserId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SessionId", referencedColumnName = "SessionId", nullable = false)
	private SessionTB session;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false)
	private UserTB user;

	@Enumerated(EnumType.STRING)
	@Column(name = "Role", nullable = false)
	private Role isLeader;

	@Enumerated(EnumType.STRING)
	@Column(name = "ParticipantStatus", nullable = false)
	private UserStatus participantStatus;

	@Column(name = "JoinedAt", nullable = false)
	private LocalDateTime joinedAt;

	@Column(name = "DoneAt")
	private LocalDateTime doneAt;

	@OneToMany(mappedBy = "sessionUser", cascade = CascadeType.ALL, orphanRemoval = true)
	private java.util.List<ItemClaimsTB> claimedItems = new java.util.ArrayList<>();

	@OneToMany(mappedBy = "sessionUser", cascade = CascadeType.ALL, orphanRemoval = true)
	private java.util.List<ParticipantPaymentTB> payments = new java.util.ArrayList<>();

}