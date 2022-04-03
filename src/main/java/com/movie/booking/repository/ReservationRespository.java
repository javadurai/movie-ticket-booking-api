package com.movie.booking.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.movie.booking.data.Reservation;
import com.movie.booking.data.Screening;

public interface ReservationRespository extends CrudRepository<Reservation, Long> {
	
	Collection<Reservation> findByScreening(Screening screening);
	
}
