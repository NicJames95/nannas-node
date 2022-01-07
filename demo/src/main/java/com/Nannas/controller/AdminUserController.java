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

import com.Nannas.entity.AdminUser;
import com.Nannas.repository.AdminUserRepository;


@CrossOrigin
@RestController
public class AdminUserController {
	
	@Autowired
	AdminUserRepository adminuserrepository;
	
	@RequestMapping(value="/saveadmin",
			consumes= MediaType.APPLICATION_JSON_VALUE,
			produces= MediaType.APPLICATION_JSON_VALUE,
			method= RequestMethod.POST)
	
	public void submitUserDetails(@RequestBody AdminUser adminuser) {
		
		adminuserrepository.save(adminuser);
	}
	
	@RequestMapping(value="/findAdminUserById",
			produces= MediaType.APPLICATION_JSON_VALUE,
			method= RequestMethod.GET)
	public ResponseEntity<Optional<AdminUser>> findById (String email) {
		
		Optional<AdminUser> adminuser = this.adminuserrepository.findById(email);
		
		return new ResponseEntity<Optional<AdminUser>>(adminuser, HttpStatus.OK);
	}
	
	@RequestMapping(value="/adminLogin",
			produces= MediaType.APPLICATION_JSON_VALUE,
			method= RequestMethod.POST)
	
	public ResponseEntity<AdminUser> login(@RequestBody AdminUser A) {
		AdminUser adminuser = this.adminuserrepository.login(A.getEmail(), A.getPassword());
		
		if(adminuser == null) {
			
			return new ResponseEntity<> (adminuser, HttpStatus.UNAUTHORIZED);
		}
		
		return new ResponseEntity<> (adminuser, HttpStatus.OK);
	}
	
	@RequestMapping(value="/find",
			produces= MediaType.APPLICATION_JSON_VALUE,
			method= RequestMethod.GET)
	public ResponseEntity<List<AdminUser>> findAll() {
		List<AdminUser> adminuser = this.adminuserrepository.findAll();
		
		return new ResponseEntity<>(adminuser, HttpStatus.OK);
	}
	

}
