package com.virtusa.chatbotAD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.virtusa.chatbot.service.ClientService;
import com.virtusa.chatbotAD.exception.ResourceNotFoundException;
import com.virtusa.chatbotAD.model.AdminModel;
import com.virtusa.chatbotAD.repository.AdminRepo;
import com.virtusa.chatbotAD.security.CurrentUser;
import com.virtusa.chatbotAD.security.UserPrincipal;




@RestController
@RequestMapping("/user")
public class ClientController {
	
	@Autowired
    private AdminRepo repo;

    @GetMapping("/me")
   // @PreAuthorize("hasRole('USER')")
    public AdminModel getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return repo.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
	
}
/*@RestController
//@CrossOrigin(origins = "*")
public class ClientController {
	
	@Autowired
	private ClientService serve;
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/register")
	//public String create(@RequestParam String firstname,@RequestParam String lastname,@RequestParam String email,@RequestParam String password,@RequestParam String phnumber,@RequestParam String accno)
	public String create(@RequestBody ClientRegistrationModel obj)
	{
		
		String firstname=obj.getFirstname();
		String lastname=obj.getLastname();
		String email=obj.getEmail();
		String password=obj.getPassword();
		String phnumber=obj.getPhnumber();
		String accno=obj.getAccno();
		if(email!=null && email.compareTo("")!=0)
		{
		ClientRegistrationModel objem= serve.findByMail(email);
		ClientRegistrationModel objaccno=serve.findByAccno(accno);
		
		if(objem!=null){return "user with email"+email+"already exists";}
		if(objaccno!=null)
		{return "this account already exists";}
		
		ClientRegistrationModel obj1=serve.create(firstname, lastname, email, password,phnumber, accno);
		return obj1.toString();
		}
		else 
		{
			return "enter valid credentials";
		}
		
	}
	
	//@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/login")
	//public String loginUser(@RequestParam String email,@RequestParam String password)
	public String loginUser(@RequestBody ClientRegistrationModel obj)
	{
		ClientRegistrationModel pass=serve.findByMail(obj.getEmail());
		String p=obj.getPassword();
		if( p.compareTo(pass.getPassword())==0)
		{
			//return pass.getId();
			
			return "login sucess";
		}
		else 
		{
			return "invalid credentials";
		}
		
	}

}*/
