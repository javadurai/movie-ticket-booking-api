package com.movie.booking.repository;

import org.springframework.data.repository.CrudRepository;

import com.movie.booking.data.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
	Employee findByUsername(String username);

}
