package com.movie.booking.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.movie.booking.data.Movie;
import com.movie.booking.data.Screening;

public interface ScreeningRepository extends CrudRepository<Screening, Long> {
	
	Collection<Screening> findByMovie(Movie movie);

}
