package com.virtusa.chatbot.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.virtusa.chatbot.model.QandAModel;

public interface QandA_Repo extends MongoRepository<QandAModel, String> {
	
	@Query("{'email' : ?0}")
	public QandAModel findByMail(String email);

}
