package com.example.demo.Models;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Data

@Entity
@Table(name = "UserTB")
public class UserTB {

	@Id
	@Column(name = "UserId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Column(name = "Name")
	private String name;

	@Column(name = "Password")
	private String password;

	@Column(name = "Email")
	private String email;

	@Column(name = "PhoneNumber")
	private String phoneNumber;

	@Column(name = "AvatarUrl")
	private String avatarUrl;

	@Column(name = "PayAccountToken")
	private String payAccountToken;

	@org.hibernate.annotations.CreationTimestamp
	@Column(name = "CreatedAt")
	private LocalDateTime createdAt;

	@OneToMany(mappedBy = "user")
	private List<PaymentMethodTB> paymentMethods = new ArrayList<>();

	@OneToMany(mappedBy = "leader", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SessionTB> createdSessions = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SessionUserTB> sessionMemberships = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<LeaderPayoutTB> leaderPayouts = new ArrayList<>();

}
