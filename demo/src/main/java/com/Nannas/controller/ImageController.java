package com.Nannas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Nannas.entity.Image;
import com.Nannas.entity.ImageStorageService;
import com.Nannas.entity.ResponseMessage;
import com.Nannas.repository.ImageRepository;

@Controller
@CrossOrigin
public class ImageController {
	
	@Autowired
	private ImageStorageService storageservice;
	
	@Autowired
	ImageRepository imagerepository;
	
	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";
		
		try {
			storageservice.store(file);
			
			message = "upload file successfully: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			message = "Could not upload file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}
	
	@RequestMapping(value="/findAllFile",
			produces= MediaType.APPLICATION_JSON_VALUE,
			method= RequestMethod.GET)
	public ResponseEntity<List<Image>> findAll() {
		List<Image> file = this.imagerepository.findAll();
		
		return new ResponseEntity<>(file, HttpStatus.OK);
	}
	
	@RequestMapping(value="/findFileById",
			produces= MediaType.APPLICATION_JSON_VALUE,
			method= RequestMethod.GET)
	public ResponseEntity<Optional<Image>> findById (String id) {
		
		Optional<Image> file = this.imagerepository.findById(id);
		
		return new ResponseEntity<Optional<Image>>(file, HttpStatus.OK);
	}

}
