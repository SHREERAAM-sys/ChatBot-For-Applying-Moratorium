package com.virtusa.chatbotAD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.chatbotAD.model.ClientRegistrationModel;
import com.virtusa.chatbotAD.model.QandAModel;
import com.virtusa.chatbotAD.repository.ClientRepo;
import com.virtusa.chatbotAD.repository.QandA_Repo;
import com.virtusa.chatbotAD.service.ClientService;
	

@RestController
@RequestMapping("/response")
public class QuestionAnswerController {
	
	@Autowired
	private ClientService serve;
	
	@Autowired
	private ClientRepo userRepo;
	
	
	@Autowired
	private QandA_Repo repo;
	
	
	 @GetMapping("/all/user")
	 public ResponseEntity<?> findAll()
	 {
		 return ResponseEntity.ok(serve.findAllResponse());
	 }
	 
	 @GetMapping("/admin/actepted")
	 public  ResponseEntity<?> adminAccepted(@RequestParam(required = true) String email)
	 {	
		 //Moratorium accepted
		 
		 if(email!=null)
		 {
		 
		 ClientRegistrationModel user=userRepo.findByMail(email);
		 
		 QandAModel resp=repo.findByClientMail(email);
		 
		 if(user!=null && resp!=null)
		 {
			 user.setAdminVerified(true);
			 user.setAdminApproval(true);
			 
			 resp.setAdminVerified(true);
			 resp.setAdminApproval(true);
			 
			 userRepo.save(user);
			 repo.save(resp);
			 
			 return ResponseEntity.ok(resp);
		 }
		 
		 return ResponseEntity.ok("user not found");
	 }
	 	return ResponseEntity.ok("Empty Request");
	 	
}
		 
		 
		 @GetMapping("/admin/decline")
		 public  ResponseEntity<?> adminDecline(@RequestParam(required = true) String email)
		 {	
			 //Moratorium accepted
			
			 if(email!=null)
			 {
			 ClientRegistrationModel user=userRepo.findByMail(email);
			 
			 QandAModel resp=repo.findByClientMail(email);
			 
			 if(user!=null && resp!=null)
			 {
				 user.setAdminVerified(true);
				 user.setAdminApproval(false);
				 
				 resp.setAdminVerified(true);
				 resp.setAdminApproval(false);
				 
				 userRepo.save(user);
				 repo.save(resp);
				 
				 return ResponseEntity.ok(resp);
			 }
			 return ResponseEntity.ok("user not found");
			 
			 
			 }
		 
		 
			 return ResponseEntity.ok("Empty Request");
	 }

    
		
}
