package application.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.bean.Photo;
import application.repository.PhotoRepository;
import application.service.IPhotoService;

@Service
public class PhotoService implements IPhotoService{
	@Autowired
	private PhotoRepository photoRepository;
	
	@Override
	public Photo addPhoto(Photo photo) {
		photoRepository.save(photo);
		return photo;
	}

	@Override
	public Optional<Photo> getPhotoById(int id) {
		return photoRepository.findById(id);
	}
}
