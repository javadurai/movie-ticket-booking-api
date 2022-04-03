package com.movie.booking.data;

import java.util.List;

import lombok.Data;

@Data
public class Booking {
		
	private Long screeningId;
	
	private Long employeeReservedId;
	
	private Long employeePaidId;
	
	private String reservationContact;
	
	private List<BookingSelection> selection;
	
}
