package com.movie.booking.repository;

import org.springframework.data.repository.CrudRepository;

import com.movie.booking.data.ReservationType;

public interface ReservationTypeRepository extends CrudRepository<ReservationType, Long> {

}
