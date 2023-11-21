package com.nadhem.users.restControllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.nadhem.users.entities.User;
import com.nadhem.users.register.RegistationRequest;
import com.nadhem.users.register.VerificationToken;
import com.nadhem.users.register.VerificationTokenRepository;
import com.nadhem.users.repos.UserRepository;
import com.nadhem.users.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserRestController {
	
	@Autowired
	UserRepository userRep;
	
	@Autowired
	UserService  userService;
	
	@Autowired
	VerificationTokenRepository verificationTokenRepo;
	
	@RequestMapping(path = "all",method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return userRep.findAll();
	 }
	
	
	@PostMapping("/register")
	public User register(@RequestBody  RegistationRequest request)
	{   
		return userService.registerUser(request);
		
	}
	
	
	@GetMapping("/verifyEmail/{token}")
    public User verifyEmail(@PathVariable("token") String token){   
		return userService.validateToken(token);
    }
	
	
	
	@GetMapping( "/register/isenabled/{username}")
	public Boolean isUserEnabledbled(@PathVariable("username") String username) {
	return userService.isUserEnabledbled(username);
	 }
	
}
