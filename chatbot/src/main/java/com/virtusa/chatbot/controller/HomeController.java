package com.virtusa.chatbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.chatbot.exception.ResourceNotFoundException;
import com.virtusa.chatbot.model.ClientRegistrationModel;
import com.virtusa.chatbot.repository.ClientRepo;
import com.virtusa.chatbot.security.CurrentUser;
import com.virtusa.chatbot.security.UserPrincipal;



@RestController
@RequestMapping("/home")
public class HomeController {
	
	
	@Autowired
    private ClientRepo userRepository;

    @GetMapping("/user")
    public ClientRegistrationModel getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
    

}
