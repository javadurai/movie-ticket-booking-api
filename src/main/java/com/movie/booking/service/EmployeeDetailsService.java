package com.movie.booking.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.movie.booking.data.Employee;
import com.movie.booking.repository.EmployeeRepository;

@Service
public class EmployeeDetailsService implements UserDetailsService {
	
	@Autowired
	EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByUsername(username);
        if(employee != null) {
        	return new User(employee.getUsername(), employee.getPassword(), new ArrayList<>());
        }
		return null;
    }
}