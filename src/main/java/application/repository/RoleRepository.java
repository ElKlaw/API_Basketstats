package application.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import application.bean.Role;
import application.utils.enumeration.RoleName;

public interface RoleRepository extends PagingAndSortingRepository<Role, Integer>  {
	@Query("select r from Role r where r.name=?1")
	Optional<Role> findRoleByName(RoleName name);
}
