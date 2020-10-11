package com.virtusa.chatbotAD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.chatbotAD.exception.ResourceNotFoundException;
import com.virtusa.chatbotAD.model.AdminModel;
import com.virtusa.chatbotAD.repository.AdminRepo;
import com.virtusa.chatbotAD.security.CurrentUser;
import com.virtusa.chatbotAD.security.UserPrincipal;
import com.virtusa.chatbotAD.service.ClientService;

@RestController

public class HomeController {
	
	
	@Autowired
    private AdminRepo userRepository;
	
	@Autowired
	private ClientService  serv;

    @GetMapping("/home/user")
    //@PreAuthorize("hasRole('USER')")
    public AdminModel getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
    
    @GetMapping("/user/details")
    public ResponseEntity<?> findAll()
    {
    	return ResponseEntity.ok(serv.findAll());
    }

}
