package com.Nannas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Nannas.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository <Users, String> {
	
	@Query("SELECT U FROM Users U WHERE U.userName = ?1")
	Users findUsersByID(String userName);
	
	@Query("SELECT U FROM Users U WHERE U.userName =?1 and U.password = ?2")
	Users login(String userName, String password);

}
