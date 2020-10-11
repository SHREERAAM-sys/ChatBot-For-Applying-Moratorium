package com.virtusa.chatbot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.chatbot.exception.ResourceNotFoundException;
import com.virtusa.chatbot.model.ClientRegistrationModel;
import com.virtusa.chatbot.repository.ClientRepo;

@Service
public class CustomerUserDetailsService implements UserDetailsService{
	
	    @Autowired
	    ClientRepo repo;
	
	    @Override
	    @Transactional
	    public UserDetails loadUserByUsername(String email)
	            throws UsernameNotFoundException {
	        ClientRegistrationModel user = repo.findByEmail(email).orElseThrow(() ->
	                        new UsernameNotFoundException("User not found with email : " + email)
	        );

	        return UserPrincipal.create(user);
	    }

	    @Transactional
	    public UserDetails loadUserById(String id) {
	        ClientRegistrationModel user = repo.findById(id).orElseThrow(
	            () -> new ResourceNotFoundException("User", "id", id)
	        );

	        return UserPrincipal.create(user);
	    }

}
