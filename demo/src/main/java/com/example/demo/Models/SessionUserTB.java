package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "SessionUserTB")
@NoArgsConstructor
@Data
public class SessionUserTB 
{
	@Column(name = "SessionUserId")
	@Id
	private Long SessionUserId;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SessionId", referencedColumnName = "SessionId", nullable = false)
	private SessionTB Session;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false)
	private UserTB User;
	@Column(name = "Role")
	private Boolean IsLeader;
}