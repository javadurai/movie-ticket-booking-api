package com.movie.booking.data;

import lombok.Data;

@Data
public class Booking {
	
	private Long seatId;
	
	private Long screeningId;
	
	private Long employeeReservedId;
	
	private Long employeePaidId;
	
	private Long reservationTypeId;

}
