package com.nadhem.users.security;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.nadhem.users.entities.User;
import com.nadhem.users.exceptions.InvalidTokenException;
import com.nadhem.users.exceptions.UserDisabledException;
import com.nadhem.users.service.UserService;


@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	UserService userService;
	
@Override
public UserDetails loadUserByUsername(String username) 
		throws UsernameNotFoundException,UserDisabledException {
	User user = userService.findUserByUsername(username);
	
		
	 if (user==null ) 
	 {System.out.println("Utilisateur introuvable");
	       throw new UsernameNotFoundException("Utilisateur introuvable!");
	 }
	 
	 
	 
	//System.out.println("ennnnnnnnnnnnnnnnnnbaled "+user.getEnabled());
	 
	// if (!user.getEnabled())
       //  throw new DisabledException("Utilisateur non activé !");
         
	 
	
	
 
	
	List<GrantedAuthority> auths = new ArrayList<>();
	
	 user.getRoles().forEach(role -> {
		 GrantedAuthority auhority = new SimpleGrantedAuthority(role.getRole());
		 auths.add(auhority);
	 });
	
	return new org.springframework.security.core.
			userdetails.User(user.getUsername(),user.getPassword(), user.getEnabled(), true, true, true,auths);
	//username, password, true, true, true, true, authorities
	//user.getUsername(),user.getPassword(),auths
  }
}
