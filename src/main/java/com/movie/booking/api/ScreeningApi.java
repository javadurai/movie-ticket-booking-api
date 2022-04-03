package com.movie.booking.api;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.booking.data.Screening;
import com.movie.booking.service.ScreeningService;

@RestController
@RequestMapping("/screening")
public class ScreeningApi {
	
	@Autowired
	private ScreeningService screeeningService;

	@GetMapping("/by-movie/{id}")
	public Collection<Screening> screeningsForMovie(@PathVariable Long id){
		return screeeningService.getScreeningsByMovie(id);		
	}
}
