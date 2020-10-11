package com.virtusa.chatbot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.chatbot.model.QandAModel;
import com.virtusa.chatbot.repository.QandA_Repo;

@Service
public class ClientService {
	
	
	
	
	
	public QandAModel data()
	{
		
		 	QandAModel model=new QandAModel();
			//model.setEmail(userPrincipal.getEmail());
			model.setQuestion_1("Have you applied for Moratorium");
			model.setResponse_1("yes");
			model.setQuestion_2("What is your type of occupation?  ");
			model.setResponse_2("Salaried");
			model.setQuestion_3("Did you avail moratorium for the period of june,july,august?");
			model.setResponse_3("Yes,for some of my loans");
			model.setQuestion_4("Is your work/business currently operational?");
			model.setResponse_4("Yes operational");
			model.setQuestion_5("Would you have enough cash to service the overhead expenses?");
			model.setResponse_5("No i don't");
			model.setQuestion_6("When do you expect to recover financially to service all your obligations/EMI?");
			model.setResponse_6("After 6 months");
	        return model;

		
		
	}

	
	
}
