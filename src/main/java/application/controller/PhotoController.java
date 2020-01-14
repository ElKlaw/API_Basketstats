package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	private static String UPLOADED_FOLDER = "C:\\Users\\Norsys-Nantes-15\\git\\Application_Basketstats\\Photo";
	
	@Autowired
	private IPhotoService photoService;
	
	@PostMapping("photo")
	public ResponseEntity<Photo> addPhotoClub(@RequestParam("image") MultipartFile file, @RequestParam("urlClub") String urlClub, @RequestParam("typePhoto") String typePhoto) {
		Photo photo = new Photo();
		try {			
			photo.setNom(typePhoto);
			photo.setExtension(file.getOriginalFilename().split("\\.")[1]);
			String chemin = UPLOADED_FOLDER + "\\" + urlClub + "\\" + photo.getNom() + "." + photo.getExtension();
			photo.setChemin(chemin);
			
			File folderClub = new File(UPLOADED_FOLDER, urlClub); 
			if (!folderClub.exists()) {
				folderClub.mkdir();
			}
            byte[] bytes = file.getBytes();
            Path path = Paths.get(chemin);
            Files.write(path, bytes);
        } catch (IOException e) {
        	return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
		Photo photoResponse = photoService.addPhoto(photo);
		return new ResponseEntity<>(photoResponse, HttpStatus.OK);
	}
	
	
	@GetMapping("/photo/{id}")
	public ResponseEntity<Resource> getPhoto(@PathVariable("id") Integer id) throws IOException{
		Optional<Photo> photo = photoService.getPhotoById(id);
		if(photo.isPresent()) {
			Path path = Paths.get(photo.get().getChemin());
			Resource resource = null;
			try {
				resource = new UrlResource(path.toUri());
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			if("jpg".equals(photo.get().getExtension())) {
				return ResponseEntity.ok()
						.contentType(MediaType.IMAGE_JPEG)
						.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
						.body(resource);
			} else if("png".equals(photo.get().getExtension())) {
				return ResponseEntity.ok()
						.contentType(MediaType.IMAGE_PNG)
						.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
						.body(resource);
			}
			
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
