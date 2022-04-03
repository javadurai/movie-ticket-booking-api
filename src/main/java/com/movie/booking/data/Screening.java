package com.movie.booking.data;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Screening {

	@Id
	Long id;

	@JoinColumn(name = "movie_id", referencedColumnName = "id")
	@OneToOne
	Movie movie;

	@JoinColumn(name = "auditorium_id", referencedColumnName = "id")
	@OneToOne
	Auditorium auditorium;

	Date screeningStart;

}
