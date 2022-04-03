package com.movie.booking.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.booking.data.Movie;
import com.movie.booking.data.Screening;
import com.movie.booking.repository.MoviesRepository;
import com.movie.booking.repository.ScreeningRepository;

@Service
public class ScreeningService {

	@Autowired
	private ScreeningRepository screeningRepository;

	@Autowired
	private MoviesRepository movieRepository;
	
	public Collection<Screening> getScreeningsByMovie(Long id) {
		Optional<Movie> movie = movieRepository.findById(id);
		
		if(movie.isPresent()) {
		 	Collection<Screening> screenings = screeningRepository.findByMovie(movie.get());
		 	
		 	return screenings;
		}
		
		return null;
		
	}
}
