package com.movie.booking.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.booking.data.Movie;
import com.movie.booking.repository.MoviesRepository;

@RestController
@RequestMapping("/movies")
public class MoviesApi {
	
	@Autowired
	private MoviesRepository moviesRepository;

	@GetMapping("/")
	public Iterable<Movie> getAllMovies(){
		return moviesRepository.findAll();
	}
	
}
