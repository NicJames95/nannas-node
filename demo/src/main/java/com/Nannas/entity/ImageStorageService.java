package com.Nannas.entity;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.Nannas.repository.ImageRepository;

@Service
public class ImageStorageService {
	
	@Autowired
	ImageRepository imagerepository;
	
	public Image store(MultipartFile file) throws IOException {
		String fileName= StringUtils.cleanPath(file.getOriginalFilename());
		Image File = new Image();
		
		return imagerepository.save(File);
	}
	
	public Image getImage(String id) {
		return imagerepository.findById(id).get();
	}
	
	public Stream<Image> getAllImage() {
		return imagerepository.findAll().stream();
		
	}

}
