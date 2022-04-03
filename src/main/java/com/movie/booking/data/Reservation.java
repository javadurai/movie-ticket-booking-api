package com.movie.booking.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
@Data
public class Reservation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	@JoinColumn(name = "screening_id", referencedColumnName = "id")
	@OneToOne
	Screening screening;
	
	@JoinColumn(name = "employee_reserved_id", referencedColumnName = "id")
	@OneToOne
	Employee employeeReserved;
	
	@JoinColumn(name = "reservation_type_id", referencedColumnName = "id")
	@OneToOne
	ReservationType reservationType;
	
	String reservationContact;
	
	@Type(type="numeric_boolean")
	Boolean reserved;
	
	@JoinColumn(name = "employee_paid_id", referencedColumnName = "id")
	@OneToOne
	Employee employeePaid;
	
	@Type(type="numeric_boolean")
	Boolean paid;
	
	@Type(type="numeric_boolean")
	Boolean active;	
	
}
