package com.example.demo.Models;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;	

@Entity
@Table(name = "PaymentMethod")
public class PaymentMethodTB 
{
	@Id
	@Column(name = "PaymentMethodId")
	private Long PaymentMethodId;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	//name is the foreign key column in this table
	//referencedColumnName is the primary key column in the target table
    @JoinColumn(name = "UserId", referencedColumnName = "UserId", nullable = false)
	private UserTB User;
	@Column(name = "ProviderName")
	private String ProviderName;
	@Column(name = "MethodReference")
	private String MethodReference;
	@Column(name = "Brand")
	private String Brand;
	@Column(name = "Last4")
	private String Last4;
	@Column(name = "ExpMonth")
	private Integer ExpMonth;
	@Column(name = "ExpYear")
	private Integer ExpYear;
	@Column(name = "IsDefault")
	private Boolean IsDefault;
	@Column(name = "CreatedAt")
	private Date CreatedAt;

	
}
