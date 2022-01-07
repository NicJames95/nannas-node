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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Nannas.entity.AdminUser;
import com.Nannas.entity.Product;
import com.Nannas.repository.ProductRepository;

@CrossOrigin
@RestController
public class ProductController {
	
	@Autowired
	ProductRepository productrepository;
	
	@RequestMapping(value="/addProduct",
			consumes= MediaType.APPLICATION_JSON_VALUE,
			produces= MediaType.APPLICATION_JSON_VALUE,
			method= RequestMethod.POST)
	
	public void submitProductDetails(@RequestBody Product product) {
		
		productrepository.save(product);
	}
	
	@RequestMapping(value="/findProductByName",
			produces= MediaType.APPLICATION_JSON_VALUE,
			method= RequestMethod.GET)
	public ResponseEntity<Optional<Product>> findByName (String name) {
		
		Optional<Product> product = this.productrepository.findByName(name);
		
		return new ResponseEntity<Optional<Product>>(product, HttpStatus.OK);
	}
	
	@RequestMapping(value="/findAllProduct",
			produces= MediaType.APPLICATION_JSON_VALUE,
			method= RequestMethod.GET)
	public ResponseEntity<List<Product>> findAll() {
		List<Product> product = this.productrepository.findAll();
		
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteProduct",
			produces= MediaType.APPLICATION_JSON_VALUE,
			method= RequestMethod.DELETE)
	
	private void deleteProduct(@RequestParam int productId) {
		productrepository.deleteById(productId);
	}

}
