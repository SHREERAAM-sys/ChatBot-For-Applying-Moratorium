package com.virtusa.chatbot.security.oauth2.user;

import java.util.Map;

import com.virtusa.chatbot.exception.OAuth2AuthenticationProcessingException;
import com.virtusa.chatbot.model.AuthProvider;

public class OAuth2UserInfoFactory {

    public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        if(registrationId.equalsIgnoreCase(AuthProvider.google.toString())) {
            return new GoogleOauth2UserInfo(attributes);
        } 
        else {
            throw new OAuth2AuthenticationProcessingException("Sorry! Login with " + registrationId + " is not supported yet.");
        }
    }


}