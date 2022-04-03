package com.movie.booking.api;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.booking.data.Booking;
import com.movie.booking.data.SeatReserved;
import com.movie.booking.service.BookingService;

@RestController
@RequestMapping("booking")
public class BookingApi {
	
	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/book")
	Collection<SeatReserved> bookSeats(@RequestBody List<Booking> bookings){
		
		return bookingService.bookSeats(bookings);		
	}

}
