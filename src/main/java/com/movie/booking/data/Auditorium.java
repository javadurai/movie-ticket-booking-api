package com.movie.booking.data;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Auditorium {

	@Id
	Long id;
	
	String name;
	
	int seatsNo;
}
