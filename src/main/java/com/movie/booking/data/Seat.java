package com.movie.booking.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Data
public class Seat {

	@Id
	Long id;

	Long row;

	Long number;

	@JoinColumn(name = "auditorium_id", referencedColumnName = "id")
	@OneToOne
	Auditorium auditorium;
	
	String seatId;
	
	@Transient
	SeatType seatType;

}
