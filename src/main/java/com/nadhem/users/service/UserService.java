package com.nadhem.users.service;

import java.util.Optional;

import com.nadhem.users.entities.Role;
import com.nadhem.users.entities.User;
import com.nadhem.users.register.RegistationRequest;

public interface UserService {
	User saveUser(User user);
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);
	User registerUser(RegistationRequest registationRequest);
	public User validateToken(String code);
	Boolean isUserEnabledbled(String username);

}
