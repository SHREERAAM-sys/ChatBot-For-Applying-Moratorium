package com.virtusa.chatbotAD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.virtusa.chatbotAD.config.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)

public class ChatbotADApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatbotADApplication.class, args);
	}

}
