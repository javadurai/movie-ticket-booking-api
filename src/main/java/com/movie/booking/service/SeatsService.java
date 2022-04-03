package com.movie.booking.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.booking.data.Screening;
import com.movie.booking.data.Seat;
import com.movie.booking.data.SeatReserved;
import com.movie.booking.data.SeatType;
import com.movie.booking.repository.ScreeningRepository;
import com.movie.booking.repository.SeatReservedRepository;
import com.movie.booking.repository.SeatsRepository;

@Service
public class SeatsService {
	
	@Autowired
	private SeatsRepository seatsRepository;
	
	@Autowired
	private ScreeningRepository screeningRepository;
	
	@Autowired
	private SeatReservedRepository seatReservedRepository;
	
	public Collection<Seat> getSeatsAvailability(Long screeningId) {
		
		Optional<Screening> screening =  screeningRepository.findById(screeningId);
		
		if(screening.isPresent()) {
			
			Collection<SeatReserved> reservedSeats = seatReservedRepository.findByScreening(screening.get());
			
			Collection<Seat> seats = seatsRepository.findByAuditorium(screening.get().getAuditorium());
						
			for (Seat seat : seats) {
				// By default set as available
				seat.setSeatType(SeatType.AVAILABLE);
				
				for(SeatReserved seatReserved : reservedSeats) {
					if(seatReserved.getSeat().equals(seat)) {
						seat.setSeatType(SeatType.UNAVAILABLE);
					}
				}
			}

			return seats;
		
		}
		
		return null;

	}

}
