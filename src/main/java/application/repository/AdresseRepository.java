package application.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import application.bean.Adresse;

@Repository
public interface AdresseRepository extends PagingAndSortingRepository<Adresse, Integer>  {

}
