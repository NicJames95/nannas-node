package com.Nannas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Nannas.entity.AdminUser;



@Repository
public interface AdminUserRepository extends JpaRepository <AdminUser, String> {
	
	@Query("SELECT A FROM AdminUser A WHERE A.email = ?1")
	AdminUser findAdminUserByID(String email);
	
	@Query("SELECT A FROM AdminUser A WHERE A.email =?1 and A.password =?2")
	AdminUser login(String email, String password);

}
