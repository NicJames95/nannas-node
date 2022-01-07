package com.Nannas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Nannas.entity.Users;
import com.Nannas.repository.UsersRepository;

@CrossOrigin
@RestController
public class UsersController {
	
	@Autowired
	UsersRepository usersrepository;
	
	@RequestMapping(value="/save",
			consumes= MediaType.APPLICATION_JSON_VALUE,
			produces= MediaType.APPLICATION_JSON_VALUE,
			method= RequestMethod.POST)
	
	public void submitUserDetails(@RequestBody Users users) {
		
		usersrepository.save(users);
	}
	
	@RequestMapping(value="/findUserById",
			produces= MediaType.APPLICATION_JSON_VALUE,
			method= RequestMethod.GET)
	public ResponseEntity<Optional<Users>> findById (String userName) {
		
		Optional<Users> user = this.usersrepository.findById(userName);
		
		return new ResponseEntity<Optional<Users>>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value="/login",
			produces= MediaType.APPLICATION_JSON_VALUE,
			method= RequestMethod.POST)
	
	public ResponseEntity<Users> login(@RequestBody Users U) {
		Users user = this.usersrepository.login(U.getUserName(), U.getPassword());
		
		if(user == null) {
			
			return new ResponseEntity<> (user, HttpStatus.UNAUTHORIZED);
		}
		
		return new ResponseEntity<> (user, HttpStatus.OK);
	}
	
	@RequestMapping(value="/findAll",
			produces= MediaType.APPLICATION_JSON_VALUE,
			method= RequestMethod.GET)
	public ResponseEntity<List<Users>> findAll() {
		List<Users> user = this.usersrepository.findAll();
		
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	
}
