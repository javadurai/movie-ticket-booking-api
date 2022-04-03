package com.movie.booking.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.booking.data.Booking;
import com.movie.booking.data.Reservation;
import com.movie.booking.data.Screening;
import com.movie.booking.data.Seat;
import com.movie.booking.data.SeatReserved;
import com.movie.booking.repository.EmployeeRepository;
import com.movie.booking.repository.ReservationTypeRepository;
import com.movie.booking.repository.ScreeningRepository;
import com.movie.booking.repository.SeatReservedRepository;
import com.movie.booking.repository.SeatsRepository;

@Service
public class BookingService {
	
	@Autowired
	private SeatsRepository seatsRepository;
	
	@Autowired
	private ScreeningRepository screeningRepository;
	
	@Autowired
	private SeatReservedRepository seatReservedRepository;
	
	@Autowired
	private ReservationTypeRepository reservationTypeRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public Collection<SeatReserved> bookSeats(List<Booking> bookings){
		
		List<SeatReserved> seatsReserved = new ArrayList<SeatReserved>();
		
		for (Booking booking : bookings) {
			
			// Get Seat
			Optional<Seat> seat = seatsRepository.findById(booking.getSeatId());
			
			if(seat.isPresent()) {				
				// Get Screening 
				Optional<Screening> screening = screeningRepository.findById(booking.getScreeningId());
				
				if(screening.isPresent()) {
					
					// Create Reservation					
					Reservation reservation = new Reservation();
					reservation.setActive(true);
					reservation.setPaid(true);
					reservation.setReservationType(reservationTypeRepository.findById(booking.getReservationTypeId()).get());
					reservation.setEmployeeReserved(employeeRepository.findById(booking.getEmployeeReservedId()).get());
					reservation.setEmployeePaid(employeeRepository.findById(booking.getEmployeePaidId()).get());
					reservation.setScreening(screening.get());
					reservation.setReserved(true);
					
					// Reserve Seat 
					SeatReserved reserveSeat = new SeatReserved();
					reserveSeat.setSeat(seat.get());
					reserveSeat.setScreening(screening.get());
					reserveSeat.setReservation(reservation);
					
					// Save
					seatsReserved.add(seatReservedRepository.save(reserveSeat));
					
				}
			}
		}
		
		return seatsReserved;
	}
}
