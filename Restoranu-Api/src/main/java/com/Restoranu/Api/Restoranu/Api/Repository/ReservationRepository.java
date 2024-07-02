package com.Restoranu.Api.Restoranu.Api.Repository;

import com.Restoranu.Api.Restoranu.Api.Entity.ReservationsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<ReservationsEntity, Long> {
	List<ReservationsEntity> findByClientId(Long clientId);

	List<ReservationsEntity> findByReservationDate(LocalDate reservationDate);

	List<ReservationsEntity> findByStatusIgnoreCase(String status);
}
