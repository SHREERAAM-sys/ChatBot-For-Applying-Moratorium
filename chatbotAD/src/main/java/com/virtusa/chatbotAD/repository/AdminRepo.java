package com.virtusa.chatbotAD.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.virtusa.chatbotAD.model.AdminModel;

@Repository
public interface AdminRepo extends MongoRepository<AdminModel, String> {
	
	/*@Query("{'email' : ?0}")
	public ClientRegistrationModel findByMail(String email);*/
	
	
	@Query("{accno : ?0}")
	public AdminModel findByAccno(String accno);
	
	 Boolean existsByEmail(String email);
	 
	 Boolean existsByAccno(String accno);

	 @Query("{'email' : ?0}")
	public Optional<AdminModel> findByEmail(String email);

}
