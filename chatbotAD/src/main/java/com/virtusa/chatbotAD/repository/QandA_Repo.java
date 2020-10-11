package com.virtusa.chatbotAD.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.virtusa.chatbotAD.model.QandAModel;

public interface QandA_Repo extends MongoRepository<QandAModel, String> {
	
	@Query("{'email' : ?0}")
	public QandAModel findByClientMail(String email);

}
