package com.virtusa.chatbotAD.security.oauth2.user;

import java.util.Map;

import com.virtusa.chatbotAD.security.oauth2.user.OAuth2UserInfo;

public class GoogleOauth2UserInfo extends OAuth2UserInfo{
	
	public GoogleOauth2UserInfo(Map<String, Object> attributes) {
		super(attributes);
	}

    @Override
    public String getId() {
        return (String) attributes.get("sub");
    }

   

    @Override
	public String getFirstname() {
		// TODO Auto-generated method stub
		//return null;
    	 return (String) attributes.get("firstname");
	}

	@Override
	public String getLastname() {
		// TODO Auto-generated method stub
		//return null;
		 return (String) attributes.get("lastname");
	}

	@Override
    public String getEmail() {
        return (String) attributes.get("email");
    }

   
}
