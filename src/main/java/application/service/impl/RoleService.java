package application.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.bean.Role;
import application.repository.RoleRepository;
import application.service.IRoleService;
import application.utils.enumeration.RoleName;

@Service
public class RoleService implements IRoleService {
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Role getRoleByName(String name) {
		Optional<Role> role = roleRepository.findRoleByName(RoleName.valueOf(name));
		return role.get();
	}

}
