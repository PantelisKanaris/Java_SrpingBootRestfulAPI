package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
@Entity
@Table(name = "SessionTb")
@NoArgsConstructor
@Data
public class SessionTB 
{
	@Column(name = "SessionId")
	@Id
	private Long SessionId;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false)
	private UserTB Leader;
	@Column(name="CurrencyCode")
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

	
}
