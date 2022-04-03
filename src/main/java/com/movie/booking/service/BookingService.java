package com.movie.booking.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.movie.booking.data.Booking;
import com.movie.booking.data.BookingSelection;
import com.movie.booking.data.Reservation;
import com.movie.booking.data.Screening;
import com.movie.booking.data.Seat;
import com.movie.booking.data.SeatReserved;
import com.movie.booking.repository.EmployeeRepository;
import com.movie.booking.repository.ReservationRespository;
import com.movie.booking.repository.ReservationTypeRepository;
import com.movie.booking.repository.ScreeningRepository;
import com.movie.booking.repository.SeatReservedRepository;
import com.movie.booking.repository.SeatsRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@Transactional
public class BookingService {
	
	@Autowired
	private SeatsRepository seatsRepository;
	
	@Autowired
	private ScreeningRepository screeningRepository;
	
	@Autowired
	private ReservationRespository reservationRespository;
	
	@Autowired
	private SeatReservedRepository seatReservedRepository;
	
	@Autowired
	private ReservationTypeRepository reservationTypeRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	/**
	 * To Book tickets
	 * 
	 * @param booking
	 * @return
	 */
	public Collection<SeatReserved> bookSeats(Booking booking){
		
		List<SeatReserved> seatsReserved = new ArrayList<SeatReserved>();
		
		// Get Screening 
		Optional<Screening> screening = screeningRepository.findById(booking.getScreeningId());
		
		if(screening.isPresent()) {
			
			log.info("Screening found");
			
			for (BookingSelection selection : booking.getSelection()) {
				
				// Get Seat
				Optional<Seat> seat = seatsRepository.findBySeatId(selection.getSeat());
				
				if(seat.isPresent()) {
					
					log.info("Seat found");
					
					// Verify If Seat is available
					if(isSeatAvailable(seat.get(), screening.get())) {	
						
						log.info("Seat " + seat.get().getSeatId() + " is available for booking.");
						
						// Create Reservation					
						Reservation reservation = new Reservation();
						reservation.setActive(true);
						reservation.setPaid(true);
						reservation.setReservationType(reservationTypeRepository.findById(selection.getReservationTypeId()).get());
						reservation.setEmployeeReserved(employeeRepository.findById(booking.getEmployeeReservedId()).get());
						reservation.setEmployeePaid(employeeRepository.findById(booking.getEmployeePaidId()).get());
						reservation.setScreening(screening.get());
						reservation.setReserved(true);
						reservation.setReservationContact(booking.getReservationContact());
						
						reservation = reservationRespository.save(reservation);
						
						// Reserve Seat 
						SeatReserved reserveSeat = new SeatReserved();
						reserveSeat.setSeat(seat.get());
						reserveSeat.setScreening(screening.get());
						reserveSeat.setReservation(reservation);
						
						// Save
						seatsReserved.add(seatReservedRepository.save(reserveSeat));
					} else {
						throw new RuntimeException("Seat " + seat.get().getSeatId() + " is not available for booking.");
					}
				}
			}
			
		}
		
		return seatsReserved;
	}

	/**
	 * To verify the seat's availability before booking on a movie screening
	 * 
	 * @param seat
	 * @param screening
	 * @return
	 */
	private boolean isSeatAvailable(Seat seat, Screening screening) {
		
		Set<String> reservedSeats = seatReservedRepository.findByScreening(screening)
				.stream().map(reservedSeat -> reservedSeat.getSeat().getSeatId()).collect(Collectors.toSet());
			
		return !reservedSeats.contains(seat.getSeatId());
	}
}
