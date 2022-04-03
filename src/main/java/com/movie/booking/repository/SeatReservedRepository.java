package com.movie.booking.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.movie.booking.data.Screening;
import com.movie.booking.data.SeatReserved;

public interface SeatReservedRepository extends CrudRepository<SeatReserved, Long> {

	Collection<SeatReserved> findByScreening(Screening screening);
	
}
