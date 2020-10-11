package com.virtusa.chatbotAD.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "admin")

public class AdminModel {

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




	private Boolean emailVerified = false;
	
	
	
	
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
