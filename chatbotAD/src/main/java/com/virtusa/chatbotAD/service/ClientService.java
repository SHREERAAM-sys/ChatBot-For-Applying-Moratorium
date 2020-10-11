package com.virtusa.chatbotAD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.chatbotAD.model.ClientRegistrationModel;
import com.virtusa.chatbotAD.model.QandAModel;
import com.virtusa.chatbotAD.repository.ClientRepo;
import com.virtusa.chatbotAD.repository.QandA_Repo;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepo repo;
	@Autowired
	private QandA_Repo rep;
	
	
	
	//finding valid email or not
	public ClientRegistrationModel findByMail(String email)
	{
		return repo.findByMail(email);
	}

	public ClientRegistrationModel findByAccno(String accno) {
		// TODO Auto-generated method stub
		return repo.findByAccno(accno);
	}
	
	public List<ClientRegistrationModel> findAll()
	{
		return repo.findAll();
	}
	
	public List<QandAModel> findAllResponse()
	{
		return rep.findAll();
	}
	
}
