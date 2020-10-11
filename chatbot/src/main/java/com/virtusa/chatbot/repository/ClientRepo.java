package com.virtusa.chatbot.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.virtusa.chatbot.model.ClientRegistrationModel;

@Repository
public interface ClientRepo extends MongoRepository<ClientRegistrationModel, String> {
	
	/*@Query("{'email' : ?0}")
	public ClientRegistrationModel findByMail(String email);*/
	
	
	@Query("{accno : ?0}")
	public ClientRegistrationModel findByAccno(String accno);
	
	 Boolean existsByEmail(String email);
	 
	// Boolean existsByAccno(String accno);
	 @Query("{'email' : ?0}")
	public ClientRegistrationModel findByMail(String email);


	 @Query("{'email' : ?0}")
	public Optional<ClientRegistrationModel> findByEmail(String email);

}
