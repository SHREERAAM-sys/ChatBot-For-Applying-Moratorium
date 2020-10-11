package com.virtusa.chatbot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "response")

public class QandAModel {
	
	@Id
	private String id;
	
	private String email;
	
	private String Question_1;
	private String Response_1;
	
	private String Question_2;
	private String Response_2;
	
	private String Question_3;
	private String Response_3;
	
	private String Question_4;
	private String Response_4;
	
	private String Question_5;
	private String Response_5;
	
	private String Question_6;
	private String Response_6;
	
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQuestion_1() {
		return Question_1;
	}
	public void setQuestion_1(String question_1) {
		Question_1 = question_1;
	}
	public String getResponse_1() {
		return Response_1;
	}
	public void setResponse_1(String response_1) {
		Response_1 = response_1;
	}
	public String getQuestion_2() {
		return Question_2;
	}
	public void setQuestion_2(String question_2) {
		Question_2 = question_2;
	}
	public String getResponse_2() {
		return Response_2;
	}
	public void setResponse_2(String response_2) {
		Response_2 = response_2;
	}
	public String getQuestion_3() {
		return Question_3;
	}
	public void setQuestion_3(String question_3) {
		Question_3 = question_3;
	}
	public String getResponse_3() {
		return Response_3;
	}
	public void setResponse_3(String response_3) {
		Response_3 = response_3;
	}
	public String getQuestion_4() {
		return Question_4;
	}
	public void setQuestion_4(String question_4) {
		Question_4 = question_4;
	}
	public String getResponse_4() {
		return Response_4;
	}
	public void setResponse_4(String response_4) {
		Response_4 = response_4;
	}
	public String getQuestion_5() {
		return Question_5;
	}
	public void setQuestion_5(String question_5) {
		Question_5 = question_5;
	}
	public String getResponse_5() {
		return Response_5;
	}
	public void setResponse_5(String response_5) {
		Response_5 = response_5;
	}
	public String getQuestion_6() {
		return Question_6;
	}
	public void setQuestion_6(String question_6) {
		Question_6 = question_6;
	}
	public String getResponse_6() {
		return Response_6;
	}
	public void setResponse_6(String response_6) {
		Response_6 = response_6;
	}
	
	

}
