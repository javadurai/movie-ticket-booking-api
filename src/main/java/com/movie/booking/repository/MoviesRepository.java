package com.movie.booking.repository;

import org.springframework.data.repository.CrudRepository;

import com.movie.booking.data.Movie;

public interface MoviesRepository extends CrudRepository<Movie, Long> {

}
