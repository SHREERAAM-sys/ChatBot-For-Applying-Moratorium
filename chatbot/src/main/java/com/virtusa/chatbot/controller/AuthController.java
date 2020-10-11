package com.virtusa.chatbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.chatbot.model.AuthProvider;
import com.virtusa.chatbot.model.ClientRegistrationModel;
import com.virtusa.chatbot.payload.AuthResponse;
import com.virtusa.chatbot.payload.LoginRequest;
import com.virtusa.chatbot.payload.SignUpRequest;
import com.virtusa.chatbot.repository.ClientRepo;
import com.virtusa.chatbot.security.TokenProvider;



@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ClientRepo userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenProvider tokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = tokenProvider.createToken(authentication);
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpRequest signUpRequest) {
    	
    	
    	ClientRegistrationModel user=userRepository.findByMail(signUpRequest.getEmail());
    	
    	ClientRegistrationModel ac=userRepository.findByAccno(signUpRequest.getAccno());
        /*if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new BadRequestException("Email address already in use.");
        }*/
    	
    	if(user!=null&& user.getProvider().equals(AuthProvider.google)) {
    		
    		//System.out.print(user.getProvider()+" aksklsl   ");
    		 //user.setPassword(signUpRequest.getPassword());
    	        user.setPhnumber(signUpRequest.getPhnumber());
    	        user.setAccno(signUpRequest.getAccno());
    	        user.setProvider(AuthProvider.google);
    	        user.setFirstname(signUpRequest.getFirstname());
    	        user.setLastname(signUpRequest.getLastname());
    	        user.setRegistered(true);
    	        userRepository.save(user);
            //throw new BadRequestException("Email address already in use.");
        }
    	else if(user!=null||ac!=null)
    	{
    		//throw new BadRequestException("Email address already in use.");
    		 return ResponseEntity.ok("Email address already in use.");
    	}
    	else
    	{
        // Creating user's account
        //ClientRegistrationModel
        user = new ClientRegistrationModel();
        user.setFirstname(signUpRequest.getFirstname());
        user.setLastname(signUpRequest.getLastname());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(signUpRequest.getPassword());
        user.setPhnumber(signUpRequest.getPhnumber());
        user.setAccno(signUpRequest.getAccno());
        user.setProvider(AuthProvider.local);
        user.setRegistered(true);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        
        System.out.print(user.getProvider()+" new user");
    	}

        //ClientRegistrationModel result = userRepository.save(user);
/*
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/home/user")
                .buildAndExpand(result.getId()).toUri();*/

        return ResponseEntity.ok(user);
        		//created(location)
                //.body(new ApiResponse(true, "User registered successfully"));
    }

}


