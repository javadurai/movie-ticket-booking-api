package com.movie.booking.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.movie.booking.data.Auditorium;
import com.movie.booking.data.Seat;

public interface SeatsRepository extends CrudRepository<Seat, Long> {

	Collection<Seat> findByAuditorium(Auditorium auditorium);
	
	Optional<Seat> findBySeatId(String seatId);
	
}
