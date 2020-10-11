package com.virtusa.chatbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.chatbot.model.ClientRegistrationModel;
import com.virtusa.chatbot.repository.ClientRepo;
import com.virtusa.chatbot.security.CurrentUser;
import com.virtusa.chatbot.security.UserPrincipal;


@RestController
@RequestMapping("/chat")
public class BotController {
	
	
	
	 @Autowired
	 private ClientRepo userRepository;

	@GetMapping("/conversation")
    public ResponseEntity<ClientRegistrationModel> setConvo(@CurrentUser UserPrincipal userPrincipal) {
		
		
		
		ClientRegistrationModel user=userRepository.findByMail(userPrincipal.getEmail());
		
		if(user!=null)
		{
			//System.out.print(botRequest.getEmail());
			user.setChatbotconvo(true);
			userRepository.save(user);
			return ResponseEntity.ok(user);
					//("conversation assigned sucessfully");
		}
    	
		return ResponseEntity.ok(user);
	}
	
    	

}
