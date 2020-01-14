package application.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import application.bean.Photo;

@Repository
public interface PhotoRepository extends PagingAndSortingRepository<Photo, Integer>{

}
