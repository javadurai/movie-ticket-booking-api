package com.movie.booking.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class SeatReserved {

	@Id
	Long id;	

	@JoinColumn(name = "seat_id", referencedColumnName = "id")
	@OneToOne
	Seat seat;	

	@JoinColumn(name = "reservation_id", referencedColumnName = "id")
	@OneToOne
	Reservation reservation;	

	@JoinColumn(name = "screening_id", referencedColumnName = "id")
	@OneToOne
	Screening screening;
	
}
