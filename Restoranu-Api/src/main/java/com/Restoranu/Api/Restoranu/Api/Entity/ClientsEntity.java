package com.Restoranu.Api.Restoranu.Api.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "clients")
public class ClientsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", length = 50, nullable = false)
	private String name;

	@Column(name = "email", nullable = true)
	private String email;

	@Column(name = "phone", nullable = false, length = 16)
	private String phone;
}




















