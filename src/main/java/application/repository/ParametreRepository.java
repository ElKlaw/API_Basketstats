package application.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import application.bean.Sport;

public interface ParametreRepository extends PagingAndSortingRepository<Sport, Integer> {

}
