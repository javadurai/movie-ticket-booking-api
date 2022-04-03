package com.movie.booking.data;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Movie {

	@Id
	Long id;
	
	String title;
	
	String director;
	
	String cast;
	
	String description;
	
	int durationMin;
	
}
