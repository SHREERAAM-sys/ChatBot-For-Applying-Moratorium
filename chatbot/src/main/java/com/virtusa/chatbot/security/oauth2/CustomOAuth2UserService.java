package com.virtusa.chatbot.security.oauth2;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.nimbusds.oauth2.sdk.util.StringUtils;
import com.virtusa.chatbot.exception.OAuth2AuthenticationProcessingException;
import com.virtusa.chatbot.model.AuthProvider;
import com.virtusa.chatbot.model.ClientRegistrationModel;
import com.virtusa.chatbot.repository.ClientRepo;
import com.virtusa.chatbot.security.UserPrincipal;
import com.virtusa.chatbot.security.oauth2.user.OAuth2UserInfo;
import com.virtusa.chatbot.security.oauth2.user.OAuth2UserInfoFactory;


@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService{
	
	@Autowired
    private ClientRepo userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);

        try {
            return processOAuth2User(oAuth2UserRequest, oAuth2User);
        } catch (AuthenticationException ex) {
            throw ex;
        } catch (Exception ex) {
        	
               throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
        }
    }

    private OAuth2User processOAuth2User(OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User) {
        OAuth2UserInfo oAuth2UserInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(oAuth2UserRequest.getClientRegistration().getRegistrationId(), oAuth2User.getAttributes());
 
        if(StringUtils.isBlank(oAuth2UserInfo.getEmail())){
            throw new OAuth2AuthenticationProcessingException("Email not found from OAuth2 provider");
        }

        Optional<ClientRegistrationModel> userOptional = userRepository.findByEmail(oAuth2UserInfo.getEmail());
        ClientRegistrationModel user;
        if(userOptional.isPresent()) {
            user = userOptional.get();
            if(!user.getProvider().equals(AuthProvider.valueOf(oAuth2UserRequest.getClientRegistration().getRegistrationId()))) {
                throw new OAuth2AuthenticationProcessingException("Looks like you're signed up with " +
                        user.getProvider() + " account. Please use your " + user.getProvider() +
                        " account to login.");
            }
            user = updateExistingUser(user, oAuth2UserInfo);
        } else {
            user = registerNewUser(oAuth2UserRequest, oAuth2UserInfo);
        }

        return UserPrincipal.create(user, oAuth2User.getAttributes());
    }

    private ClientRegistrationModel registerNewUser(OAuth2UserRequest oAuth2UserRequest, OAuth2UserInfo oAuth2UserInfo) {
        ClientRegistrationModel user = new ClientRegistrationModel();

        user.setProvider(AuthProvider.valueOf(oAuth2UserRequest.getClientRegistration().getRegistrationId()));
        //getRegistrationId()
        user.setProviderId(oAuth2UserInfo.getId());
       //user.setFirstname(oAuth2UserInfo.getFirstname());
       // user.setLastname(oAuth2UserInfo.getLastname());
        user.setEmail(oAuth2UserInfo.getEmail());
        
        System.out.print(oAuth2UserInfo.getFirstname()+"\n"+oAuth2UserInfo.getLastname()+"\n"+oAuth2UserInfo);
       
       
        return userRepository.save(user);
    }

    private ClientRegistrationModel updateExistingUser(ClientRegistrationModel existingUser, OAuth2UserInfo oAuth2UserInfo) {
       // existingUser.setFirstname(oAuth2UserInfo.getFirstname());
        //existingUser.setLastname(oAuth2UserInfo.getLastname());
       
        return userRepository.save(existingUser);
    }


}
