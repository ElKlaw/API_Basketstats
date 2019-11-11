package application.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import application.bean.Presence;

@Repository
public interface PresenceRepository extends PagingAndSortingRepository<Presence, Integer>{

}
