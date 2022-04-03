package com.movie.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories(basePackages = { "com.movie.booking.*" })
@ComponentScan(basePackages = { "com.movie.booking.*" })
@EnableTransactionManagement
public class MovieTicketBookingApp {

	public static void main(String[] args) {
		SpringApplication.run(MovieTicketBookingApp.class, args);
	}

}
