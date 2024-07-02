package com.Restoranu.Api.Restoranu.Api.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "reservations")
public class ReservationsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "client_id", nullable = false)
	private Long clientId;

	@Column(name = "reservation_date")
	private LocalDate reservationDate;

	@Column(name = "number_of_people")
	private Integer numberOfPeople;

	@Column(name = "status")
	private String status;
}























