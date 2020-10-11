package com.virtusa.chatbotAD.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.chatbotAD.exception.ResourceNotFoundException;
import com.virtusa.chatbotAD.model.AdminModel;
import com.virtusa.chatbotAD.repository.AdminRepo;

@Service
public class CustomerUserDetailsService implements UserDetailsService{
	
	    @Autowired
	    AdminRepo repo;
	
	    @Override
	    @Transactional
	    public UserDetails loadUserByUsername(String email)
	            throws UsernameNotFoundException {
	        AdminModel user = repo.findByEmail(email).orElseThrow(() ->
	                        new UsernameNotFoundException("User not found with email : " + email)
	        );

	        return UserPrincipal.create(user);
	    }

	    @Transactional
	    public UserDetails loadUserById(String id) {
	        AdminModel user = repo.findById(id).orElseThrow(
	            () -> new ResourceNotFoundException("User", "id", id)
	        );

	        return UserPrincipal.create(user);
	    }

}
