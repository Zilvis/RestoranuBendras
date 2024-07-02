package com.Restoranu.Api.Restoranu.Api.Service;

import com.Restoranu.Api.Restoranu.Api.Entity.ReservationsEntity;
import com.Restoranu.Api.Restoranu.Api.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;
	@Override
	public ReservationsEntity create(ReservationsEntity reservation) {
		return reservationRepository.save(reservation);
	}

	@Override
	public List<ReservationsEntity> getAllReservations() {
		return (List<ReservationsEntity>) reservationRepository.findAll();
	}

	@Override
	public List<ReservationsEntity> getAllReservationsByClientId(Long clientId) {
		return (List<ReservationsEntity>) reservationRepository.findByClientId(clientId);
	}

	@Override
	public List<ReservationsEntity> getAllReservationsByDate(LocalDate date) {
		return (List<ReservationsEntity>) reservationRepository.findByReservationDate(date);
	}

	@Override
	public List<ReservationsEntity> getAllReservationsByStatus(String status) {
		return (List<ReservationsEntity>) reservationRepository.findByStatusIgnoreCase(status);
	}

	@Override
	public void deleteReservationById(Long reservationId) {
		reservationRepository.deleteById(reservationId);
	}

	@Override
	public ReservationsEntity changeStatus(ReservationsEntity reservationsEntity, String status, Long id) {
		reservationsEntity.setStatus(status);
        return reservationRepository.save(reservationsEntity);
	}
}
