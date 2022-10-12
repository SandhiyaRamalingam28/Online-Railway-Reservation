package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.JwtRequest;
import com.example.demo.model.JwtResponse;
import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.CustomerUserDetailsService;
import com.example.demo.util.JwtUtil;

@CrossOrigin("http://localhost:4200")
@RestController
public class JwtController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private JwtRequest jwtRequest;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CustomerUserDetailsService customerUserDetailsService;
	
	@PostMapping("/register")
	private ResponseEntity<JwtResponse>registerUser(@RequestBody JwtRequest jwtRequest){
		UserModel userModel= new UserModel();
		userModel.setUsername(jwtRequest.getUsername());
		userModel.setPassword(jwtRequest.getPassword());
		try {
			userRepository.save(userModel);
		}
		catch(Exception e){
			return new ResponseEntity<JwtResponse>(new JwtResponse
					("Error during subscription ") , HttpStatus.OK);
		}
		
//		logger.info("Client Subscription accessed");
		return new ResponseEntity<JwtResponse>(new JwtResponse
				("Successful subs for client " +jwtRequest.getUsername()), HttpStatus.OK);
//		return ResponseEntity.ok(new AuthenticationResponse());
	}
	@PostMapping("/token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		System.out.println(jwtRequest);
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword()));
		}
		catch(UsernameNotFoundException e){
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}
		catch(BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
			
		}
		
		UserDetails userDetails = this.customerUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
		String token = this.jwtUtil.generateToken(userDetails);
		System.out.println("JWT" + token);
		
		return  ResponseEntity.ok(new JwtResponse(token));
	}

}
