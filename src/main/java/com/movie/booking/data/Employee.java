package com.movie.booking.data;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Employee {
	
	@Id
	Long id;
	
	String username;
	
	@JsonIgnore
	String password;
	
}
