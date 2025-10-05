package com.example.demo.Models;

import java.util.ArrayList;
import java.util.Date;
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
	private Long UserId;

	@Column(name = "Name")
	private String Name;
	@Column(name = "Password")
	private String Password;
	@Column(name = "Email")
	private String Email;
	@Column(name = "PhoneNumber")
	private String PhoneNumber;
	@Column(name = "AvatarUrl")
	private String AvatarUrl;
	@Column(name = "PayAccountToken")
	private String PayAccountToken;
	@Column(name = "CreatedAt")
	private Date CreatedAt;

	@OneToMany(mappedBy = "User")
	private List<PaymentMethodTB> PaymentMethods = new ArrayList<>();

	@OneToMany(mappedBy = "Leader", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SessionTB> CreatedSessions = new ArrayList<>();

	@OneToMany(mappedBy = "User", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<SessionUserTB> SessionMemberships = new ArrayList<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private java.util.List<LeaderPayoutTB> LeaderPayouts = new java.util.ArrayList<>();

}
