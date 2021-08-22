package application.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import application.bean.Invitation;

@Repository
public interface InvitationRepository extends PagingAndSortingRepository<Invitation, Integer> {
}
