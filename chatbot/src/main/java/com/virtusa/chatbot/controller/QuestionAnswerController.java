package com.virtusa.chatbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.chatbot.model.QandAModel;
import com.virtusa.chatbot.repository.QandA_Repo;
import com.virtusa.chatbot.security.CurrentUser;
import com.virtusa.chatbot.security.UserPrincipal;
import com.virtusa.chatbot.service.ClientService;
	

@RestController
@RequestMapping("/response")
public class QuestionAnswerController {
	
	
	
	@Autowired
	private ClientService serve;
	
	
	
	
	
	@Autowired
	private QandA_Repo rep;
	
	
	@GetMapping("/user")
	public  ResponseEntity<QandAModel>  response(@CurrentUser UserPrincipal userPrincipal) {
				
		System.out.print("user response backend called");
				QandAModel QAM=rep.findByMail(userPrincipal.getEmail());
						
				if(QAM==null)
				{
				QAM=new QandAModel();
				QAM=serve.data();
        		
        		QAM.setEmail(userPrincipal.getEmail());
        		rep.save(QAM);
				}
        		
        		return ResponseEntity.ok(QAM);
		        		
	}
        		

}
