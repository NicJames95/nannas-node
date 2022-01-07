package com.Nannas.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.Nannas.entity.Product;

public interface ProductRepository extends JpaRepository <Product, Integer> {
	
	@Query("SELECT P FROM Product P WHERE P.name = ?1")
	Optional<Product> findByName(String name);

	

}
