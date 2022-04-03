package com.movie.booking.api;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.booking.data.Seat;
import com.movie.booking.service.SeatsService;

@RestController
@RequestMapping("seats/")
public class SeatsApi {
	
	@Autowired
	private SeatsService seatsService;
	
	@GetMapping("/for-screening/{id}")
	public Collection<Seat> seatsForScreening(@PathVariable Long id){
		
		return seatsService.getSeatsAvailability(id);		
	}
	
	@GetMapping("for-auditorium1/{id}")
	public Long seatsFromuditorium1(@PathVariable Long id){
		return id;		
	}

}
