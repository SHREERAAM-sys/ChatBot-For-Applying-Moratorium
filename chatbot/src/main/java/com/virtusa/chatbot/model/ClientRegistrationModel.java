package com.virtusa.chatbot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")

public class ClientRegistrationModel {

	@Id
	private String id;
	
	



	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String phnumber;
	private String accno;
	private AuthProvider provider;
	private String providerId;
	private Boolean emailVerified = false;
	private Boolean registered = false;
	private Boolean chatbotconvo = false;
	private Boolean applied = true;
	private Boolean adminVerified=false;
	private Boolean adminApproval=false;
	
	public Boolean getAdminVerified() {
		return adminVerified;
	}




	public void setAdminVerified(Boolean adminVerified) {
		this.adminVerified = adminVerified;
	}




	public Boolean getAdminApproval() {
		return adminApproval;
	}




	public void setAdminApproval(Boolean adminApproval) {
		this.adminApproval = adminApproval;
	}


	
	public Boolean getRegistered() {
		return registered;
	}




	public void setRegistered(Boolean registered) {
		this.registered = registered;
	}




	public Boolean getChatbotconvo() {
		return chatbotconvo;
	}




	public void setChatbotconvo(Boolean chatbotconvo) {
		this.chatbotconvo = chatbotconvo;
	}




	public Boolean getApplied() {
		return applied;
	}




	public void setApplied(Boolean applied) {
		this.applied = applied;
	}

	
	public AuthProvider getProvider() {
		return provider;
	}




	public void setProvider(AuthProvider provider) {
		this.provider = provider;
	}




	public String getProviderId() {
		return providerId;
	}




	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}


	public Boolean getEmailVerified() {
		return emailVerified;
	}




	public void setEmailVerified(Boolean emailVerified) {
		this.emailVerified = emailVerified;
	}




	public void setId(String id) {
		this.id = id;
	}




	
	
	
	
	
	/*public ClientRegistrationModel(String firstname, String lastname, String email, String password,String phnumber, String accno) {
		// TODO Auto-generated constructor stub
		super();
		this.firstname=firstname;
		this.lastname=lastname;
		this.email=email;
		this.password=password;
		this.phnumber=phnumber;
		this.accno=accno;
	}*/




	public String getFirstname() {
		return firstname;
	}




	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}




	public String getId() {
		return id;
	}




	public String getPassword() {
		return password;
	}




	public String getLastname() {
		return lastname;
	}




	public void setLastname(String lastname) {
		this.lastname = lastname;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPhnumber() {
		return phnumber;
	}




	public void setPhnumber(String phnumber) {
		this.phnumber = phnumber;
	}




	public String getAccno() {
		return accno;
	}




	public void setAccno(String accno) {
		this.accno = accno;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String toString()
	{
		return email+" "+firstname+" "+lastname+" "+accno+" "+password;
	
		
	}




	




	
}
