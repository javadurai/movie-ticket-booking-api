package com.movie.booking.data;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ReservationType {

	@Id
	Long id;
	
	String type;
}
