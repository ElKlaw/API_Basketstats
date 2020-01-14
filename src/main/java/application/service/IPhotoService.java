package application.service;

import java.util.Optional;

import application.bean.Photo;

public interface IPhotoService {
	Photo addPhoto(Photo photo);
	Optional<Photo> getPhotoById(int id);
}
