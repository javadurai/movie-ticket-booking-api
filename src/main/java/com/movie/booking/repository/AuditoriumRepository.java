package com.movie.booking.repository;

import org.springframework.data.repository.CrudRepository;

import com.movie.booking.data.Auditorium;

public interface AuditoriumRepository extends CrudRepository<Auditorium, Long> {

}
