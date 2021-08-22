package application.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import application.bean.Photo;
import application.service.IPhotoService;

@RestController
public class PhotoController {
	
	@Autowired
	private IPhotoService photoService;
	
	@PostMapping("photo")
	public ResponseEntity<Photo> addPhoto(@RequestParam("image") MultipartFile file) throws IOException {
		// Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        
		Photo photo = new Photo(fileName, file.getContentType(), file.getBytes());
		Photo photoResponse = photoService.addPhoto(photo);
		return new ResponseEntity<>(photoResponse, HttpStatus.OK);
	}
	
	@GetMapping("/photo/{id}")
	public ResponseEntity<Photo> getPhoto(@PathVariable("id") Integer id) {
		Optional<Photo> photo = photoService.getPhotoById(id);
		if(photo.isPresent()) {
			return new ResponseEntity<>(photo.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
