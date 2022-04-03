package com.movie.booking.data;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Employee {
	
	@Id
	Long id;
	
	String username;
	
}
